package com.codurance.twitterminal;

import java.util.Objects;

public class ParsedInput {
    private final String subject;
    private final String verb;
    private final String directObject;

    public ParsedInput(String subject, String verb, String directObject) {
        this.subject = subject;
        this.verb = verb;
        this.directObject = directObject;
    }

    public String subject() {
        return subject;
    }

    public String verb() {
        return verb;
    }

    public String directObject() {
        return directObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedInput that = (ParsedInput) o;
        return Objects.equals(subject, that.subject) &&
                Objects.equals(verb, that.verb) &&
                Objects.equals(directObject, that.directObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subject, verb, directObject);
    }

}
