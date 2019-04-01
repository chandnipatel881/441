import java.util.HashMap;

public class C1Q6 {

    public static boolean isPermutationPalindrome(String str){
        if(str == null) {
            return true;
        }
        HashMap<Character,Integer> map = C1Q4.addToHashMap(str);

        int numOfOdds = 0;
        for(Character c : map.keySet()){
            if(numOfOdds > 1 && str.length() % 2 != 0){
                return false;
            }
            if(map.get(c) % 2 != 0){
                if(str.length() % 2 == 0){
                    return false;
                }
                numOfOdds++;
            }
        }
        return true;
    }

}
