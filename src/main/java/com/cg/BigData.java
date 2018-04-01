package com.cg;

public class BigData {

    private static int m0( char op1, char op2 )
    {
        return (op1 - '0') * (op2 - '0');
    }

    private static int add0( char op1, char op2 )
    {
        return (op1 - '0') + (op2 - '0');
    }

    private static String m1( String op1, char op2 )
    {
        int carry = 0;
        int n = op1.length();
        String ret = "";
        for ( int ii=n-1; ii >=0; ii-- )
        {
            int tmp = m0 ( op1.charAt(ii), op2 ) + carry;
            carry = tmp/10;
            ret = String.valueOf( tmp%10 ) + ret;
        }
        if (carry > 0)
            ret = String.valueOf( carry ) + ret;

        return ret;
    }

    private static int last( String strOp1, int i )
    {
        int index = strOp1.length() -1 -i ;
        return index >= 0 ? strOp1.charAt(index) - '0' : 0 ;
    }

    // str2 = new StringBuffer(str2).reverse().toString();
    public static String add ( String op1, String op2 )
    {
        int len1 = op1.length();
        int len2 = op2.length();
        int cnt = len1 > len2 ? len1 : len2;
        String ret = "";
        int carry = 0;

        for ( int ii=0; ii<cnt; ii++ )
        {
            int sum = last(op1, ii) + last(op2, ii) + carry;
            carry = sum/10;
            ret = String.valueOf( sum % 10 ) + ret;
        }
        if (carry > 0)
            ret = String.valueOf( carry ) + ret;

        return ret;
    }

    private  static  String  append0( String op, int l )
    {
        for (int ii=1; ii<= l; ii++ )
            op += '0';

        return op;
    }

    public static String miltiple( String op1, String op2 )
    {
        String ret="";
        int cnt = op1.length();
        for (int ii=0; ii<cnt; ii++)
        {
            String s1 = m1( op2, op1.charAt(ii) );
            s1 = append0( s1, cnt-ii-1 );
            ret = add(s1, ret);
        }
        return ret;
    }

    private static void test( )
    {
        String res = m1("831232134562123", '9');
        System.out.println(res);

        res = m1("8300009923234000", '9');
        System.out.println(res);

        res = m1("000004000", '9');
        System.out.println(res);

        res = m1("900004000", '0');
        System.out.println(res);

        res = add("56", "98359234348500");
        System.out.println(res);

        res = add("0023812456856756", "00098359234348500");
        System.out.println(res);

        res = miltiple("831232134562123", "12");
        System.out.println(res);

        res = miltiple("831232134562123", "90003000000");
        System.out.println(res);

        res = miltiple("831232134562123", "989213345334");
        System.out.println(res);

        res = miltiple("9999999000000099999993", "989213345334");
        System.out.println(res);
    }

    public static void main(String[] args ) {
        test();
    }

}
