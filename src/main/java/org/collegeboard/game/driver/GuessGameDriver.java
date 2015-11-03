package org.collegeboard.game.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

/**
 * Driver class to run number game.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
@SpringBootApplication
@Import(ApplicationConfig.class)
public class GuessGameDriver implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(GuessGameDriver.class);

    @Autowired
    private GameProcessor numberGameDisplay;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            numberGameDisplay.displayWelcomeMessage();
            numberGameDisplay.start();
        }
        catch (Exception e) {
            LOG.error("Unexpected Exception occured. ", e);
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(
            GuessGameDriver.class);
        springApplicationBuilder.showBanner(false).logStartupInfo(false).web(false).run(args);
    }

}
