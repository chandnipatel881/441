public class C1Q9 {

    public static String stringCompression(String str){
        if(str == null){
            return null;
        }
        char prevChar = str.charAt(0);
        int count = 0;
        StringBuffer compressedString = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(prevChar == str.charAt(i)){
                count++;
            }
            else{
                compressedString.append(prevChar);
                compressedString.append(count);
                prevChar = str.charAt(i);
                count = 1;
            }
        }
        compressedString.append(prevChar);
        compressedString.append(count);
        if(str.length() < compressedString.length()){
            return str;
        }
        return compressedString.toString();
    }
}
