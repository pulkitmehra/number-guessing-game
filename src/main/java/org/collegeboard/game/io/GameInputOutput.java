package org.collegeboard.game.io;

/**
 * Game input and output operation abstraction.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public interface GameInputOutput {

    /**
     * Write output to any media type.
     *
     * @param text the text
     */
    public void write(String text);

    /**
     * Read from any media type.
     *
     * @return the string
     */
    public String readLine();
}
