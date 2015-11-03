package org.collegeboard.game.command;

/**
 * Error scenario for command executors.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CommandExecutorException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new command executor exception.
     *
     * @param msg the msg
     * @param e the e
     */
    public CommandExecutorException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * Instantiates a new command executor exception.
     *
     * @param msg the msg
     */
    public CommandExecutorException(String msg) {
        super(msg);
    }
}
