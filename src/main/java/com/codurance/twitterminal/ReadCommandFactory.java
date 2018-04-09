package com.codurance.twitterminal;

import java.util.Objects;

public class ReadCommandFactory implements CommandFactory {
    private final PostRepository postRepository;

    public ReadCommandFactory(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Command commandFor(ParsedInput input) {
        return new ReadCommand(new User(input.subject()), postRepository);
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
