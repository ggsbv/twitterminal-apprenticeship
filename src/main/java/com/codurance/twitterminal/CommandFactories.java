package com.codurance.twitterminal;

import java.util.HashMap;
import java.util.Map;

import static com.codurance.twitterminal.Verb.POST;

public class CommandFactories {
    private Map<Verb, CommandFactory> factories = new HashMap<>();

    public CommandFactories(UserRepository userRepository, PostRepository postRepository) {
        factories.put(POST, new PostCommandFactory(userRepository, postRepository));
    }
    
    public CommandFactory factoryFor(Verb verb) {
        return factories.get(verb);
    }
}
