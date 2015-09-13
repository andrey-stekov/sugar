package od.andrey.sugar.match.conditions;

import java.util.function.Predicate;

/**
 * Created by andrey on 13.09.2015.
 */
public class WildStatement<T> extends Statement<T> implements WildCard {
    public WildStatement(Predicate<? super T> predicate) {
        super(predicate);
    }
}
