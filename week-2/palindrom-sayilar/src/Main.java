public class Main {
    static boolean isPalindrom (int num){
        int tempNum=num,reverseNum=0,lastNum=0;
        while (tempNum!=0){
            lastNum=tempNum%10;
            reverseNum=(reverseNum*10)+lastNum;
            tempNum/=10;
        }
        if(num==reverseNum){
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(isPalindrom(546));
    }

}