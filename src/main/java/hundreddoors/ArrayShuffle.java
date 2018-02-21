package hundreddoors;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayShuffle(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] arrayShuffle(int[] initArray){
        int[] finArray = Arrays.copyOf(initArray, initArray.length);

        for(int i = 0; i < finArray.length; i++){
            int rand = getRandomInteger(0, initArray.length);

            int swap = finArray[i];
            finArray[i] = finArray[rand];
            finArray[rand] = swap;
        }
        return finArray;
    }

    //return random int between two values
    public static int getRandomInteger(int minValue, int maxValue){
        int delta = maxValue - minValue;
        Random r = new Random();
        return minValue + r.nextInt(delta);
    }
}
