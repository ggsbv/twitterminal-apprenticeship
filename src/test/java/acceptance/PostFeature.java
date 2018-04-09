package acceptance;

import com.codurance.twitterminal.Commands;
import com.codurance.twitterminal.InputParser;
import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.Twitterminal;
import com.codurance.twitterminal.User;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PostFeature {
    @Test
    public void
    should_create_a_new_user_that_has_one_post() {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        InputParser inputParser = new InputParser();
        Commands commands = new Commands(userRepository, postRepository);
        Twitterminal twitterminal = new Twitterminal(inputParser, commands);
        List<User> expectedUsers = singletonList(new User("Sandro"));
        List<Post> expectedPosts = singletonList(new Post(expectedUsers.get(0), "Hello everyone."));

        twitterminal.execute("Sandro -> Hello everyone.");

        assertThat(userRepository.all(), is(expectedUsers));
        assertThat(postRepository.all(), is(expectedPosts));
    }
}
