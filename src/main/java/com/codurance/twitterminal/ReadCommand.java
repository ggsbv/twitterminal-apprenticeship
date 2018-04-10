package com.codurance.twitterminal;

import java.util.List;

public class ReadCommand implements Command {
    private final User user;
    private final PostRepository postRepository;
    private TimelinePrinter timelinePrinter;

    public ReadCommand(User user, PostRepository postRepository, TimelinePrinter timelinePrinter) {
        this.user = user;
        this.postRepository = postRepository;
        this.timelinePrinter = timelinePrinter;
    }

    @Override
    public void execute() {
        List<Post> posts = postRepository.findByAuthor(user);
        timelinePrinter.print(posts);
    }
}
