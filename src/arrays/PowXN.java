package arrays;

public class PowXN {

    public static float powN(float x , int y){
        float temp = 0;
        if( y == 0){
            return 1;
        }
        temp = powN(x,y/2);
        if(y % 2 == 0){
            return temp * temp;
        }
        else{
            if(y > 0){
                return x * temp * temp;
            }
            else{
                return (temp * temp) / x;
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(powN(2,-3));
    }
}
