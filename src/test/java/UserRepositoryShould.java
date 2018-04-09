import com.codurance.twitterminal.User;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserRepositoryShould {
    @Test
    public void
    store_a_user() {
        UserRepository userRepository = new UserRepository();
        User user = new User("Jack");
        List<User> users = singletonList(user);

        userRepository.store(user);

        assertThat(userRepository.all(), is(users));
    }

    @Test
    public void
    not_store_an_existing_user() {
        UserRepository userRepository = new UserRepository();
        User user = new User("Jack");
        List<User> users = singletonList(user);

        userRepository.store(user);
        userRepository.store(user);

        assertThat(userRepository.all(), is(users));
    }
}
