import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class C1Q1 {

    public static boolean isUnique(String str) {
        if (str == null) {
            return true;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        if (str == null) {
            return true;
        }
        char[] strChars = str.toCharArray();
        Arrays.sort(strChars);

        for(int i = 0; i < strChars.length - 1; i++){
            if(strChars[i] == strChars[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique3(String str) {
        if (str == null) {
            return true;
        }
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1 ; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUnique4(String str) {
        if (str == null) {
            return true;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int bitAtIndex = str.charAt(i) - 'a';
            if ((checker & (1 << bitAtIndex)) > 0) {
                return false;
            }
            checker = checker | (1 << bitAtIndex);
        }
        return true;
    }

}
