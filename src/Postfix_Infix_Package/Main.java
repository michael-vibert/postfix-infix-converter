package Postfix_Infix_Package;
/**
 * the main method of the program, acts as a starting point for the
 * program. Included are a few commented out expressions you can try
 */
public class Main {

    public static void main(String[] args)
    {
        InfixConverter infConv = new InfixConverter("4+9-7(0^3)");
        infConv.convertToPostfix();

//        System.out.println(infConv.convertToPostfix());
//        (2+3)*(4+5)
//        (2-3+4)*(5+6*7)
//        (1*2%3*4/8)
//        1+2-3%4*5/6^7/8/9/0
//        1%2%3%4%5%6%7%8%9%0
    }
}
