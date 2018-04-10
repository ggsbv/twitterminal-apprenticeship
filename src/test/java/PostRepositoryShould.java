import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PostRepositoryShould {
    @Mock
    private Post post;

    @Mock
    private User user;

    @Test
    public void
    should_store_a_post() {
        PostRepository postRepository = new PostRepository();
        List<Post> posts = singletonList(post);

        postRepository.store(post);

        assertThat(postRepository.all(), is(posts));
    }

    @Test
    public void
    should_find_all_posts_by_given_author() {
        PostRepository postRepository = new PostRepository();
        Post firstPost = new Post(user, "Hello.", LocalDateTime.now());
        Post secondPost = new Post(user, "Hello again.", LocalDateTime.now());
        Post anotherPost = new Post(new User("Edward"), "I'm new.", LocalDateTime.now());
        postRepository.store(firstPost);
        postRepository.store(secondPost);
        postRepository.store(anotherPost);
        List<Post> expectedPosts = asList(firstPost, secondPost);

        List<Post> posts = postRepository.findByAuthor(user);

        assertThat(posts, is(expectedPosts));
    }
}
