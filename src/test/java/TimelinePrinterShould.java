import com.codurance.twitterminal.Console;
import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.TimelinePrinter;
import com.codurance.twitterminal.TimestampFormatter;
import com.codurance.twitterminal.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimelinePrinterShould {
    @Mock
    private User user;

    @Mock
    private Console console;

    @Mock
    private TimestampFormatter timestampFormatter;

    @Test
    public void
    output_an_authors_posts_starting_from_newest_to_oldest() {
        TimelinePrinter timelinePrinter = new TimelinePrinter(console, timestampFormatter);
        LocalDateTime olderDate = LocalDateTime.now().minusMinutes(20);
        LocalDateTime newerDate = LocalDateTime.now().minusMinutes(10);
        Post oldPost = new Post(user, "I am hungry.", olderDate);
        Post newPost = new Post(user, "I am not hungry anymore, I ate.", newerDate);
        List<Post> posts = asList(oldPost, newPost);
        String newerFormattedPost = "I am not hungry anymore, I ate. (10 minutes ago)";
        String olderFormattedPost = "I am hungry. (20 minutes ago)";
        when(timestampFormatter.formatTimeAgo(newerDate)).thenReturn("10 minutes ago");
        when(timestampFormatter.formatTimeAgo(olderDate)).thenReturn("20 minutes ago");

        timelinePrinter.print(posts);

        verify(console).printLine(newerFormattedPost);
        verify(console).printLine(olderFormattedPost);
    }
}
