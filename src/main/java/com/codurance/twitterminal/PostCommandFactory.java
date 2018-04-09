package com.codurance.twitterminal;

public class PostCommandFactory implements CommandFactory {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostCommandFactory(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
    
    public Command commandFor(ParsedInput input) {
        User user = new User(input.subject());

        return new PostCommand(user, new Post(user, input.text()), userRepository, postRepository);
    }
}
