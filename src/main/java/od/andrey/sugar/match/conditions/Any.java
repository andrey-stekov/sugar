package od.andrey.sugar.match.conditions;

import od.andrey.sugar.match.interfaces.Condition;

/**
 * Created by andrey on 08.09.2015.
 */
public class Any<T> implements Condition<T> {
    @Override
    public boolean isSatisfied(T arg) {
        return true;
    }
}
