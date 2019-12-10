package stackQueue;

//time complexity is O(n)
public class BalancedParanthesesCheck {

    //1. Iterate through string expression
    //2. For every opening paranthesis , push it to stack
    //3. For every closing parantheses check for its corresponding opening parantheses for it
    //4. For closing parantheses if we cannot find corresponding closing parantheses then return false
    //5. after completion of string expression if any opening parantheses is left
    //in stack then return false;
    //6. return true if you havent encountered any of the above

    public static boolean checkBalanced(String expression){


        Stack<Character> stack = new Stack<>(expression.length());
        for (int i = 0; i <expression.length() ; i++) {

            char ch = expression.charAt(i);
            if(ch == '}' || ch == ']' || ch ==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(ch == '}' && stack.pop() != '{'
                        || ch == ']' && stack.pop() != '['
                            || ch == ')' && stack.pop() != '('){
                    return false;
                }

            }
            else{
                stack.push(ch);
            }
        }

        //end of string expression
        if(!stack.isEmpty()){
           return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String expression = "{()}[)";
        System.out.println(checkBalanced(expression));
    }
}
