package org.collegeboard.game.command.executors;

import java.util.Optional;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.command.CommandExecutor;
import org.collegeboard.game.driver.Context;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Implementation of Command 'QUIT'
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class QuitCommandExecutor implements CommandExecutor {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /** The yes no command. */
    private YesNoCommand yesNoCommand;

    /**
     * Instantiates a new quit command executor.
     *
     * @param gameInputOutput the game input output
     * @param yesNoCommand the yes no command
     */
    public QuitCommandExecutor(GameInputOutput gameInputOutput, YesNoCommand yesNoCommand) {
        this.gameInputOutput = gameInputOutput;
        this.yesNoCommand = yesNoCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(@NotNull String command) {
        return StringUtils.isNotBlank(command) && Command.QUIT.is(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        boolean reply = yesNoCommand.execute(Optional.empty());
        if (reply) {
            gameInputOutput.write(Messages.THANK_YOU.getMessage());
            System.exit(0);
        }
        else {
            gameInputOutput.write(Messages.getUsageMessage());
        }
    }

}
