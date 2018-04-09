import com.codurance.twitterminal.Post;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.User;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PostRepositoryShould {
    @Test
    public void
    should_store_a_post() {
        PostRepository postRepository = new PostRepository();
        User user = new User("Brother69");
        Post post = new Post(user, "I'm number one in the world!");
        List<Post> posts = singletonList(post);

        postRepository.store(post);

        assertThat(postRepository.all(), is(posts));
    }
}
