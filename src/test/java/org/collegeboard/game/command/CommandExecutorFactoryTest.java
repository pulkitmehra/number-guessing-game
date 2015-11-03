/*
 * COPYRIGHT:     Copyright reserved by Pulkit Mehra
 */
package org.collegeboard.game.command;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class CommandExecutorFactoryTest.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CommandExecutorFactoryTest {

    /** The start command executor. */
    @Mock
    private CommandExecutor startCommandExecutor;

    /** The end command executor. */
    @Mock
    private CommandExecutor endCommandExecutor;

    /** The command executor factory. */
    private CommandExecutorFactory commandExecutorFactory;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<CommandExecutor> commandExecutors = new ArrayList<>();
        commandExecutors.add(startCommandExecutor);
        commandExecutors.add(endCommandExecutor);
        commandExecutorFactory = new CommandExecutorFactory(commandExecutors);
    }

    /**
     * Find command executor test.
     *
     * @throws Exception the exception
     */
    @Test
    public void findCommandExecutorTest() throws Exception {
        when(startCommandExecutor.canExecute("end")).thenReturn(false);
        when(endCommandExecutor.canExecute("end")).thenReturn(true);

        CommandExecutor commandExecutor = commandExecutorFactory.findCommandExecutor("end");
        assertThat(commandExecutor, is(endCommandExecutor));

        verify(startCommandExecutor).canExecute("end");
        verify(endCommandExecutor).canExecute("end");
    }

    /**
     * Find command executor unknow commad test.
     *
     * @throws Exception the exception
     */
    @Test(expected = CommandExecutorNotFoundException.class)
    public void findCommandExecutorUnknowCommadTest() throws Exception {
        when(startCommandExecutor.canExecute("UNKNOWN_CMD")).thenReturn(false);
        when(endCommandExecutor.canExecute("UNKNOWN_CMD")).thenReturn(true);

        commandExecutorFactory.findCommandExecutor("end");
    }
}
