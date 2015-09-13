package od.andrey.sugar.match.conditions;

import od.andrey.sugar.match.interfaces.Condition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andrey on 13.09.2015.
 */
public class Rex<T> implements Condition<T> {
    private final Pattern pattern;

    public Rex(String rex) {
        this.pattern = Pattern.compile(rex);
    }

    @Override
    public boolean isSatisfied(T arg) {
        Matcher matcher = pattern.matcher(arg.toString());
        return matcher.matches();
    }
}
