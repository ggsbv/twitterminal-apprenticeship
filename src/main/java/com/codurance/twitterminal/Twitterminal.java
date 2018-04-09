package com.codurance.twitterminal;

public class Twitterminal {
    private InputParser inputParser;
    private Commands commands;

    public Twitterminal(InputParser inputParser, Commands commands) {
        this.inputParser = inputParser;
        this.commands = commands;
    }

    public void execute(String input) {
        ParsedInput parsedInput = inputParser.parse(input);
        Command command = commands.commandFor(parsedInput);
        command.execute();
    }
}
