import com.codurance.twitterminal.Clock;
import com.codurance.twitterminal.Command;
import com.codurance.twitterminal.CommandFactories;
import com.codurance.twitterminal.Commands;
import com.codurance.twitterminal.Console;
import com.codurance.twitterminal.ParsedInput;
import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostCommand;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.TimelinePrinter;
import com.codurance.twitterminal.TimestampFormatter;
import com.codurance.twitterminal.User;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandsShould {
    @Mock
    private Console console;

    @Test
    public void
    get_post_command_for_parsed_input() {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        Clock clock = new Clock();
        TimestampFormatter timestampFormatter = new TimestampFormatter();
        TimelinePrinter timelinePrinter = new TimelinePrinter(console, timestampFormatter);
        CommandFactories commandFactories = new CommandFactories(userRepository, postRepository, clock, timelinePrinter);
        Commands commands = new Commands(commandFactories);
        ParsedInput parsedInput = new ParsedInput("Bob", "->", "Yo man!");
        User user = new User("Bob");
        LocalDateTime currentTime = clock.currentTime();
        Post post = new Post(user, "Yo man!", currentTime);
        Command expectedCommand = new PostCommand(user, post, userRepository, postRepository);

        Command command = commands.commandFor(parsedInput);

        assertThat(command, is(expectedCommand));
    }
}
