package local.nix.forward.linked.list.test;

import local.nix.forward.linked.list.util.list.ForwardLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForwardLinkedListTest {

    List<Integer> list = new ForwardLinkedList<>();

    @BeforeEach
    public void listInitialization() {

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }


    @Test
    public void addMethodTest() {

        assertEquals(list.size(), 4);

    }

    @Test
    public void setMethodTest() {

        assertEquals(list.get(2), 4);

        list.set(2, 8);

        assertEquals(list.get(2), 8);

    }

    @Test
    public void addAtSpecifiedPositionMethodTest() {

        int currentSize = list.size();
        assertEquals(list.get(0), 2);

        list.add(0, 7);
        int newSize = list.size();

        assertEquals(list.get(0), 7);
        assertEquals(list.get(1), 2);
        assertEquals(newSize - currentSize, 1);


    }

    @Test
    public void sizeMethodTest() {

        assertEquals(list.size(), 4);

    }

    @Test
    public void getMethodTest() {

        assertEquals(list.get(1), 3);
    }

    @Test
    public void containsMethodTest() {

        assertEquals(list.contains(3), true);
    }

    @Test
    public  void removeMethodTest() {

        list.remove(3);
        assertEquals(list.size(), 3);
    }

    @Test
    public void clearMethodTest() {

        list.clear();
        assertEquals(list.size(), 0);
    }


}
