package structexercise;

public class ArrayStack {

    private String[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item) {
        if (count == n) return false;
        items[count++] = item;
        return true;
    }

    public String pop() {
        if (count == 0) return null;
        String result = items[count - 1];
        --count;
        return result;
    }

    public static void main(String[] args) {
        String x = "3+5*8-6";
        ArrayStack digStack = new ArrayStack(x.length());
        ArrayStack opStack = new ArrayStack(x.length());
        String dig = null;
        for (int i = 0; i < x.length(); i++) {
            char item = x.charAt(i);
            if (Character.isDigit(item)) {
                digStack.push(String.valueOf(item));
            } else {
                String op = opStack.pop();
                if (op != null) {
                    if (op.charAt(0) < item) {
                        String tempResult = null;
                        while ((dig = digStack.pop()) != null) {
//                            op x dig
                            op = opStack.pop();
                        }
                        digStack.push(tempResult);
                    } else {
                        opStack.push(String.valueOf(item));
                    }
                } else {
                    opStack.push(String.valueOf(item));
                }
            }
        }
        while ((dig = digStack.pop()) != null) {
            //op x dig
        }
    }

}
