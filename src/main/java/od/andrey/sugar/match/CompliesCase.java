package od.andrey.sugar.match;

import od.andrey.sugar.match.interfaces.Case;
import od.andrey.sugar.match.interfaces.Condition;
import od.andrey.sugar.match.interfaces.ConditionAction;

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

    @Override
    public Boolean matches(List<T> agr) {
        return null;
    }
}
