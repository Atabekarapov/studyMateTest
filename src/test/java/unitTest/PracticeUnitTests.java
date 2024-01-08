package unitTest;

import org.junit.Assert;
import org.junit.Test;

public class PracticeUnitTests {
    public int gradeStudent(int score){
        if(score >= 90){
            return 5;
        }
        else if( score < 90 && score >=70){
            return 4;
        }
        else if(score < 70 && score >= 50){
            return 3;
        }
        else{
            return 0;
        }
    }
    @Test
    public void test1(){
        Assert.assertEquals(5, gradeStudent(101));
    }
    @Test
    public void test2(){
        Assert.assertEquals(5, gradeStudent(90));
    }
    @Test
    public void test3(){
        Assert.assertSame(0, gradeStudent(10));
    }
    @Test
    public void test4(){
        Assert.assertNotEquals(5, gradeStudent(89));
    }
    @Test
    public void test5(){
        Assert.assertEquals(0, gradeStudent(-8));
    }
    @Test
    public void test6(){
        Assert.assertEquals(0, gradeStudent(0));
    }
    @Test
    public void test7(){
        Assert.assertNotEquals(0, gradeStudent(80));
    }
}
