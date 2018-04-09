package com.codurance.twitterminal;

public class Commands {
    private final CommandFactories factories;

    public Commands(CommandFactories factories) {
        this.factories = factories;
    }

    public Command commandFor(ParsedInput parsedInput) {
        CommandFactory factory = factories.factoryFor(parsedInput.verb());

        return factory.commandFor(parsedInput);
    }
}
