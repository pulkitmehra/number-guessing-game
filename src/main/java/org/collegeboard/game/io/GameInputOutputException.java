package org.collegeboard.game.io;

/**
 * Exception scenario for Game input and output operation.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class GameInputOutputException extends RuntimeException {

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new game input output exception.
     *
     * @param msg the msg
     * @param e the e
     */
    public GameInputOutputException(String msg, Throwable e) {
        super(msg, e);
    }
}
