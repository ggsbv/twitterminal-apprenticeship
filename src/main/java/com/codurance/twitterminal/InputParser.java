package com.codurance.twitterminal;

public class InputParser {
    public ParsedInput parse(String input) {
        String[] inputElements = input.split(" ");

        if (inputElements.length == 1)
            return new ParsedInput(inputElements[0]);

        String verb = inputElements[1];
        String[] elementsToConstructParsedInput = input.split(verb);

        return new ParsedInput(elementsToConstructParsedInput[0].trim(), verb, elementsToConstructParsedInput[1].trim());
    }
}
