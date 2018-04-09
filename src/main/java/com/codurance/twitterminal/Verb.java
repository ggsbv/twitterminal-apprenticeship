package com.codurance.twitterminal;

public enum Verb {
    POST("->"),
    READ("");

    private String value;

    Verb(String value) {
        this.value = value;
    }

    public static Verb valueFor(String text) {
        for (Verb verb: values()) {
            if (verb.value.equals(text))
                return verb;
        }

        return Verb.READ;
    }
}
