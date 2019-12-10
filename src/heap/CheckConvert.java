package heap;

public class CheckConvert {

    public  static String  convertMax(int[] maxHeap){

        String result = "[";

        MinHeap.buildMinHeap(maxHeap,maxHeap.length);
        for (int i = 0; i <maxHeap.length ; i++) {
            if(i == maxHeap.length -1) {
                result += String.valueOf(maxHeap[i]);
            }
            else{
                result += String.valueOf(maxHeap[i]) + ",";
            }
        }
        result += "]";

       return result;
    }




    public static void main(String[] args) {

        int[] heapList = {9,4,7,1,-2,6,5};
        System.out.println(convertMax(heapList));
    }
}
