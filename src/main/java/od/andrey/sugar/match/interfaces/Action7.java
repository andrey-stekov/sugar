package od.andrey.sugar.match.interfaces;

/**
 * Created by andrey on 08.09.2015.
 */
@FunctionalInterface
public interface Action7<T, R> extends Action<T, R> {
    R accept(T a, T b, T c, T d, T e, T f, T g);
}
