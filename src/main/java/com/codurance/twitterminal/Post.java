package com.codurance.twitterminal;

import java.util.Objects;

public class Post {
    private final User user;
    private final String text;

    public Post(User user, String text) {
        this.user = user;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(user, post.user) &&
                Objects.equals(text, post.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, text);
    }
}
