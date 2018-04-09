package acceptance;

import com.codurance.twitterminal.Clock;
import com.codurance.twitterminal.CommandFactories;
import com.codurance.twitterminal.Commands;
import com.codurance.twitterminal.Console;
import com.codurance.twitterminal.InputParser;
import com.codurance.twitterminal.PostRepository;
import com.codurance.twitterminal.Twitterminal;
import com.codurance.twitterminal.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadFeature {
    private Twitterminal twitterminal;

    @Mock
    private Console console;

    @Mock
    private Clock clock;

    @Test
    public void
    should_read_a_users_post() {
        InputParser inputParser = new InputParser();
        CommandFactories factories = new CommandFactories(new UserRepository(), new PostRepository(), clock);
        twitterminal = new Twitterminal(inputParser, new Commands(factories));
        when(clock.currentTime()).thenReturn(LocalDateTime.now().minusMinutes(20))
                .thenReturn(LocalDateTime.now().minusMinutes(10));
        twitterminal.execute("Tony -> Hello Sandro!");
        twitterminal.execute("Tony -> Yo, did I say hi?");

        twitterminal.execute("Tony");

        verify(console).print(
                "Yo, did I say hi? (10 minutes ago)\n" +
                "Hello Sandro! (20 minutes ago)"
        );
    }
}
