import com.codurance.twitterminal.Command;
import com.codurance.twitterminal.Commands;
import com.codurance.twitterminal.InputParser;
import com.codurance.twitterminal.ParsedInput;
import com.codurance.twitterminal.Twitterminal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwitterminalShould {
    private Twitterminal twitterminal;
    private String input;
    private ParsedInput parsedInput;

    @Mock
    private InputParser inputParser;

    @Mock
    private Commands commands;

    @Mock
    private Command command;

    @Before
    public void initialise() {
        input = "Sandro -> Hello Tony!";
        twitterminal = new Twitterminal(inputParser, commands);
        parsedInput = new ParsedInput("Sandro", "->", "Hello Tony!");
    }

    @Test
    public void
    call_input_parser_with_correct_input() {
        when(inputParser.parse(input)).thenReturn(parsedInput);
        when(commands.commandFor(parsedInput)).thenReturn(command);

        twitterminal.execute(input);

        verify(inputParser).parse(input);
    }


    @Test
    public void
    get_the_appropriate_command_for_the_parsed_input() {
        when(inputParser.parse(input)).thenReturn(parsedInput);
        when(commands.commandFor(parsedInput)).thenReturn(command);

        twitterminal.execute(input);

        verify(commands).commandFor(parsedInput);
    }

    @Test
    public void
    execute_command() {
        when(inputParser.parse(input)).thenReturn(parsedInput);
        when(commands.commandFor(parsedInput)).thenReturn(command);

        twitterminal.execute(input);

        verify(command).execute();
    }
}
