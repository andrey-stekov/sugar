package od.andrey.sugar.match.conditions;

/**
 * Created by andrey on 13.09.2015.
 */
public class WildEq<T> extends Eq<T> implements WildCard {
    public WildEq(T sample) {
        super(sample);
    }
}
