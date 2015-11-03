package org.collegeboard.game.command;

import org.collegeboard.game.driver.Context;

/**
 * Abstraction API of command executors.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public interface CommandExecutor {

    /**
     * Decides whether command is matched to execute.
     *
     * @param command the command
     * @return true, if successful
     */
    public boolean canExecute(String command);

    /**
     * Execute command.
     *
     * @param context the context
     * @param command the command
     * @throws CommandExecutorException the command executor exception
     */
    public void execute(Context context, String command) throws CommandExecutorException;
}
