package bowlinggame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Viktor_Skapoushchenk on 3/9/2018.
 */
public class BowlingGame {
    private String inputString;
    private List<String> parts;
    private List<Frame> frames;

    public BowlingGame(String inputString) {
        this.inputString = inputString;
    }

    public static void main(String[] args) {
        BowlingGame game = new BowlingGame("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||");
        game.validateInputString();
    }

    public boolean validateInputString(){
        int expectedPartsSize = inputString.endsWith("||") ? 10 : 11;
        List<String> parts = Arrays.stream(inputString.split("\\|"))
                                    .filter(part -> !part.equals("\\|"))
                                    .filter(part -> !part.equals(""))
                                    .collect(Collectors.toList());
        if(parts.size() != expectedPartsSize){
            return false;
        }

        frames = parts.stream().map(Frame::new).collect(Collectors.toList());

        Integer totalScore = calculateScore(frames);
        System.out.println(totalScore);
        return true;
    }

    public Integer calculateScore(List<Frame> frames){
        for(int i = 0; i < frames.size(); i++){
            Frame currentFrame = frames.get(i);
            Frame nextFrame = null;
            if(i < frames.size() - 1){
                nextFrame = frames.get(i + 1);
            }
            if(i == frames.size() - 1){
                currentFrame.setFrameScore(currentFrame.getFirstTurnPins() + currentFrame.getSecondTurnPins());
            }else{
                switch (currentFrame.getType()){
                    case SIMPLE: currentFrame.setFrameScore(currentFrame.getFirstTurnPins() + currentFrame.getSecondTurnPins());
                        break;
                    case STRIKE: currentFrame.setFrameScore(currentFrame.getFirstTurnPins() + currentFrame.getSecondTurnPins() +
                                    + nextFrame.getFirstTurnPins() + nextFrame.getSecondTurnPins());
                        break;
                    case SPARE: currentFrame.setFrameScore(currentFrame.getFirstTurnPins() + currentFrame.getSecondTurnPins() +
                            + nextFrame.getFirstTurnPins());
                        break;
                }
            }
        }
        return frames.stream().mapToInt(Frame::getFrameScore).sum();
    }

}
