package org.collegeboard.game.command.executors;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.command.Command;
import org.collegeboard.game.driver.Messages;
import org.collegeboard.game.io.GameInputOutput;

/**
 * Yes/No dialog.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class YesNoCommand {

    /** The game input output. */
    private GameInputOutput gameInputOutput;

    /**
     * Instantiates a new yes no command.
     *
     * @param gameInputOutput the game input output
     */
    public YesNoCommand(GameInputOutput gameInputOutput) {
        this.gameInputOutput = gameInputOutput;
    }

    /**
     * Execute.
     *
     * @param text the text
     * @return true, if successful
     */
    public boolean execute(Optional<String> text) {

        gameInputOutput.write(text.orElse(Messages.ARE_YOU_SURE.getMessage()) + " [y/n]");
        String readLine = gameInputOutput.readLine();
        if (StringUtils.isBlank(readLine)) {
            gameInputOutput.write(Messages.DEFAULT_NO.getMessage());
            return false;
        }
        else if (Command.N.is(readLine)) {
            return false;
        }
        else {
            return true;
        }
    }

}
