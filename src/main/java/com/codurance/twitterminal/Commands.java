package com.codurance.twitterminal;

public class Commands {
    private UserRepository userRepository;
    private PostRepository postRepository;

    public Commands(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Command commandFor(ParsedInput parsedInput) {
        if (parsedInput.verb().equals("->")) {
            String username = parsedInput.subject();
            String text = parsedInput.directObject();
            User user = new User(username);

            return new PostCommand(user, new Post(user, text), userRepository, postRepository);
        }

        return null;
    }
}
