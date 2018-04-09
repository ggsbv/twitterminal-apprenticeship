import com.codurance.twitterminal.Clock;
import com.codurance.twitterminal.CommandFactories;
import com.codurance.twitterminal.CommandFactory;
import com.codurance.twitterminal.PostCommandFactory;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.ReadCommandFactory;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;

import static com.codurance.twitterminal.Verb.POST;
import static com.codurance.twitterminal.Verb.READ;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandFactoriesShould {
    @Test
    public void
    get_post_command_factory() {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        Clock clock = new Clock();
        CommandFactory expectedCommandFactory = new PostCommandFactory(userRepository, postRepository, clock);

        CommandFactory commandFactory = new CommandFactories(userRepository, postRepository, clock).factoryFor(POST);

        assertThat(commandFactory, is(expectedCommandFactory));
    }

    @Test
    public void
    get_read_command_factory() {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        CommandFactory expectedCommandFactory = new ReadCommandFactory(postRepository);
        Clock clock = new Clock();

        CommandFactory commandFactory = new CommandFactories(userRepository, postRepository, clock).factoryFor(READ);

        assertThat(commandFactory, is(expectedCommandFactory));
    }
}
