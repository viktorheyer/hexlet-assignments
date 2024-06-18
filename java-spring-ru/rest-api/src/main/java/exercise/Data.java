package exercise;

import net.datafaker.Faker;
import exercise.model.Post;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Data {
    private static final int ITEMS_COUNT = 30;
    private static final List<Post> posts = new ArrayList<>();

    static {
        Faker faker = new Faker();

        List<Integer> ids = IntStream
                .range(1, ITEMS_COUNT + 1)
                .boxed()
                .toList();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            var post = new Post();
            post.setSlug("post" + ids.get(i));
            post.setTitle(faker.gameOfThrones().house());
            post.setBody(faker.gameOfThrones().quote());
            post.setUserId((i + 1) % 5);
            posts.add(post);
        }
    }

    public static List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public static void addPost(Post post) {
        posts.add(post);
    }
}
