package od.andrey.sugar.match.conditions;

import od.andrey.sugar.match.interfaces.Condition;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class Eq<T> implements Condition<T> {
    private final T sample;

    public Eq(T sample) {
        this.sample = sample;
    }

    @Override
    public boolean isSatisfied(T arg) {
        return sample == arg ||
             !(sample == null || arg == null || sample.getClass() != arg.getClass()) && sample.equals(arg);

    }
}
