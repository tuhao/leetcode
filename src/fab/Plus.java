package fab;

//求从1加到n
public class Plus {

    //f(n)=n+f(n-1)
    public static int plus(int n) {
        if (n == 1) return 1;
        return n + plus(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(plus(10));
    }
}
