package od.andrey.sugar.match.interfaces;

/**
 * Created by andrey on 08.09.2015.
 */
@FunctionalInterface
public interface Action2<T, R> extends Action<T, R> {
    R accept(T a, T b);
}
