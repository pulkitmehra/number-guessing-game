/*
 * COPYRIGHT:     Copyright reserved by Pulkit Mehra
 */
package org.collegeboard.game.command.executors;

import org.collegeboard.game.NumberGuess;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.command.CommandExecutorException;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class GuessNumberCommandExecutorTest.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class GuessNumberCommandExecutorTest {

    /** The guess number command executor. */
    private GuessNumberCommandExecutor guessNumberCommandExecutor;

    /** The game input output. */
    @Mock
    private GameInputOutput gameInputOutput;

    /** The number guess. */
    @Mock
    private NumberGuess numberGuess;

    /** The context. */
    @Mock
    private Context context;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        guessNumberCommandExecutor = new GuessNumberCommandExecutor(gameInputOutput, numberGuess);
    }

    /**
     * Can execute test.
     */
    @Test
    public void canExecuteTest() {
        assertThat(guessNumberCommandExecutor.canExecute(""), is(false));
        assertThat(guessNumberCommandExecutor.canExecute("INVALID"), is(false));
        assertThat(guessNumberCommandExecutor.canExecute(Command.QUIT.getValue()), is(false));
        assertThat(guessNumberCommandExecutor.canExecute(Command.HIGH.getValue()), is(true));
        assertThat(guessNumberCommandExecutor.canExecute(Command.LOW.getValue()), is(true));
    }

    /**
     * Execute higher test.
     *
     * @throws CommandExecutorException the command executor exception
     */
    @Test
    public void executeHigherTest() throws CommandExecutorException {
        when(context.get(AbstractCommandExecutor.KEY_CURRENT_GUESS)).thenReturn(24L);
        doNothing().when(context).put(AbstractCommandExecutor.KEY_CURRENT_GUESS, 32L);
        when(numberGuess.nextHighNumber(24L)).thenReturn(32L);
        doNothing().when(gameInputOutput).write(Messages.I_GUESS_NUMBER_HIGH.getMessage(32L));

        guessNumberCommandExecutor.execute(context, "HIGH");

        verify(context, times(1)).get(AbstractCommandExecutor.KEY_CURRENT_GUESS);
        verify(context, times(1)).put(AbstractCommandExecutor.KEY_CURRENT_GUESS, 32L);
        verify(gameInputOutput, times(1)).write(Messages.I_GUESS_NUMBER_HIGH.getMessage(32L));
        verify(numberGuess, times(1)).nextHighNumber(24L);
    }

    /**
     * Execute low test.
     *
     * @throws CommandExecutorException the command executor exception
     */
    @Test
    public void executeLowTest() throws CommandExecutorException {
        when(context.get(AbstractCommandExecutor.KEY_CURRENT_GUESS)).thenReturn(24L);
        doNothing().when(context).put(AbstractCommandExecutor.KEY_CURRENT_GUESS, 21L);
        when(numberGuess.nextLowNumber(24L)).thenReturn(21L);
        doNothing().when(gameInputOutput).write(Messages.I_GUESS_NUMBER_LOW.getMessage(21L));

        guessNumberCommandExecutor.execute(context, "LOW");

        verify(context, times(1)).get(AbstractCommandExecutor.KEY_CURRENT_GUESS);
        verify(context, times(1)).put(AbstractCommandExecutor.KEY_CURRENT_GUESS, 21L);
        verify(gameInputOutput, times(1)).write(Messages.I_GUESS_NUMBER_LOW.getMessage(21L));
        verify(numberGuess, times(1)).nextLowNumber(24L);
    }
}
