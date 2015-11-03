package org.collegeboard.game.command.executors;

import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.command.CommandExecutor;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Implementation of invalid command executor.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class InvalidCommandExecutor implements CommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /**
     * Instantiates a new invalid command executor.
     *
     * @param gameInputOutput the game input output
     */
    public InvalidCommandExecutor(GameInputOutput gameInputOutput) {
        this.gameInputOutput = gameInputOutput;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(String command) {
        return command == null || StringUtils.isBlank(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        gameInputOutput.write(Messages.INVALID_COMMAND.getMessage());
        gameInputOutput.write(Messages.getUsageMessage());
    }
}
