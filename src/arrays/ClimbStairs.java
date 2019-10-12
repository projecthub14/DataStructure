package arrays;

public class ClimbStairs {
    //https://www.youtube.com/watch?v=NFJ3m9a1oJQ

    public static int numberOfSteps(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Number of Steps " + numberOfSteps(6));
    }

}

