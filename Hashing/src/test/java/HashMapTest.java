import static org.testng.Assert.*;

public class HashMapTest {

    HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

    @org.testng.annotations.Test
    public void testPut() {

        hashmap.put(1,"chandni");
        hashmap.put(2,"gaurang");
        hashmap.put(3,"bhatt");
        hashmap.put(10,"whatever");
        hashmap.put(4,"bhatt");
        hashmap.put(5,"bhatt1");
        hashmap.put(5,"bhatt2");
        hashmap.put(6,"bhatt3");
        hashmap.put(7,"bhatt4");
        hashmap.put(14,"bhatt5");
        hashmap.put(15,"bhatt6");

        String value1 = hashmap.find(14);
        assertEquals(value1,"bhatt5");

        String value2 = hashmap.find(18);
        assertEquals(value2,null);

        String value3 = hashmap.find(5);
        assertEquals(value3, "bhatt2");

        hashmap.remove(25);
        hashmap.remove(15);

        hashmap.put(15,"what");
        hashmap.put(26,"why");
        hashmap.put(27,"how");
        hashmap.put(28,"when");
        hashmap.put(29,"kyu");
        hashmap.put(30,"kyu");
        hashmap.put(31,"kyu");
        hashmap.put(32,"kyu");
        hashmap.put(33,"kyu");





    }

}