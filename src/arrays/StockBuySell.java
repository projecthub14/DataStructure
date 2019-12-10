package arrays;

import java.util.ArrayList;

class Interval{
    int buy;
    int sell;
}

public class StockBuySell {



    public static void stockBuySell(int[] price , int n){

        int i =0;
        ArrayList<Interval> list = new ArrayList<>();
        int count = 0;
        while(i<n-1){

            while((i<n-1) && (price[i] >= price[i+1])){
                i++;
            }

            if(i == n-1){
                break;
            }
            Interval interval = new Interval();
            interval.buy = i++;

            while(i<n && price[i]>= price[i-1]){
                i++;
            }

            interval.sell = i-1;
            list.add(interval);

            count++;
        }

        if(count ==0){
            System.out.println("No profit");
        }

        else{
            for(int j=0;j<count ; j++){
                System.out.println("Buy on day : " +
                        list.get(j).buy + " " +
                        "Sell on day : " + list.get(j).sell);
            }
        }

    }



    public static void main(String[] args) {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        // fucntion call
        stock.stockBuySell(price, n);
    }
}
