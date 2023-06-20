package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = App.take(list1, 2);

        Assertions.assertEquals(list2.size(), 2);
        Assertions.assertEquals(list2.get(0), 1);
        Assertions.assertEquals(list2.get(1), 2);

        assertThat(list2)
            .isNotEmpty()
            .contains(1, 2)
            .hasSize(2);

        List<Integer> list3 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> list4 = App.take(list3, 8);

        Assertions.assertEquals(list4.size(), 3);
        Assertions.assertEquals(list4.containsAll(list3), true);

        assertThat(list3)
            .isNotEmpty()
            .contains(7, 3, 10)
            .hasSize(3);
        // END
    }
}
