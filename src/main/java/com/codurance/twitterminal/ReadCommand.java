package com.codurance.twitterminal;

public class ReadCommand implements Command {
    private final User user;
    private final PostRepository postRepository;

    public ReadCommand(User user, PostRepository postRepository) {
        this.user = user;
        this.postRepository = postRepository;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException();
    }
}
