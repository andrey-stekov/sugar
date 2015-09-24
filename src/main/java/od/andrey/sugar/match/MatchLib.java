package od.andrey.sugar.match;

import od.andrey.sugar.match.conditions.*;
import od.andrey.sugar.match.interfaces.Case;
import od.andrey.sugar.match.interfaces.Condition;
import od.andrey.sugar.tuples.Pair;
import od.andrey.sugar.tuples.Triple;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class MatchLib {
    public static final Condition any = new Any<>();
    public static final Condition __ = new WildAny();

    public static final Condition tail = new Tail<>();
    public static final Condition __tail = new WildTail<>();

    public static <T> Condition<T> $(Predicate<? super T> statement) {
        return new Statement<>(statement);
    }

    public static <T> Condition<T> __$(Predicate<? super T> statement) {
        return new WildStatement<>(statement);
    }

    public static <T> Condition<T> eq(T sample) {
        return new Eq<>(sample);
    }

    public static <T> Condition<T> __eq(T sample) {
        return new WildEq<>(sample);
    }

    public static <T> Condition<T> rex(String rex) {
        return new Rex<>(rex);
    }

    public static <T> Condition<T> __rex(String rex) {
        return new WildRex<>(rex);
    }

    public static <T, R> R match(List<T> list, Case<T, R>... cases) {
        for (Case<T, R> currentCase : cases) {
            R tmpResult = currentCase.matches(list);
            if (tmpResult != null) {
                return tmpResult;
            }
        }

        return null;
    }

    public static <T, R> R match(Set<T> set, Case<T, R>... cases) {
        return match(new ArrayList<>(set), cases);
    }

    public static <T, R> R match(Map.Entry<T, T> mapEntry, Case<T, R>... cases) {
        return match(asList(mapEntry.getKey(), mapEntry.getValue()), cases);
    }

    public static <T, R> R match(Pair<T, T> pair, Case<T, R>... cases) {
        return match(asList(pair.first, pair.second), cases);
    }

    public static <T, R> R match(Triple<T, T, T> triple, Case<T, R>... cases) {
        return match(asList(triple.first, triple.second, triple.third), cases);
    }

    public static <T, R> R matchOne(T obj, Case<T, R>... cases) {
        return match(Collections.singletonList(obj), cases);
    }

    public static <T, R> CompliesConditions when(Object... conditions) {
        List<Condition<T>> conditionsList = new ArrayList<>(conditions.length);

        int index = 0;
        for (Object condition : conditions) {
            if (condition instanceof Condition) {
                conditionsList.add((Condition<T>) condition);
            } else if (condition instanceof Tail && index != conditions.length - 1) {
                throw new RuntimeException("You can use <tail> condition only as last condition");
            } else {
                conditionsList.add(new Eq<>((T) condition));
            }
            index++;
        }

        return new CompliesConditions<T, R>(conditionsList.toArray(new Condition[conditionsList.size()]));
    }
}
