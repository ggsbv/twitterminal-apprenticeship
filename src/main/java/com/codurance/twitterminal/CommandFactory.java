package com.codurance.twitterminal;

public interface CommandFactory {
    Command commandFor(ParsedInput input);
}
