package od.andrey.sugar.match.interfaces;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public interface Condition<T> {
    boolean isSatisfied(T arg);
}
