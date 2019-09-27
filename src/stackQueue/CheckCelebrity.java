package stackQueue;

public class CheckCelebrity {

    //returns true if x knows y otherwise false
    public static boolean acqStatus(int[][] party,int row , int col) {
        if(party[row][col] == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public static int findCelebrity(int[][] party,int num) {

        Stack<Integer> stack = new Stack<>(num);
        int celebrity = -1;

        //1. create stack with all people pushed to stack

        for(int i=0;i<num;i++){
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            //2. pop two people from stack to check for acquStatus
            // if there is only one people in stck then he is celebrity

            int x = stack.pop();
            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }
            int y = stack.pop();

            //3. if x person knows y person then discard x and add y
            if(acqStatus(party,x,y)){
                stack.push(y);
            }
            else {
                stack.push(x);
            }
        }

        //4.last person in stack is celebrity so check
        // if celebrity doesnot know anyone and others know celebrity

        for(int i = 0;i<num ;i++){
            if(i!=celebrity && ((acqStatus(party,celebrity,i) || !(acqStatus(party,i,celebrity))))){
                return -1;
            }
        }
        return celebrity;


    }
    public static void main(String[] args) {
        int[][] party = {{0,0,0,0},
                         {1,0,0,1},
                         {1,0,0,1},
                         {1,1,1,0},
                        };

        int[][] party2 = {{0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0}
        };

        System.out.println(findCelebrity(party,4));
        System.out.println(findCelebrity(party2,4));
    }
}
