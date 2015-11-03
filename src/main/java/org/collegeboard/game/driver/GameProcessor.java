package org.collegeboard.game.driver;

import org.collegeboard.game.command.CommandExecutor;
import org.collegeboard.game.command.CommandExecutorFactory;
import org.collegeboard.game.io.GameInputOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameProcessor.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class GameProcessor {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(GameProcessor.class);

    /** The game io. */
    private GameInputOutput gameIO;

    /** The command excecutor factory. */
    private CommandExecutorFactory commandExcecutorFactory;

    /** The context. */
    private Context context;

    /**
     * Instantiates a new game processor.
     *
     * @param gameInputOutput the game input output
     * @param commandExcecutorFactory the command excecutor factory
     * @param context the context
     */
    public GameProcessor(GameInputOutput gameInputOutput, CommandExecutorFactory commandExcecutorFactory,
        Context context) {
        this.gameIO = gameInputOutput;
        this.commandExcecutorFactory = commandExcecutorFactory;
        this.context = context;
    }

    /**
     * Display welcome message.
     */
    public void displayWelcomeMessage() {
        gameIO.write(Messages.displayMessage());
        gameIO.write(Messages.getUsageMessage());
        gameIO.write(Messages.getReadyMessage());
    }

    /**
     * Start.
     */
    public void start() {
        while (true) {
            try {
                String command = gameIO.readLine();
                CommandExecutor commandExecutor = commandExcecutorFactory.findCommandExecutor(command);
                commandExecutor.execute(context, command);
            }
            catch (Exception e) {
                LOG.error("Unknow error occured", e);
                gameIO.write(Messages.ERROR.getMessage());
                displayWelcomeMessage();
            }
        }

    }

}
