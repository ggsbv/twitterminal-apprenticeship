import com.codurance.twitterminal.InputParser;
import com.codurance.twitterminal.ParsedInput;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputParserShould {
    @Test
    public void
    parse_input() {
        ParsedInput expectedParsedInput = new ParsedInput("Sandro", "->", "Hello Tony!");
        InputParser inputParser = new InputParser();

        ParsedInput parsedInput = inputParser.parse("Sandro -> Hello Tony!");

        assertThat(parsedInput, is(expectedParsedInput));
    }
}
