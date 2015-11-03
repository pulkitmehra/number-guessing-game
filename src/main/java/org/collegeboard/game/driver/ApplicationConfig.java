package org.collegeboard.game.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.collegeboard.game.CoarseGrainedGuess;
import org.collegeboard.game.NumberGuess;
import org.collegeboard.game.RangeGenerator;
import org.collegeboard.game.command.CommandExecutor;
import org.collegeboard.game.command.CommandExecutorFactory;
import org.collegeboard.game.command.executors.CatchAllCommandExecutor;
import org.collegeboard.game.command.executors.GuessNumberCommandExecutor;
import org.collegeboard.game.command.executors.InvalidCommandExecutor;
import org.collegeboard.game.command.executors.QuitCommandExecutor;
import org.collegeboard.game.command.executors.RestartGameCommandExecutor;
import org.collegeboard.game.command.executors.StartGameCommandExecutor;
import org.collegeboard.game.command.executors.YesCommandExecutor;
import org.collegeboard.game.command.executors.YesNoCommand;
import org.collegeboard.game.io.ConsoleCLIInputOutput;
import org.collegeboard.game.io.GameInputOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration class.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
@Configuration
public class ApplicationConfig {

    @Value("${range.generator.basenumber}")
    private int baseNumber;

    /**
     * Game processor.
     *
     * @param gameInputOutput the game input output
     * @param commandParser the command parser
     * @param context the context
     * @return the game processor
     */
    @Bean
    public GameProcessor gameProcessor(GameInputOutput gameInputOutput, CommandExecutorFactory commandParser,
        Context context) {
        return new GameProcessor(gameInputOutput, commandParser, context);
    }

    /**
     * Game input output.
     *
     * @return the game input output
     */
    @Bean
    public GameInputOutput gameInputOutput() {
        return new ConsoleCLIInputOutput(System.in, System.out);
    }

    /**
     * Context.
     *
     * @return the context
     */
    @Bean
    public Context context() {
        return new Context(new HashMap<>());
    }

    /**
     * Command executor factory.
     *
     * @param gameInputOutput the game input output
     * @param numberGuess the number guess
     * @param yesNoCommand the yes no command
     * @return the command executor factory
     */
    @Bean
    public CommandExecutorFactory commandExcecutorFactory(GameInputOutput gameInputOutput,
        NumberGuess numberGuess, YesNoCommand yesNoCommand) {
        StartGameCommandExecutor startGameCommandExecutor = new StartGameCommandExecutor(gameInputOutput,
            numberGuess);
        QuitCommandExecutor quitCommandExecutor = new QuitCommandExecutor(gameInputOutput, yesNoCommand);

        List<CommandExecutor> commandExecutors = new ArrayList<>();
        commandExecutors.add(new InvalidCommandExecutor(gameInputOutput));
        commandExecutors.add(startGameCommandExecutor);
        commandExecutors.add(new GuessNumberCommandExecutor(gameInputOutput, numberGuess));
        commandExecutors
            .add(new RestartGameCommandExecutor(gameInputOutput, startGameCommandExecutor, yesNoCommand));
        commandExecutors.add(quitCommandExecutor);
        commandExecutors.add(new YesCommandExecutor(gameInputOutput, yesNoCommand, startGameCommandExecutor,
            quitCommandExecutor));
        commandExecutors.add(new CatchAllCommandExecutor(gameInputOutput));

        return new CommandExecutorFactory(commandExecutors);
    }

    /**
     * Yes no command.
     *
     * @param gameInputOutput the console io
     * @return the yes no command
     */
    @Bean
    public YesNoCommand yesNoCommand(GameInputOutput gameInputOutput) {
        return new YesNoCommand(gameInputOutput);
    }

    /**
     * Next guess.
     *
     * @param rangeGenerator the range generator
     * @return the next guess
     */
    @Bean
    public NumberGuess nextGuess(RangeGenerator rangeGenerator) {
        return new CoarseGrainedGuess(rangeGenerator);
    }

    /**
     * Range generator.
     *
     * @return the range generator
     */
    @Bean
    public RangeGenerator rangeGenerator() {
        return new RangeGenerator(baseNumber);
    }

}
