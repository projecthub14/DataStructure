package stackQueue;

public class SortStack<V> {

    //Time Complexity is O(n2) -- outer and inner loops both traverse all elemnts of stack

    //1. use the helper stack second stack new Stack
    //2. Pop value from mainstack
    //3. If the value is greater than top of tempStack then push to tempstack
    //   else pop all values from new stack and push to main stack and in end push value to new stack and repeat step 2
    //untill main stack is empty
    //4. when the mainstack is empty then tempStack will have values in descending order
    //5. Now move the values from new stack to mainstack so that values will be in ascending order
    public static void sortStack1(Stack<Integer> stack) {

        Stack<Integer> newStack = new Stack<>(stack.getMaxSize());

        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if(!newStack.isEmpty() && value >= newStack.top()){
                newStack.push(value);
            }
            else {
                while(!newStack.isEmpty() && value < newStack.top()) {
                    stack.push(newStack.pop());
                }
                newStack.push(value);
            }

        }
        while(!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }

    }

    //1. if value is smaller than top of stack then we push to stack
    //2.otherwise we insert again untill we find appropriate place

    public static void insert(Stack<Integer> stack, int value) {

        if(stack.isEmpty() || value < stack.top()){
            stack.push(value);
        }
        else {
            int temp = stack.pop();
            insert(stack,value);
            stack.push(temp);
        }
    }


    //1. pop out all elements of stack in one recursive call
    //2. once stack is empty we will push back the elements in ascending order
    //using insert method
    //3. at each call we recieve partially sorted stack .. in which we insert
    //value being popped out at that recursive call
    //4. Time Complexity is O(n2) .. no need of new stack
    public static Stack<Integer> sortStack2(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int value = stack.pop();
            sortStack2(stack);
            insert(stack,value);
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);



        sortStack2(stack);


        while (!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }

    }
}
