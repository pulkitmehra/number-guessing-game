package org.collegeboard.game;

import org.collegeboard.game.CoarseGrainedGuess;
import org.collegeboard.game.FineGrainedGuess;
import org.collegeboard.game.NumberGuess;
import org.collegeboard.game.Range;
import org.collegeboard.game.RangeGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class CoarseGrainedGuessTest.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CoarseGrainedGuessTest {

    /** The range generator. */
    @Mock
    private RangeGenerator rangeGenerator;

    /** The fine grained guess. */
    @Mock
    private FineGrainedGuess fineGrainedGuess;

    /** The next guess. */
    private NumberGuess nextGuess;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        nextGuess = new CoarseGrainedGuess(rangeGenerator);
    }

    /**
     * Next high number guess test.
     */
    @Test
    public void nextHighNumberGuessTest() {
        when(rangeGenerator.generateRange(6)).thenReturn(new Range(64, 128));
        long nextHighNumber = nextGuess.nextHighNumber(64);
        assertThat(nextHighNumber, is(128L));
        verify(rangeGenerator).generateRange(6);
    }

    /**
     * Next high number fine grained guess test.
     */
    @Test
    public void nextHighNumberFineGrainedGuessTest() {
        ReflectionTestUtils.setField(nextGuess, "fineGrainedGuesser", fineGrainedGuess);

        int currentNum = 27;
        when(fineGrainedGuess.moveToNextRange(currentNum)).thenReturn(false);
        when(fineGrainedGuess.nextHighNumber(27)).thenReturn(29L);
        long nextHighNumber = nextGuess.nextHighNumber(currentNum);
        assertThat(nextHighNumber, is(29L));

        verify(rangeGenerator, never()).generateRange(Matchers.anyInt());
        verify(fineGrainedGuess, times(1)).moveToNextRange(currentNum);
        verify(fineGrainedGuess, times(1)).nextHighNumber(currentNum);
    }

    /**
     * Next low number guess test.
     */
    @Test
    public void nextLowNumberGuessTest() {
        when(rangeGenerator.generateRange(4)).thenReturn(new Range(16, 32));
        long nextHighNumber = nextGuess.nextLowNumber(16);
        assertThat(nextHighNumber, is(16L));
        verify(rangeGenerator).generateRange(4);
    }

    /**
     * Next low number fine grained guess test.
     */
    @Test
    public void nextLowNumberFineGrainedGuessTest() {
        ReflectionTestUtils.setField(nextGuess, "fineGrainedGuesser", fineGrainedGuess);

        int currentNum = 27;
        when(fineGrainedGuess.moveToPreviousRange(currentNum)).thenReturn(false);
        when(fineGrainedGuess.nextLowNumber(27)).thenReturn(26L);
        long nextLow = nextGuess.nextLowNumber(currentNum);
        assertThat(nextLow, is(26L));

        verify(rangeGenerator, never()).generateRange(Matchers.anyInt());
        verify(fineGrainedGuess, times(1)).moveToPreviousRange(currentNum);
        verify(fineGrainedGuess, times(1)).nextLowNumber(currentNum);
    }

}
