package com.codurance.twitterminal;

import java.util.Comparator;
import java.util.List;

public class TimelinePrinter {
    private final Console console;
    private final TimestampFormatter timestampFormatter;

    public TimelinePrinter(Console console, TimestampFormatter timestampFormatter) {
        this.console = console;
        this.timestampFormatter = timestampFormatter;
    }

    public void print(List<Post> posts) {
        posts.stream()
                .sorted(Comparator.comparing(Post::date).reversed())
                .map(post -> String.format("%s (%s)", post.text(), timestampFormatter.formatTimeAgo(post.date())))
                .forEach(console::printLine);
    }
}
