package hw2.test;

import org.example.MyList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {
    MyList<Integer> list = new MyList<>(20);

    @Before
    public void init(){
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void testAddAndGet() {
        Assert.assertEquals(1, (int) list.get(0));
        Assert.assertEquals(2, (int) list.get(1));
        Assert.assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testContains() {
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertFalse(list.contains(4));
    }

    @Test
    public void testRemove() {
        list.remove(1);
        Assert.assertFalse(list.contains(1));
    }

    @Test
    public void testGetByIndex() {
        Assert.assertEquals(1, (int) list.get(0));
        Assert.assertEquals(2, (int) list.get(1));
        Assert.assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testGetByValue() {
        Assert.assertEquals(0, list.getIndex(1));
        Assert.assertEquals(1, list.getIndex(2));
        Assert.assertEquals(-1, list.getIndex(4));
    }
}
