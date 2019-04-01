public class C1Q2 {

    public static void  reverseString(char[] chars){
        if(chars == null){
            return;
        }
        for(int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
