package od.andrey.sugar.match;

import od.andrey.sugar.match.interfaces.Condition;
import od.andrey.sugar.match.interfaces.ConditionAction1;
import od.andrey.sugar.match.interfaces.ConditionAction2;
import od.andrey.sugar.match.interfaces.ConditionAction3;
import od.andrey.sugar.match.interfaces.ConditionAction4;
import od.andrey.sugar.match.interfaces.ConditionAction5;
import od.andrey.sugar.match.interfaces.ConditionAction6;
import od.andrey.sugar.match.interfaces.ConditionAction7;
import od.andrey.sugar.match.interfaces.ConditionAction8;
import od.andrey.sugar.match.interfaces.ConditionAction9;
import od.andrey.sugar.match.interfaces.ConditionAction10;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class CompliesConditions {
    private final Condition[] conditions;

    public CompliesConditions(Condition[] conditions) {
        this.conditions = conditions;
    }

    public CompliesCase then(ConditionAction1 action) {
        return new CompliesCase(conditions, action, 1);
    }

    public CompliesCase then(ConditionAction2 action) {
        return new CompliesCase(conditions, action, 2);
    }

    public CompliesCase then(ConditionAction3 action) {
        return new CompliesCase(conditions, action, 3);
    }

    public CompliesCase then(ConditionAction4 action) {
        return new CompliesCase(conditions, action, 4);
    }

    public CompliesCase then(ConditionAction5 action) {
        return new CompliesCase(conditions, action, 5);
    }

    public CompliesCase then(ConditionAction6 action) {
        return new CompliesCase(conditions, action, 6);
    }

    public CompliesCase then(ConditionAction7 action) {
        return new CompliesCase(conditions, action, 7);
    }

    public CompliesCase then(ConditionAction8 action) {
        return new CompliesCase(conditions, action, 8);
    }

    public CompliesCase then(ConditionAction9 action) {
        return new CompliesCase(conditions, action, 9);
    }

    public CompliesCase then(ConditionAction10 action) {
        return new CompliesCase(conditions, action, 10);
    }
}
