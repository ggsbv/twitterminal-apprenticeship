package com.codurance.twitterminal;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public List<Post> all() {
        return posts;
    }

    public void store(Post post) {
        posts.add(post);
    }
}
