public class C1Q8 {

    public static boolean isOneEditAway(String str1, String str2){

        if(str1 == null || str2 == null){
            return false;
        }
        if(str1 == null && str2 == null){
            return true;
        }
        if(Math.abs(str1.length() - str2.length()) > 2){
            return false;
        }
        String shortStr = str1.length() > str2.length() ? str2 : str1;
        String longStr = str1.length() > str2.length() ? str1 : str2;

        boolean isInserted = false;
        for(int i = 0, j = 0; i < shortStr.length() && j < longStr.length(); i++, j++){
            if(isInserted && shortStr.charAt(i) != longStr.charAt(j)){
                return false;
            }
            else if(shortStr.charAt(i) != longStr.charAt(j)){
                if(shortStr.length() != longStr.length()){
                    j++;
                }
                isInserted = true;
            }
        }
        return true;
    }
}
