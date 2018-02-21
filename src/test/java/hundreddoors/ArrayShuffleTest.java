package hundreddoors;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayShuffleTest {

    @Test
    public void testArrayShuffle(){
        int[] testArray = new int[]{5, -7, 256, 3256, -14256, 0};
        int[] finArray = ArrayShuffle.arrayShuffle(testArray);

        assertTrue(testArray.length == finArray.length);
        for(int a : testArray){
            boolean isFound = false;
            for(int b: finArray){
                if(a == b){
                    isFound = true;
                }
            }
            assertTrue(isFound);
        }
    }
}
