package org.collegeboard.game.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.commons.lang3.StringUtils;

/**
 * Implementation of {@link GameInputOutput}.
 * Operation will write on Console.
 * 
 * 
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class ConsoleCLIInputOutput implements GameInputOutput {

    /** The reader. */
    private BufferedReader reader;

    /** The writer. */
    private BufferedWriter writer;

    /**
     * Instantiates a new console cli input output.
     *
     * @param in the in
     * @param out the out
     */
    public ConsoleCLIInputOutput(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(String text) {
        try {
            writer.write(text);
            writer.newLine();
            writer.flush();
        }
        catch (IOException e) {
            throw new GameInputOutputException("Failed to wrte to output stream ", e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String readLine() {
        try {
            return StringUtils.trimToEmpty(reader.readLine());
        }
        catch (IOException e) {
            throw new GameInputOutputException("Failed to wrte to output stream ", e);
        }
    }

}
