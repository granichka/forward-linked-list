package local.nix.forward.linked.list.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import local.nix.forward.linked.list.util.StringListHandler;
import local.nix.forward.linked.list.util.list.ForwardLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringListHandlerTest {

    List<String> list = new ForwardLinkedList<String>();

    @BeforeEach
    public void listInitialization() {

        list.add("string 1 text");
        list.add("2 string 3 text");
        list.add("45");
    }

    @Test
    public void getNumbersFromStringFirstWayMethodTest() {

        assertEquals(StringListHandler.getNumbersFromStringFirstWay(list), 12345);

    }

    @Test
    public void getNumbersFromStringSecondWayMethodTest() {

        assertEquals(StringListHandler.getNumbersFromStringFirstWay(list), 12345);
    }

}
