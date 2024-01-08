package unitTest;

import org.junit.Assert;
import org.junit.Test;

public class IntroToJUnit {
//    public static void main(String[] args) {
//        reverseString("apple");
//        reverseString(null);
//    }
    /*
    write a method which takes 1 String as parameter and returns reversed string
     */
    public static String reverseString(String word){
        if(word == null){
            System.out.println("WARN: null value was provided!");
            return null;
        }

        String reversed = "";
        for(int i = word.length()-1; i >= 0; i--){
            reversed += word.charAt(i);
        }
        System.out.println(reversed);
        return reversed;
    }

    @Test
    public void reverseTest1(){
        Assert.assertEquals("elppa", reverseString("apple"));
    }

    @Test
    public void reverseTest2(){
        Assert.assertNull(reverseString(null));
    }

    @Test
    public void reverseTest3(){
        Assert.assertEquals("", reverseString(""));
    }
    @Test
    public void reverseTest4(){
        Assert.assertTrue("54321".equals((reverseString("12345"))));
    }

}
