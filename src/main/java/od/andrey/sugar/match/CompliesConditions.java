package od.andrey.sugar.match;

import od.andrey.sugar.match.interfaces.Condition;
import od.andrey.sugar.match.interfaces.Action1;
import od.andrey.sugar.match.interfaces.Action2;
import od.andrey.sugar.match.interfaces.Action3;
import od.andrey.sugar.match.interfaces.Action4;
import od.andrey.sugar.match.interfaces.Action5;
import od.andrey.sugar.match.interfaces.Action6;
import od.andrey.sugar.match.interfaces.Action7;
import od.andrey.sugar.match.interfaces.Action8;
import od.andrey.sugar.match.interfaces.Action9;
import od.andrey.sugar.match.interfaces.Action10;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class CompliesConditions<T, R> {
    private final Condition<T>[] conditions;

    public CompliesConditions(Condition<T>[] conditions) {
        this.conditions = conditions;
    }

    public CompliesCase then(Action1 action) {
        return new CompliesCase<T, R>(conditions, action, 1);
    }

    public CompliesCase then(Action2 action) {
        return new CompliesCase<T, R>(conditions, action, 2);
    }

    public CompliesCase then(Action3 action) {
        return new CompliesCase<T, R>(conditions, action, 3);
    }

    public CompliesCase then(Action4 action) {
        return new CompliesCase<T, R>(conditions, action, 4);
    }

    public CompliesCase then(Action5 action) {
        return new CompliesCase<T, R>(conditions, action, 5);
    }

    public CompliesCase then(Action6 action) {
        return new CompliesCase<T, R>(conditions, action, 6);
    }

    public CompliesCase then(Action7 action) {
        return new CompliesCase<T, R>(conditions, action, 7);
    }

    public CompliesCase then(Action8 action) {
        return new CompliesCase<T, R>(conditions, action, 8);
    }

    public CompliesCase then(Action9 action) {
        return new CompliesCase<T, R>(conditions, action, 9);
    }

    public CompliesCase then(Action10 action) {
        return new CompliesCase<T, R>(conditions, action, 10);
    }
}
