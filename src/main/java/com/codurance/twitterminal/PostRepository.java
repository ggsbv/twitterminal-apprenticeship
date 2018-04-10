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

    public List<Post> findByAuthor(User user) {
        List<Post> postsByAuthor = new ArrayList<>();

        for (Post post: posts) {
            if (post.author().equals(user)) {
                postsByAuthor.add(post);
            }
        }

        return postsByAuthor;
    }
}
