package Expressions
public class Addition extends BinaryExpression{
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
    public Addition(Expression l, Expression r) {
        left = l;
        right = r;
    }

}