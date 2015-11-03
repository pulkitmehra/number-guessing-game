package org.collegeboard.game.command.executors;

import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.NumberGuess;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Implementation of command 'START'
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class StartGameCommandExecutor extends AbstractCommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /** The next guess. */
    private NumberGuess nextGuess;

    /**
     * Instantiates a new start game command executor.
     *
     * @param gameInputOutput the game input output
     * @param nextNumberGuess the next number guess
     */
    public StartGameCommandExecutor(GameInputOutput gameInputOutput, NumberGuess nextNumberGuess) {
        this.gameInputOutput = gameInputOutput;
        this.nextGuess = nextNumberGuess;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(@NotNull String command) {
        return StringUtils.isNotBlank(command) && Command.READY.is(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        nextGuess.reset();
        long nextHighNumber = nextGuess.nextHighNumber(0);
        context.put(KEY_CURRENT_GUESS, nextHighNumber);
        gameInputOutput.write(Messages.I_GUESS_NUMBER.getMessage(nextHighNumber));
    }

}
