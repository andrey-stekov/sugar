package od.andrey.sugar.match;

import od.andrey.sugar.match.conditions.*;
import od.andrey.sugar.match.interfaces.Case;
import od.andrey.sugar.match.interfaces.Condition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class MatchLib {
    public static final Condition any = new Any<>();
    public static final Condition __ = new WildAny();

    public static <T> Condition<T> $(Predicate<? super T> statement) {
        return new Statement<>(statement);
    }

    public static <T> Condition<T> __$(Predicate<? super T> statement) {
        return new WildStatement<>(statement);
    }

    public static <T> void match(Collection<T> collection, Case<T, Boolean>... cases) {

    }

    public static <T> CompliesConditions when(Object... conditions) {
        List<Condition<T>> conditionsList = new ArrayList<>(conditions.length);

        for (Object condition : conditions) {
            if (condition instanceof Condition) {
                conditionsList.add((Condition<T>) condition);
            } else {
                conditionsList.add(new Eq<T>((T) condition));
            }
        }

        return new CompliesConditions(conditionsList.toArray(new Condition[conditionsList.size()]));
    }

    public static <T> Eq eq(T sample) {
        return new Eq<>(sample);
    }
}
