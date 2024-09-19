package Day1;

import java.util.function.BiPredicate;

public class logicalOperators {
    public static void main(String[] args) {
        boolean t=true;
        boolean f= false;

        //AND oprtn
        System.out.println("AND opertn");
        System.out.println("true && true="+ (t&&t));
        System.out.println("false && true="+ (f&&t));
        System.out.println("true && false="+ (t&&f));
        System.out.println("false && false="+ (f&&f));

        System.out.println();
        //OR opertion
        System.out.println("OR operation");
        System.out.println("true || true="+(t||t));
        System.out.println("true || false="+(t||f));
        System.out.println("false || true="+(f||t));
        System.out.println("false || false="+(f||f));

        System.out.println();
        System.out.println("NOT operation");
        System.out.println("!true="+!t);
        System.out.println("!false="+!f);


        //comaprision operators
        System.out.println();
        System.out.println("comaprison operator");
        int x=5, y=10;
        System.out.println("(x<y) && (y>0) =" +  ((x<y)&& (y>0)));
        System.out.println("(x<y)||(y>11)="+ ((x<y)||(y>11)));

        //complex condition
        System.out.println();
        System.out.println("complex condition");
        boolean a=false, b=true, c=false;
        System.out.println(("a&&c) || (b&&c)"+((a&&c) || (b&&c))));
        System.out.println("a && (b || c) = " + (a && (b || c)));
        System.out.println("!a || (b && !c) = " + (!a || (b && !c)));

        System.out.println();
        //bitwise s logical operators
        System.out.println("Bitwise Vs logical operators");
        System.out.println("true & false="+(t&f));
        System.out.println("true | false="+(t | f));
        System.out.println("true ^ false="+(t ^ f));

        //short circuit operation
        System.out.println("false && (1/0 >0)="+(f && (1/0 >0)));
        System.out.println("   true || (1/0 > 0) = " + (t || (1/0 > 0)));
        //System.out.println("Gives exception="+(1/0>0));

        //short circuit vs non short circuit
        System.out.println();
        System.out.println("Circuit vs non circuit");
        int i=0;
        boolean result1=(f &&(++i>0));
        boolean result2=(f & (++i>0));
        System.out.println("Short-circuit AND result: " + result1 + ", i = " + i);
        System.out.println("Non-short-circuit AND result: " + result2 + ", i = " + i);


        //lofical operator in control strcutrue
        System.out.println();
        System.out.println("Logical operator in control structure");
        if(t && !t){
            System.out.println("this is is printed as both are true");
        }else{
            System.out.println("one of the oprand is not true then this will get print");
        }

        int j=0;
        while(j<3 && t){
            System.out.println("j = "+j);
            j++;
        }

        System.out.println("\n13. Logical Operators in Lambda Expressions:");
        java.util.function.Predicate<Integer> isPositiveAndEven = n -> n > 0 && n % 2 == 0;
        System.out.println("   Is 6 positive and even? " + isPositiveAndEven.test(6));
        System.out.println("   Is 5 positive and even? " + isPositiveAndEven.test(5));


        //lamda func
        BiPredicate<Integer, Integer> isGreater = (p,q) -> p > q;
        System.out.println("Is 5 greater than 15"+ isGreater.test(5,15));


        String name="Hello world";
        boolean ans1= name instanceof String;
        System.out.println(ans1);

        Integer int1=1;
        boolean ans2= int1 instanceof Integer;
        System.out.println(ans2);


    }
}
