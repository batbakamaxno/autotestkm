import org.junit.Test;
import org.junit.Assert;

public class MainClassTest {

     public MainClass Num = new MainClass();

     @Test
    public void testGetLocalNumber(){

        int  a = Num.getLocalNumber();

//        System.out.println(a);
//        if (a==14) {
//            System.out.println("True");
//       } else  {
//          System.out.println("False");
//        }
        Assert.assertTrue("a!=14",a==14);

        }



        @Test
    public  void testGetClassNumber() {

         int b = Num.getClassNumber();

//         if (b>45){
//             System.out.println("True");
//         }else{
//             System.out.println("False");
//         }
         Assert.assertTrue("b<45",b>45);
        }
        @Test
    public void testGetClassString(){
         String a = Num.getClassString();

         String b=a.toLowerCase();
         Assert.assertTrue("в строке нет подстроки",b.contains("hello"));
        }
}
