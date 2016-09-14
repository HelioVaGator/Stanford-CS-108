// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;


public class TabooTest {


    @Test
    public void testNoFollow1() {

    }


    @Test
    public void testReduce1() {
        ArrayList<String> list = new ArrayList<String>();
        list.add(0,"a");
        list.add(1, "c");
        list.add(2,"a");
        list.add(3, "b");


        ArrayList<String> testList = new ArrayList<String>();
        testList.add(0,"a");
        testList.add(1, "b");
        testList.add(2,"x");
        testList.add(3, "c");
        testList.add(4, "a");

        Taboo<String> taboo = new Taboo<String>(list);


        taboo.reduce(testList);

        ArrayList<String> result = new ArrayList<>();
        result.add(0, "a");
        result.add(1, "x");
        result.add(2, "c");

        assertEquals(testList, result);


    }
}
