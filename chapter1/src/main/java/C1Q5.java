public class C1Q5 {

    public static char[] replaceSpace(char[] str){

        if(str == null){
            return null;
        }
        int numOfSpaces = 0;
        int currentNumOfSpaces = 0;
        int lastIndex = 0;
        for(int i = 0; i < str.length; i++){
            if(str[i] == ' '){
                currentNumOfSpaces++;
            }
            else{
                numOfSpaces = currentNumOfSpaces;
                lastIndex = i;
            }
        }

        int newStringLength = lastIndex + numOfSpaces * 2;

        for(int mover= lastIndex, waiter = newStringLength; mover != waiter; mover--){
            if(str[mover] != ' '){
                str[waiter] = str[mover];
                str[mover] = ' ';
                waiter--;
            }
            else{
                str[waiter] = '0';
                str[waiter-1] = '2';
                str[waiter-2] = '%';
                waiter-=3;
            }
        }
        return str;
    }
}
