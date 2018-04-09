package com.codurance.twitterminal;

import java.util.HashMap;
import java.util.Map;

import static com.codurance.twitterminal.Verb.POST;
import static com.codurance.twitterminal.Verb.READ;

public class CommandFactories {
    private Map<Verb, CommandFactory> factories = new HashMap<>();

    public CommandFactories(UserRepository userRepository, PostRepository postRepository, Clock clock) {
        factories.put(POST, new PostCommandFactory(userRepository, postRepository, clock));
        factories.put(READ, new ReadCommandFactory(postRepository));
    }
    
    public CommandFactory factoryFor(Verb verb) {
        if (factories.get(verb) == null) {
            throw new UnsupportedOperationException();
        }

        return factories.get(verb);
    }
}
