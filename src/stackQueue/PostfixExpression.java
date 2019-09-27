package stackQueue;

public class PostfixExpression {

    public static int evaluatePostFix(String expression) {

        Stack<Integer> stack = new Stack<>(expression.length());

        for(int i=0;i<expression.length();i++) {

            char ch = expression.charAt(i);

            if(!Character.isDigit(ch)){
                Integer x = stack.pop();
                Integer y = stack.pop();

                switch(ch) {
                    case '+':
                        stack.push(y+x);
                        break;

                    case '-':
                        stack.push(y - x);
                        break;

                    case '*':
                        stack.push( y * x );
                        break;

                    case '/':
                        stack.push(y / x);
                        break;
                }

            }
            else{
                stack.push(Character.getNumericValue(ch));
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {

        System.out.println("Evaluated Expression is : " + evaluatePostFix("921*-8-4+"));

    }
}
