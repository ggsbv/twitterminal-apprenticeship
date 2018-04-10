package com.codurance.twitterminal;

import java.util.Objects;

public class ReadCommandFactory implements CommandFactory {
    private final PostRepository postRepository;
    private final TimelinePrinter timelinePrinter;

    public ReadCommandFactory(PostRepository postRepository, TimelinePrinter timelinePrinter) {
        this.postRepository = postRepository;
        this.timelinePrinter = timelinePrinter;
    }

    @Override
    public Command commandFor(ParsedInput input) {
        return new ReadCommand(new User(input.subject()), postRepository, timelinePrinter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadCommandFactory that = (ReadCommandFactory) o;
        return Objects.equals(postRepository, that.postRepository);
    }

    @Override
    public int hashCode() {

        return Objects.hash(postRepository);
    }
}
