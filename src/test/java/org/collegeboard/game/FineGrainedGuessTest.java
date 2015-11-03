package org.collegeboard.game;

import org.collegeboard.game.FineGrainedGuess;
import org.collegeboard.game.Range;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * The Class FineGrainedGuessTest.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class FineGrainedGuessTest {

    /** The range. */
    private Range range = new Range(16, 32);

    /** The fine grained guess. */
    private FineGrainedGuess fineGrainedGuess = null;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        fineGrainedGuess = new FineGrainedGuess(range);
    }

    /**
     * Next high number test.
     */
    @Test
    public void nextHighNumberTest() {
        long nextHighNumber = fineGrainedGuess.nextHighNumber(17);
        assertThat(nextHighNumber, is(24L));

        long tentativeLower = ((Long) ReflectionTestUtils.getField(fineGrainedGuess, "tentativeLower"))
            .longValue();

        long tentativeUpper = ((Long) ReflectionTestUtils.getField(fineGrainedGuess, "tentativeUpper"))
            .longValue();

        assertThat(tentativeUpper, is(0L));
        assertThat(tentativeLower, is(17L));
    }

    /**
     * Move to next range test.
     */
    @Test
    public void moveToNextRangeTest() {
        ReflectionTestUtils.setField(fineGrainedGuess, "tentativeLower", range.getUpper());
        boolean isNext = fineGrainedGuess.moveToNextRange(17);
        assertThat(isNext, is(true));
    }

    /**
     * Next low number test.
     */
    @Test
    public void nextLowNumberTest() {
        long nextLowNumber = fineGrainedGuess.nextLowNumber(17);
        assertThat(nextLowNumber, is(16L));

        long tentativeLower = ((Long) ReflectionTestUtils.getField(fineGrainedGuess, "tentativeLower"))
            .longValue();

        long tentativeUpper = ((Long) ReflectionTestUtils.getField(fineGrainedGuess, "tentativeUpper"))
            .longValue();

        assertThat(tentativeUpper, is(17L));
        assertThat(tentativeLower, is(0L));
    }

    /**
     * Move to previous range test.
     */
    @Test
    public void moveToPreviousRangeTest() {
        ReflectionTestUtils.setField(fineGrainedGuess, "tentativeUpper", range.getLower());
        boolean isPrevious = fineGrainedGuess.moveToPreviousRange(17);
        assertThat(isPrevious, is(true));
    }

}
