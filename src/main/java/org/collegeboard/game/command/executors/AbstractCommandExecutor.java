package org.collegeboard.game.command.executors;

import org.collegeboard.game.command.CommandExecutor;
import org.collegeboard.game.driver.Context;

/**
 * Class haveing common state and methods of API {@link CommandExecutor}
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public abstract class AbstractCommandExecutor implements CommandExecutor {

    /** The Constant KEY_CURRENT_GUESS. */
    protected static final String KEY_CURRENT_GUESS = "current_guess";

    /**
     * Gets the current guess.
     *
     * @param context the context
     * @return the current guess
     */
    protected long getCurrentGuess(Context context) {
        Long current = (Long) context.get(KEY_CURRENT_GUESS);
        return current != null ? current.longValue() : 0L;
    }
}
