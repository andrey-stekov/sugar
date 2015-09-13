package od.andrey.sugar.match.conditions;

import od.andrey.sugar.match.interfaces.Condition;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class Eq<T> extends Statement<T> {
    public Eq(T sample) {
        super((arg) -> sample == arg ||
                !(sample == null || arg == null || sample.getClass() != arg.getClass()) && sample.equals(arg));
    }
}
