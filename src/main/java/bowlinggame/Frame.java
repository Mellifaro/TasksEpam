package bowlinggame;

/**
 * Created by Viktor_Skapoushchenk on 3/9/2018.
 */
public class Frame {
    private FrameType type;
    private int firstTurnPins;
    private int secondTurnPins;
    private int frameScore;

    public Frame(String stringScore) {
        if(stringScore.length() == 1){
            populateFrameSingle(stringScore);
        }else{
            populateFrameFull(stringScore);
        }
    }

    private void populateFrameSingle(String score){
        if(score.equals("X")){
            firstTurnPins = 10;
            type = FrameType.STRIKE;
        }else{
            firstTurnPins = Integer.valueOf(score);
            type = FrameType.SIMPLE;
        }
    }

    private void populateFrameFull(String score){
        String firstPart;
        String secondPart;
        if(score.length() > 2){
            throw new IllegalArgumentException("Input string is not valid");
        }
        firstPart = score.substring(0, 1);
        secondPart = score.substring(1, 2);

        switch(firstPart){
            case "X":
                firstTurnPins = 10;
                type = FrameType.SIMPLE;
                break;
            case "-":
                firstTurnPins = 0;
                break;
            default:
                firstTurnPins = Integer.valueOf(firstPart);
        }

        switch(secondPart){
            case "X":
                secondTurnPins = 10;
                type = FrameType.SIMPLE;
                break;
            case "-":
                secondTurnPins = 0;
                break;
            case "/":
                secondTurnPins = 10 - firstTurnPins;
                type = FrameType.SPARE;
                break;
            default:
                secondTurnPins = Integer.valueOf(firstPart);
        }
    }

    public FrameType getType() {
        return type;
    }

    public int getFirstTurnPins() {
        return firstTurnPins;
    }

    public int getSecondTurnPins() {
        return secondTurnPins;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
}
