package org.collegeboard.game.command.executors;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Implementation for command 'YES'.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class YesCommandExecutor extends AbstractCommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /** The yes no command. */
    private YesNoCommand yesNoCommand;

    /** The start game command executor. */
    private StartGameCommandExecutor startGameCommandExecutor;

    /** The quit command executor. */
    private QuitCommandExecutor quitCommandExecutor;

    /**
     * Instantiates a new yes command executor.
     *
     * @param gameInputOutput the game input output
     * @param yesNoCommand the yes no command
     * @param startGameCommandExecutor the start game command executor
     * @param quitCommandExecutor the quit command executor
     */
    public YesCommandExecutor(GameInputOutput gameInputOutput, YesNoCommand yesNoCommand,
        StartGameCommandExecutor startGameCommandExecutor, QuitCommandExecutor quitCommandExecutor) {
        this.gameInputOutput = gameInputOutput;
        this.yesNoCommand = yesNoCommand;
        this.startGameCommandExecutor = startGameCommandExecutor;
        this.quitCommandExecutor = quitCommandExecutor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(String command) {
        return StringUtils.isNoneBlank(command) && Command.YES.is(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        gameInputOutput.write(Messages.I_KNEW_YOUR_GUESS.getMessage());
        boolean reply = yesNoCommand.execute(Optional.of(Messages.ANOTHER_GAME.getMessage()));
        if (reply) {
            startGameCommandExecutor.execute(context, Command.READY.getValue());
        }
        else {
            quitCommandExecutor.execute(context, Command.QUIT.getValue());
        }
    }

}
