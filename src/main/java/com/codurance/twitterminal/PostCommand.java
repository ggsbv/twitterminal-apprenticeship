package com.codurance.twitterminal;

import java.util.Objects;

public class PostCommand extends Command {
    private final User user;
    private final Post post;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public PostCommand(User user, Post post, UserRepository userRepository, PostRepository postRepository) {
        this.user = user;
        this.post = post;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void execute() {
        userRepository.store(user);
        postRepository.store(post);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommand that = (PostCommand) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, post);
    }
}
