public class Square extends Expression{
    private final Expression expression;
    public int evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
    public String toString() {
        return expression.toString() + "^2";
    }
    public Square(Expression e) {
        expression = e;
    }

}