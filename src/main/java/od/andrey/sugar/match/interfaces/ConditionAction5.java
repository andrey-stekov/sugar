package od.andrey.sugar.match.interfaces;

/**
 * Created by andrey on 08.09.2015.
 */
@FunctionalInterface
public interface ConditionAction5<T> extends ConditionAction<T> {
    void accept(T a, T b, T c, T d, T e);
}