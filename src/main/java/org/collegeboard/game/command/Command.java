package org.collegeboard.game.command;

import org.apache.commons.lang3.StringUtils;

/**
 * The Enum Command.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public enum Command {

  // @formatter:off
    /** The high. */
    HIGH("high"),
    
    /** The low. */
    LOW("low"), 
    
    /** The yes. */
    YES("yes"),
    
    /** The no. */
    NO("no"), 
    
    /** The y. */
    Y("y"), 
    
    /** The n. */
    N("N"), 
    
    /** The ready. */
    READY("ready"), 
    
    /** The restart. */
    RESTART("restart"),
    
    /** The quit. */
    QUIT("quit");
 // @formatter:on

    /** The value. */
    private String value;

    /**
     * Instantiates a new command.
     *
     * @param value the value
     */
    private Command(String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Checks value supplied is equal to enum value.
     *
     * @param stringValue the value
     * @return true, if successful
     */
    public boolean is(String stringValue) {
        return StringUtils.isNotBlank(stringValue) && stringValue.equalsIgnoreCase(this.value);
    }

    /**
     * String to type.
     *
     * @param value the value
     * @return the command
     */
    public static Command fromValue(String value) {
        for (Command answer : Command.values()) {
            if (answer.value.equalsIgnoreCase(value)) {
                return answer;
            }
        }
        throw new IllegalArgumentException("Invalid Command type " + value);
    }

}
