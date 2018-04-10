package com.codurance.twitterminal;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private final User author;
    private final String text;
    private LocalDateTime date;

    public Post(User author, String text, LocalDateTime date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public User author() {
        return author;
    }

    public String text() {
        return text;
    }

    public LocalDateTime date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) &&
                Objects.equals(text, post.text) &&
                Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, text, date);
    }
}
