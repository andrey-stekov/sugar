package od.andrey.sugar.match.conditions;

import od.andrey.sugar.match.interfaces.Condition;

import java.util.function.Predicate;

/**
 * Created by andrey on 13.09.2015.
 */
public class Statement<T> implements Condition<T> {
    private final Predicate<? super T> predicate;

    public Statement(Predicate<? super T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean isSatisfied(T arg) {
        return predicate.test(arg);
    }
}
