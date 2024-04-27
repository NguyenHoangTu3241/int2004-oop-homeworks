public class Numeral extends Expression{
    private final int value;
    public int evaluate() {
        return value;
    }
    public String toString() {
        if (value == 0) return "0";
        String s = "";
        int v = value;
        while(v != 0) {
            s = (v % 10) + s;
            v /= 10;
        }
        return s;
    }
    public Numeral(int v) {
        value = v;
    }
}