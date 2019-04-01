import java.util.HashSet;

public class C1Q3 {

    public static void shiftLeft(char[] chars, int index){

        for(int i = index; i < chars.length - 1; i++){
            chars[i] = chars[i+1];
        }
        chars[chars.length-1] = ' ';
    }

    public static void removeDuplicate(char[] chars){

        if(chars == null) {
            return;
        }

        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < chars.length; i++){
            if(set.contains(chars[i])){
                shiftLeft(chars, i);
            }
            set.add(chars[i]);
        }
        for(int i = set.size(); i < chars.length; i++){
            chars[i] = ' ';
        }

    }

    public static void removeDuplicate2(char[] chars){
        if(chars == null){
            return;
        }
        int count = 0;
        for(int i = 0; i < chars.length; i++){
            for(int j = i+1; j < chars.length; j++){
                if(chars[i] == chars[j] && chars[j] != ' '){
                    shiftLeft(chars, j);
                    count++;
                    j--;
                }
            }
        }
    }

    public static void removeDuplicate3(char[] chars) {
        if(chars == null){
            return;
        }
        int count = 0;
        for(int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    chars[j] = ' ';
                }
            }
        }
        for(int waiter = 0, mover = 0; mover < chars.length; mover++){
            if(chars[waiter] != ' '){
                waiter++;
            }
            else if(chars[mover] != ' '){
                chars[waiter] = chars[mover];
                chars[mover] = ' ';
                waiter++;
            }
        }
    }
}



