package org.collegeboard.game.command.executors;

import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.NumberGuess;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.command.CommandExecutorException;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Implementation of Command 'HIGH' or 'LOW'.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class GuessNumberCommandExecutor extends AbstractCommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /** The number guess. */
    private NumberGuess numberGuess;

    /**
     * Instantiates a new guess number command executor.
     *
     * @param gameInputOutput the game input output
     * @param numberGuess the number guess
     */
    public GuessNumberCommandExecutor(GameInputOutput gameInputOutput, NumberGuess numberGuess) {
        this.gameInputOutput = gameInputOutput;
        this.numberGuess = numberGuess;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(@NotNull String command) {
        return StringUtils.isNoneBlank(command) && (Command.HIGH.is(command) || Command.LOW.is(command));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, @NotNull String command) throws CommandExecutorException {
        Command commandEnum = Command.fromValue(command);
        long currentNumber = getCurrentGuess(context);
        switch (commandEnum) {
            case HIGH:
                long nextHighNumber = numberGuess.nextHighNumber(currentNumber);
                gameInputOutput.write(Messages.I_GUESS_NUMBER_HIGH.getMessage(nextHighNumber));
                context.put(KEY_CURRENT_GUESS, nextHighNumber);
                break;
            case LOW:
                long nextLowNumber = numberGuess.nextLowNumber(currentNumber);
                gameInputOutput.write(Messages.I_GUESS_NUMBER_LOW.getMessage(nextLowNumber));
                context.put(KEY_CURRENT_GUESS, nextLowNumber);
                break;
            default:
                throw new CommandExecutorException("Unsupported command type " + command);
        }
    }

}
