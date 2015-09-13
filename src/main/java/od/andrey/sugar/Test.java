package od.andrey.sugar;

import java.util.ArrayList;
import java.util.List;

import static od.andrey.sugar.match.MatchLib.*;

/**
 * Created by ALemeshev on 08.09.2015.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);

        match(testList,
//                when(1, __, 3).then((a) -> {
//                    System.out.println("1 Second element is : " + a);
//                }),
//                when(any, __, any).then((a) -> {
//                    System.out.println("2 Second element is : " + a);
//                }),
                when(__, __tail).then((head, tail) -> {
                    System.out.println("3) head=" + head + ", tail = " + tail);
                }));
    }
}
