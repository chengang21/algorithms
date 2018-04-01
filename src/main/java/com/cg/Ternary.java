package com.cg;

public class Ternary {

    public static String toTernary(int x )
    {
        return toTernary( Math.abs(x), x>0 );
    }

    private static String toTernary(int x, boolean positive)
    {
        String result="";
        if (x==0)
            return "0";

        int m = x % 3;
        int n = x / 3;

        if ( m == 2 )
            ++n;

        if ( n > 0 )
            result += toTernary(n, positive);

        switch(m)
        {
            case 0:
                if( n>0 )
                    result +="0" ;
                break;

            case 1:
                result += positive ? "1" : "-";
                break;

            case 2:
                result += positive ? "-" : "1";
                break;
        }
        return result;
    }


    public static String binary(int x)
    {
        int m = x % 2;
        int n = x / 2;
        String result = null;

        if (n>0)
            result += binary( n );

        result += (m==0)? "0" : "1";

        return result;
    }

    private static void test( ) {
        int x = 0;
        System.out.println( x + " :   " + toTernary(x));
        x = 5;
        System.out.println( x + " :   " + toTernary(x));
        x = -9;
        System.out.println( x + " :   " + toTernary(x));
        x = 100;
        System.out.println( x + " :   " + toTernary(x));
        x = -100;
        System.out.println( x + " :   " + toTernary(x));
        x = 9797;
        System.out.println( x + " :   " + toTernary(x));
        x = -9797;
        System.out.println( x + " :   " + toTernary(x));
        x = 234;
        System.out.println( x + " :   " + toTernary(x));

        System.out.println("------------- binary -------------------");

        x = 32;
        System.out.println( x + " :   " + binary(x));
        x = 129;
        System.out.println( x + " :   " + binary(x));
    }

    public static void main(String[] args ) {
        test();
    }
}
