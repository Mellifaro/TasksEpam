package hundreddoors;

import java.util.Arrays;

public class HundredDoors {
    private static int SPRINTS_COUNT = 100;
    private static int DOORS_COUNT = 100;
    private static boolean INITIAL_DOOR_STATE = false;

    public static void main(String[] args) {
        getAllDoorsState();
    }

    /**
     * @return array of positions for all doors
     */
    public static boolean[] getAllDoorsState(){
        boolean[] doorsArray = new boolean[100];
        for(int i = 0; i < doorsArray.length; i++){
            boolean currentState = getTheDoorState(i + 1);
            doorsArray[i] = currentState;
        }
        System.out.println(Arrays.toString(doorsArray));
        return doorsArray;
    }

    /**
     * @param position
     * @return the state of the door after all passes
     */
    public static boolean getTheDoorState(int position){
        boolean isOpen = INITIAL_DOOR_STATE;
        int totalRuns = SPRINTS_COUNT < position ? SPRINTS_COUNT : position;

        for(int i = 1; i <= totalRuns; i++){
            if(position % i == 0){
                isOpen = changeValue(isOpen);
            }
        }
        return isOpen;
    }

    //changes the state of variable {@code cuurentState} to opposite
    private static boolean changeValue(boolean currentState){
        return !currentState;
    }
}

