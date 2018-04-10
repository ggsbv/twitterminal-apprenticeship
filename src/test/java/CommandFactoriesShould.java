import com.codurance.twitterminal.Clock;
import com.codurance.twitterminal.CommandFactories;
import com.codurance.twitterminal.CommandFactory;
import com.codurance.twitterminal.PostCommandFactory;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.ReadCommandFactory;
import com.codurance.twitterminal.TimelinePrinter;
import com.codurance.twitterminal.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.codurance.twitterminal.Verb.POST;
import static com.codurance.twitterminal.Verb.READ;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoriesShould {
    private CommandFactories commandFactories;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private TimelinePrinter timelinePrinter;

    @Mock
    private Clock clock;

    @Before
    public void initialise() {
        commandFactories = new CommandFactories(userRepository, postRepository, clock, timelinePrinter);
    }

    @Test
    public void
    get_post_command_factory() {
        CommandFactory expectedCommandFactory = new PostCommandFactory(userRepository, postRepository, clock);

        CommandFactory commandFactory = commandFactories.factoryFor(POST);

        assertThat(commandFactory, is(expectedCommandFactory));
    }

    @Test
    public void
    get_read_command_factory() {
        CommandFactory expectedCommandFactory = new ReadCommandFactory(postRepository, timelinePrinter);

        CommandFactory commandFactory = commandFactories.factoryFor(READ);

        assertThat(commandFactory, is(expectedCommandFactory));
    }
}
