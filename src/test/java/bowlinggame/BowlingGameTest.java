package bowlinggame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Viktor_Skapoushchenk on 3/9/2018.
 */
public class BowlingGameTest {

    @Test
    public void testValidationCorrectInputStringSuccess(){
        List<BowlingGame> validStrings = new ArrayList<>();
        Collections.addAll(validStrings,
                new BowlingGame("X|X|X|X|X|X|X|X|X|X||XX"),
                new BowlingGame("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"),
                new BowlingGame("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5")
        );

        validStrings.forEach(bowlingGame -> assertTrue(bowlingGame.validateInputString()));
    }

    @Test
    public void testValidationIncorrectInputStringFail(){
        List<BowlingGame> invalidStrings = new ArrayList<>();
        Collections.addAll(invalidStrings,
                new BowlingGame("X|X|X|X|X|X|X|X|1X|X||X"),
                new BowlingGame("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||X"),
                new BowlingGame("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||"),
                new BowlingGame("X|X|X|X|X|X|X|X|1X|X||"),
                new BowlingGame("9-|9-5|9-|9-|9-|9-|9-|9-|9-|9-||"),
                new BowlingGame("5/|5/|56|5/|5/|5/|5/|5/|5/|5/||5")
        );

        invalidStrings.forEach(bowlingGame -> assertFalse(bowlingGame.validateInputString()));
    }

}
