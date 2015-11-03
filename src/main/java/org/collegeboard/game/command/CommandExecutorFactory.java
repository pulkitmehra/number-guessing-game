package org.collegeboard.game.command;

import java.util.List;
import net.sf.oval.constraint.NotNull;

/**
 * A factory for creating CommandExecutor objects.
 * NOTE: This class will be a bottleneck in design when commands increases. This should be
 * accessed in 0(1), use Map.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CommandExecutorFactory {

    /** The command executors. */
    private List<CommandExecutor> commandExecutors;

    /**
     * Instantiates a new command executor factory.
     *
     * @param commandExecutors the command executors
     */
    public CommandExecutorFactory(List<CommandExecutor> commandExecutors) {
        this.commandExecutors = commandExecutors;
    }

    /**
     * Find command executor.
     * NOTE: This is bottleneck in Design.
     *
     * @param command the commands
     * @return the command executor
     * @throws CommandExecutorNotFoundException the command executor not found exception
     */
    public CommandExecutor findCommandExecutor(@NotNull String command)
        throws CommandExecutorNotFoundException {

        return commandExecutors.stream().filter((ce) -> ce.canExecute(command)).findFirst().orElseThrow(
            () -> new CommandExecutorNotFoundException("Executor not found for given command " + command));

    }
}
