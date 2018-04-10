import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.ReadCommand;
import com.codurance.twitterminal.TimelinePrinter;
import com.codurance.twitterminal.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadCommandShould {
    @Mock
    private
    Post post;

    @Mock
    private
    User user;

    @Mock
    private
    PostRepository postRepository;

    @Mock
    private TimelinePrinter timelinePrinter;

    @Test
    public void
    print_a_users_timeline_to_the_console() {
        List<Post> posts = singletonList(post);
        when(postRepository.findByAuthor(user)).thenReturn(posts);
        ReadCommand readCommand = new ReadCommand(user, postRepository, timelinePrinter);

        readCommand.execute();

        verify(timelinePrinter).print(posts);
    }
}
