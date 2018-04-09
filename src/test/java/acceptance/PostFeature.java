package acceptance;

import com.codurance.twitterminal.Clock;
import com.codurance.twitterminal.CommandFactories;
import com.codurance.twitterminal.Commands;
import com.codurance.twitterminal.InputParser;
import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.Twitterminal;
import com.codurance.twitterminal.User;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Collections.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostFeature {
    @Mock
    private Clock clock;

    @Test
    public void
    should_create_a_new_user_that_has_one_post() {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        InputParser inputParser = new InputParser();
        CommandFactories commandFactories = new CommandFactories(userRepository, postRepository, clock);
        Commands commands = new Commands(commandFactories);
        Twitterminal twitterminal = new Twitterminal(inputParser, commands);
        List<User> expectedUsers = singletonList(new User("Sandro"));
        LocalDateTime currentTime = clock.currentTime();
        List<Post> expectedPosts = singletonList(new Post(expectedUsers.get(0), "Hello everyone.", currentTime));
        when(clock.currentTime()).thenReturn(currentTime);

        twitterminal.execute("Sandro -> Hello everyone.");

        assertThat(userRepository.all(), is(expectedUsers));
        assertThat(postRepository.all(), is(expectedPosts));
    }
}
