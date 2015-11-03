/*
 * COPYRIGHT:     Copyright reserved by Pulkit Mehra
 */
package org.collegeboard.game.command;

/**
 * Error scenario if executor not found for any given command
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CommandExecutorNotFoundException extends Exception {

    /** */
    private static final long serialVersionUID = 996766645693043057L;

    /**
     * Instantiates a new command executor not found exception.
     *
     * @param msg the msg
     * @param e the e
     */
    public CommandExecutorNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * Instantiates a new command executor not found exception.
     *
     * @param msg the msg
     */
    public CommandExecutorNotFoundException(String msg) {
        super(msg);
    }
}
