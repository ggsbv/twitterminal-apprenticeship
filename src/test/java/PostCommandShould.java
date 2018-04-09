import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostCommand;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.User;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostCommandShould {
    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @Mock
    private Post post;

    @Mock
    private PostRepository postRepository;

    @Test
    public void
    store_a_user() {
        PostCommand postCommand = new PostCommand(user, post, userRepository, postRepository);

        postCommand.execute();

        verify(userRepository).store(user);
    }

    @Test
    public void
    store_a_post() {
        PostCommand postCommand = new PostCommand(user, post, userRepository, postRepository);

        postCommand.execute();

        verify(postRepository).store(post);
    }
}
