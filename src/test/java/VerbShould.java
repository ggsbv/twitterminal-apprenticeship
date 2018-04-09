import com.codurance.twitterminal.Verb;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VerbShould {
    @Test
    public void
    identify_a_post_type() {
        assertThat(Verb.valueFor("->"), is(Verb.POST));
    }
}
