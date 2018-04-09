import com.codurance.twitterminal.Command;
import com.codurance.twitterminal.Commands;
import com.codurance.twitterminal.ParsedInput;
import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostCommand;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.User;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandsShould {
    @Test
    public void
    get_post_command_for_parsed_input() {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        Commands commands = new Commands(userRepository, postRepository);
        ParsedInput parsedInput = new ParsedInput("Bob", "->", "Yo man!");
        User user = new User("Bob");
        Post post = new Post(user, "Yo man!");
        Command expectedCommand = new PostCommand(user, post, userRepository, postRepository);

        Command command = commands.commandFor(parsedInput);

        assertThat(command, is(expectedCommand));
    }
}
