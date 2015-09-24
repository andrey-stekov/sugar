package od.andrey.sugar.match;

import od.andrey.sugar.match.conditions.Tail;
import od.andrey.sugar.match.conditions.WildCard;
import od.andrey.sugar.match.conditions.WildTail;
import od.andrey.sugar.match.interfaces.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class CompliesCase<T, R> implements Case<T, R> {
    private final Condition<T>[] conditions;
    private final Action<T, R> action;
    private final int numberOfArguments;

    public CompliesCase(Condition<T>[] conditions, Action<T, R> action, int numberOfArguments) {
        this.conditions = conditions;
        this.action = action;
        this.numberOfArguments = numberOfArguments;
    }

    private boolean checkConditions(List<T> args, List<T> substitutionArgs, int lastIndex) {
        int i = 0;

        for(T arg : args) {
            Condition<T> condition = conditions[i++];

            if (condition.isSatisfied(arg)) {
                if (condition instanceof WildCard) {
                    substitutionArgs.add(arg);
                }
            } else {
                return false;
            }

            if (i == lastIndex) {
                break;
            }
        }

        return true;
    }

    private R callAction(List<T> agrs) {
        switch (numberOfArguments) {
            case 1:
                return ((Action1<T, R>)action).accept(agrs.get(0));
            case 2:
                return ((Action2<T, R>)action).accept(agrs.get(0), agrs.get(1));
            case 3:
                return ((Action3<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2));
            case 4:
                return ((Action4<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3));
            case 5:
                return ((Action5<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4));
            case 6:
                return ((Action6<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5));
            case 7:
                return ((Action7<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6));
            case 8:
                return ((Action8<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6), agrs.get(7));
            case 9:
                return ((Action9<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6), agrs.get(7), agrs.get(8));
            case 10:
                return ((Action10<T, R>)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6), agrs.get(7), agrs.get(8), agrs.get(9));
            default:
                throw new RuntimeException("Illegal number of arguments: " + numberOfArguments);
        }
    }

    @Override
    public R matches(List<T> agrs) {
        int lastCondition = conditions.length;
        List<T> tail = null;

        if (conditions[conditions.length - 1] instanceof Tail) {
            if (conditions[conditions.length - 1] instanceof WildTail) {
                tail = agrs.subList(conditions.length - 1, agrs.size());
                lastCondition--;
            }
        }

        if (agrs.size() >= lastCondition) {
            List<T> substitutionArgs =  new ArrayList<>();
            if (checkConditions(agrs, substitutionArgs, lastCondition)) {
                if (tail != null) {
                    substitutionArgs.add((T) tail);
                }

                return callAction(substitutionArgs);
            }
        }
        return null;
    }
}
