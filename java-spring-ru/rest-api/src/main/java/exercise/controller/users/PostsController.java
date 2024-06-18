package exercise.controller.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

@RestController
@RequestMapping("/api/users/{id}/posts")
public class PostsController {

    @GetMapping
    public List<Post> getUserPosts(@PathVariable int id) {
        List<Post> allPosts = Data.getPosts();

        List<Post> userPosts = allPosts.stream()
                .filter(post -> post.getUserId() == id)
                .collect(Collectors.toList());

        return userPosts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@PathVariable int id, @RequestBody Post newPost) {
        // Устанавливаем userId из параметра маршрута
        newPost.setUserId(id);

        // Добавляем пост в общий список постов
        Data.addPost(newPost);

        return newPost;
    }
}
