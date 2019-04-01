import java.util.HashMap;

public class C1Q4 {

    public static HashMap<Character,Integer> addToHashMap(String str){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 0);
            }
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        return map;
    }

    public static boolean isAnagram(String str1, String str2){
        if(str1 == null || str2 == null){
            return true;
        }
        HashMap<Character,Integer> map1 = addToHashMap(str1);
        HashMap<Character,Integer> map2 = addToHashMap(str2);

        if(map1.hashCode() == map2.hashCode()){
            return true;
        }
        return false;
    }
}
