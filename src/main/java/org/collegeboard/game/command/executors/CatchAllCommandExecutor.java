package org.collegeboard.game.command.executors;

import org.collegeboard.game.command.CommandExecutor;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * This is a Catch All command executor.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CatchAllCommandExecutor implements CommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /**
     * Instantiates a new catch all command executor.
     *
     * @param gameInputOutput the game input output
     */
    public CatchAllCommandExecutor(GameInputOutput gameInputOutput) {
        this.gameInputOutput = gameInputOutput;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(String command) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        gameInputOutput.write(Messages.NOT_SURE_WHAT_YOU_MEAN.getMessage());
        gameInputOutput.write(Messages.getUsageMessage());
    }

}
