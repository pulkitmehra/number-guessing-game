package org.collegeboard.game.command.executors;

import java.util.Optional;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Implementation of Command 'RESTART'
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class RestartGameCommandExecutor extends AbstractCommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /** The start game command executor. */
    private StartGameCommandExecutor startGameCommandExecutor;

    /** The yes no command. */
    private YesNoCommand yesNoCommand;

    /**
     * Instantiates a new restart game command executor.
     *
     * @param gameInputOutput the game input output
     * @param startGameCommandExecutor the start game command executor
     * @param yesNoCommand the yes no command
     */
    public RestartGameCommandExecutor(GameInputOutput gameInputOutput,
        StartGameCommandExecutor startGameCommandExecutor, YesNoCommand yesNoCommand) {
        this.gameInputOutput = gameInputOutput;
        this.startGameCommandExecutor = startGameCommandExecutor;
        this.yesNoCommand = yesNoCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(@NotNull String command) {
        return StringUtils.isNotBlank(command) && Command.RESTART.is(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        boolean execute = yesNoCommand.execute(Optional.empty());
        if (execute) {
            gameInputOutput.write(Messages.getUsageMessage());
            gameInputOutput.write(Messages.getReadyMessage());
            startGameCommandExecutor.execute(context, Command.READY.getValue());
        }
    }

}
