import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {
        try {
            int i = 100 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
        // 输出: 1 2
    }

    public static void main2(String[] args) {
        byte a = 1, b = 2;
        final byte e = 3, f = 4;
        byte c, d;
        c = e + f;
        // d = (a + b); 编译出错
        // System.out.println(c + d);
    }

    public static void main3(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + ", " + b); // AB, B
    }

    private static void operator(StringBuffer a, StringBuffer b) {
        a.append(b); // AB
        // 将字符表示 附加 到此序列
        b = a; //B
    }

    public static void main4(String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred")); // true
    }

    public static void main5(String[] args) {
        Test t = new Test();
        System.out.print(add(9, 34));// finally 43
    }

    private static int add(int x, int y) {
        try {
            return x + y;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.print("finally");
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr[10]);
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
    }
}

class TestDemo {
    public static void main1(String[] args) {
        // Fibonacci 数列是这样定义的：
        // F[0] = 0  F[1] = 1
        // for each i ≥ 2: F[i] = F[i - 1] + F[i - 2]
        // 因此，Fibonacci 数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...
        // 在 Fibonacci 数列中的数我们称为 Fibonacci 数. 给一个数 N，你想让其变为一个 Fibonacci 数.
        // 每一步可以把当前数字 X 变为 X - 1 或者 X + 1，现在给一个数 N 求最少需要多少步可以变为 Fibonacci 数.

        // 输入为一个正整数 N(1 ≤ N ≤ 1,000,000)
        // 输出一个最小的步数变为 Fibonacci 数
        // 例如: 输入 15  输出 2

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int count = 0, count1 = 0;
        while (fib(i) < n) {
            i++;
        }
        count = fib(i) - n;
        count1 = n - fib(i - 1);
        if (count > count1) {
            System.out.println(count1);
        }else {
            System.out.println(count);
        }
    }

    private static int fib(int n) {
        int sum = 0;
        int a = 0, b = 1;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        sum = a + b;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        // 有一个 X(行) x Y(列) 的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角.
        // 请设计一个算法，计算机器人有多少种走法.
        // 给定两个正整数 int x, int y，请返回机器人的走法数目.保证 x ＋ y 小于等于 12.

        //例如:
        // 输入 2 2   输出 2(相当于坐标原点 (1, 1))
        // 输入 1 1   输出 1(相当于坐标原点(0, 0))

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(countWays(x, y));
    }
    public static int countWays(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}