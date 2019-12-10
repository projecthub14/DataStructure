package arrays;

import java.util.ArrayList;
import java.util.List;

//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/NQueens/NQueens.java

public class NQueens {

    public static List<List<String>> nQueens(int n){
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n,0,new ArrayList<>() , result);
        return result;

    }

    private static void solveNQueens(int n , int rows, List<Integer> colPlacements, List<List<String>> result){
        if(rows == n){
            result.add(generateBoardFromPlacements(colPlacements,n));
            return;
        }
        else{
            for(int col =0; col<n ; col++){
                colPlacements.add(col);
                if(isValid(colPlacements)){
                    solveNQueens(n,rows+1,colPlacements,result);
                }
                colPlacements.remove(colPlacements.size() - 1);
            }
        }

    }

    private static List<String> generateBoardFromPlacements(List<Integer> colPlacements , int n){
        List<String> board = new ArrayList<>();
        int totalItemsPlaced = colPlacements.size();

        for (int row = 0; row < totalItemsPlaced; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (col == colPlacements.get(row)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }
            
        return board;
    }

    private static boolean isValid(List<Integer> colPlacements){
        int rowId = colPlacements.size() -1;
        for(int i=0;i<rowId ;i++){
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
            if(diff == 0 || diff == rowId-1){
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        List<List<String>> result = nQueens(4);
        for(List<String> list : result){
            for (String i : list){
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}
