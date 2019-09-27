package stackQueue;

public class PostfixExpression {

    //Time complexity of algorithm is O(n)
    public static int evaluatePostFix(String expression) {

        Stack<Integer> stack = new Stack<>(expression.length());
        //1. Scan the expression character by character
        //2. If character is number push it to stack
        //3. If character is operator then pop two elements from stack
        // perform operation and put the result back in stack
        //4. At the end , stack will contain result of whole expression

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
