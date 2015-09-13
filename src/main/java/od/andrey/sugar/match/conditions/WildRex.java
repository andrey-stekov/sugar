package od.andrey.sugar.match.conditions;

/**
 * Created by andrey on 13.09.2015.
 */
public class WildRex<T> extends Rex<T> implements WildCard {
    public WildRex(String rex) {
        super(rex);
    }
}
