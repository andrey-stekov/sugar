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
public class CompliesCase<T> implements Case<T, Boolean> {
    private final Condition<T>[] conditions;
    private final ConditionAction action;
    private final int numberOfArguments;

    public CompliesCase(Condition<T>[] conditions, ConditionAction action, int numberOfArguments) {
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

    private void callAction(List<T> agrs) {
        switch (numberOfArguments) {
            case 1:
                ((ConditionAction1)action).accept(agrs.get(0));
                break;
            case 2:
                ((ConditionAction2)action).accept(agrs.get(0), agrs.get(1));
                break;
            case 3:
                ((ConditionAction3)action).accept(agrs.get(0), agrs.get(1), agrs.get(2));
                break;
            case 4:
                ((ConditionAction4)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3));
                break;
            case 5:
                ((ConditionAction5)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4));
                break;
            case 6:
                ((ConditionAction6)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5));
                break;
            case 7:
                ((ConditionAction7)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6));
                break;
            case 8:
                ((ConditionAction8)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6), agrs.get(7));
                break;
            case 9:
                ((ConditionAction9)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6), agrs.get(7), agrs.get(8));
                break;
            case 10:
                ((ConditionAction10)action).accept(agrs.get(0), agrs.get(1), agrs.get(2), agrs.get(3), agrs.get(4), agrs.get(5), agrs.get(6), agrs.get(7), agrs.get(8), agrs.get(9));
                break;
            default:
                throw new RuntimeException("Illegal number of arguments: " + numberOfArguments);
        }
    }

    @Override
    public Boolean matches(List<T> agrs) {
        int lastCondition = conditions.length;
        List<T> tail = null;

        if (conditions[conditions.length - 1] instanceof Tail) {
            if (conditions[conditions.length - 1] instanceof WildTail) {
                tail = agrs.subList(conditions.length - 1, agrs.size());
                lastCondition--;
            }
        }

        if (agrs.size() >= lastCondition) {
            List<T> substitutionArgs =  new ArrayList<T>();
            if (checkConditions(agrs, substitutionArgs, lastCondition)) {
                if (tail != null) {
                    substitutionArgs.add((T) tail);
                }

                callAction(substitutionArgs);
                return true;
            }
        }
        return false;
    }
}
