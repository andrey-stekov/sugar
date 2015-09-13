package od.andrey.sugar.match.interfaces;

import java.util.List;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public interface Case<A, R> {
    R matches(List<A> agr);
}
