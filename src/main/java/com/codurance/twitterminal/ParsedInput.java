package com.codurance.twitterminal;

import java.util.Objects;

import static com.codurance.twitterminal.Verb.*;

public class ParsedInput {
    private final String subject;
    private final Verb verb;
    private final String text;

    public ParsedInput(String subject) {
        this.subject = subject;
        this.verb = READ;
        this.text = "";
    }

    public ParsedInput(String subject, String verb, String text) {
        this.subject = subject;
        this.verb = valueFor(verb);
        this.text = text;
    }

    public String subject() {
        return subject;
    }

    public Verb verb() {
        return verb;
    }

    public String text() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedInput that = (ParsedInput) o;
        return Objects.equals(subject, that.subject) &&
                verb == that.verb &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subject, verb, text);
    }
}
