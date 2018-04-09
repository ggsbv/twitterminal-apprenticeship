package com.codurance.twitterminal;

import java.util.Objects;

public class ParsedInput {
    private final String subject;
    private final Verb verb;
    private final String text;

    public ParsedInput(String subject, String verb, String text) {
        this.subject = subject;
        this.verb = Verb.valueFor(verb);
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
                Objects.equals(verb, that.verb) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subject, verb, text);
    }

}
