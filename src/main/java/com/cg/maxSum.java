package com.cg;

/*  查找一个序列中连续元素之和最大，且元素最多的 子序列，如：
*  119, -119, 101, -100, 1, 117, -117, 4, -2, 56, 50, -3, 0, 7, -8, 10, -1, 4, -10, -119, 119
* */
public class maxSum {
    public static tuple findMaxSum(int[] a )
    {
        int size = a.length;
        if ( size < 2 )
            return new tuple(0,0, size==1? a[0]: 0, size==1? 1: 0);

        int start=0, end=0 ;
        long sum = a[0], total = a[0];
        boolean renew = false;

        tuple savedTuple = new tuple();
        savedTuple.sum=sum;
        savedTuple.len=1;

        for (int ii=1; ii<size; ++ii )
        {
            if ( sum < 0 && a[ii] > sum || renew )
            {
                start = end = ii;
                total = sum = a[ii];

                renew = false;
                saveTuple(savedTuple, start, end, sum);
                continue;
            }

            total += a[ii];
            if ( total >= sum )
            {
                end = ii;
                sum = total;
            }
            else if ( total < 0 )
            {
                renew = true;
                saveTuple(savedTuple, start, end, sum);
            }
        }
        saveTuple(savedTuple, start, end, sum);

        return savedTuple;
    }

    private static void saveTuple( tuple savedTuple, int start, int end, long sum )
    {
        int len = end - start;
        if ( savedTuple.sum < sum  || savedTuple.sum == sum && savedTuple.len < len ) {
            savedTuple.x = start;
            savedTuple.y = end;
            savedTuple.sum = sum;
            savedTuple.len = end - start + 1;
        }
    }

    public  static void test( int[] a )
    {
        tuple t = findMaxSum( a );

        System.out.println("result:");
        for (int ii= t.x; ii<= t.y; ++ii )
        {
            System.out.print( a[ii] + ", ");
        }
        System.out.println( "\nsum: " +  t.sum );
    }

    public static void main( String[] args )
    {
        int[] a = { 119, -119, 101, -100, 1, 117, -117, 4, -2, 56, 50, -3, 0, 7, -8, 10, -1, 4, -10, -119, 0, 119 };
        test(a);

        int[] a2 = {-1,10,8,4,-10,2};
        test(a2);

        int[] a3 = {1,2,-9,6,10,-22,4};
        test(a3);

        int[] a4 = {1,2,0,0,-1,4,5,6};
        test(a4);

        int[] a5 = {-1,-2,-5,-7,-1,-4,-5,-6};
        test(a5);

        int[] a6 = {1,4,-2,-3,0,7,-8,10};
        test(a6);

        /*
           -1,10,8,4,-10,2,
            max sum 22 and length 3
            1,2,-9,6,10,-22,4,
            max sum 16 and length 2
            1,2,0,0,-1,4,5,6,
            max sum 17 and length 8
            -1,-2,-5,-7,-1,-4,-5,-6,
            max sum -1 and length 1
            1,4,-2,-3,0,7,-8,10,
        */
    }
}


class tuple
{
    protected   int x;
    protected   int y;
    protected   long sum;
    protected   int len;

    tuple()
    {
        sum = x = y = len = 0;
    }
    tuple( int a, int b, long s, int l )
    {
        x = a;
        y = b;
        sum = s;
        len = l;
    }
}
