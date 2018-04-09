package com.codurance.twitterminal;

import java.util.Objects;

public class PostCommandFactory implements CommandFactory {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final Clock clock;

    public PostCommandFactory(UserRepository userRepository, PostRepository postRepository, Clock clock) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.clock = clock;
    }
    
    public Command commandFor(ParsedInput input) {
        User user = new User(input.subject());

        return new PostCommand(user, new Post(user, input.text(), clock.currentTime()), userRepository, postRepository);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommandFactory that = (PostCommandFactory) o;
        return Objects.equals(userRepository, that.userRepository) &&
                Objects.equals(postRepository, that.postRepository);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userRepository, postRepository);
    }
}
