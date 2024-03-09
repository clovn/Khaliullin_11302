package hw2.test;


import hw2.MyHashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
    MyHashMap<String, Integer> map = new MyHashMap<>();

    @Before
    public void init(){
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
    }

    @Test
    public void testPutAndGet(){
        Assert.assertEquals(1, (int) map.get("one"));
        Assert.assertEquals(2, (int) map.get("two"));
        Assert.assertEquals(3, (int) map.get("three"));
    }

    @Test
    public void testContainsKey() {
        Assert.assertTrue(map.containsKey("one"));
        Assert.assertTrue(map.containsKey("two"));
        Assert.assertTrue(map.containsKey("three"));
        Assert.assertFalse(map.containsKey("four"));
    }

    @Test
    public void testRemove() {
        map.remove("one");
        Assert.assertFalse(map.containsKey("one"));
    }

    @Test
    public void testContainsValue() {
        Assert.assertTrue(map.containsValue(1));
        Assert.assertTrue(map.containsValue(2));
        Assert.assertTrue(map.containsValue(3));
        Assert.assertFalse(map.containsValue(4));
    }
}
