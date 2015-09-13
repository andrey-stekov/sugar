package od.andrey.sugar.match.conditions;

import od.andrey.sugar.match.interfaces.Condition;

/**
 * Created by andrey on 13.09.2015.
 */
public class Tail<T> implements Condition<T> {
    @Override
    public boolean isSatisfied(T arg) {
        throw new RuntimeException("Should not be called!!!");
    }
}
