package org.collegeboard.game.driver;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;
import org.collegeboard.game.command.Command;

/**
 * The Enum Messages. This class reads a message properties file from classpath.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public enum Messages {

    /** The banner. */
 // @formatter:off
    BANNER,
    
    /** The usage. */
    USAGE,
    
    /** The usage start. */
    USAGE_START,
    
    /** The error. */
    ERROR,
    
    /** The are you sure. */
    ARE_YOU_SURE,
    
    /** The default no. */
    DEFAULT_NO,
    
    /** The i knew your guess. */
    I_KNEW_YOUR_GUESS,
    
    /** The another game. */
    ANOTHER_GAME,
    
    /** The i guess number. */
    I_GUESS_NUMBER,
    
    /** The invalid command. */
    INVALID_COMMAND,
    
    /** The i guess number high. */
    I_GUESS_NUMBER_HIGH,
    
    /** The i guess number low. */
    I_GUESS_NUMBER_LOW,
    
    /** The not sure what you mean. */
    NOT_SURE_WHAT_YOU_MEAN,
    
    /** The thank you. */
    THANK_YOU,
    
    /** The game desc. */
    GAME_DESC;
 // @formatter:on

    /** The Constant LINE_SEPERATOR. */
    private static final String LINE_SEPERATOR = System.getProperty("line.separator");

    /** The Constant RESOURCE_BASE_NAME. */
    private static final String RESOURCE_BASE_NAME = "game-message";

    /** The resource bundle. */
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BASE_NAME);

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return resourceBundle.getString(name());
    }

    /**
     * Gets the message, with place-holders populated with parameters.
     * if arguments are passed as null, then the place-holders will remain as it is.
     *
     * @param arguments the argument
     * @return the formatted message
     */
    public String getMessage(String... arguments) {
        return MessageFormat.format(getMessage(), (Object[]) arguments);
    }

    /**
     * Gets the message, with place-holders populated with parameters.
     * if arguments are passed as null, then the place-holders will remain as it is.
     *
     * @param arguments the arguments
     * @return the message
     */
    public String getMessage(Object... arguments) {
        return MessageFormat.format(getMessage(), arguments);
    }

    /**
     * Display message.
     *
     * @return the string
     */
    public static String displayMessage() {
        String banner = BANNER.getMessage();
        StringBuilder builder = new StringBuilder();
        builder.append("=======================================" + LINE_SEPERATOR);
        builder.append("|---------" + banner + "-----------|" + LINE_SEPERATOR);
        builder.append("=======================================" + LINE_SEPERATOR);
        return builder.toString();
    }

    /**
     * Display usage message.
     *
     * @return the string
     */
    public static String getUsageMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(GAME_DESC.getMessage() + LINE_SEPERATOR);
        builder.append(USAGE.getMessage(StringUtils.join(Command.values(), ",")) + LINE_SEPERATOR);
        return builder.toString();
    }

    /**
     * Gets the ready message.
     *
     * @return the ready message
     */
    public static String getReadyMessage() {
        return USAGE_START.getMessage(Command.READY.getValue()) + LINE_SEPERATOR;
    }
}
