package request;

import io.restassured.http.Method;
import models.post.PartialPost;
import models.post.Post;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class PostRequest extends BaseRequest {

    public void getAllPost() {
        Logs.info("(GET) Get All Post");

        final var response = getRequest()
                .basePath("posts")
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void getSinglePost(int id) {
        Logs.info("(GET) Get Single Post");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void deletePost(int id) {
        Logs.info("(DELETE) Delete Post");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);
    }

    public void sortPosts(Map<String, String> queryMap) {
        Logs.info("(GET) Sort Post");

        final var response = getRequest()
                .basePath("posts")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void searchPosts(Map<String, String> queryMap) {
        Logs.info("(GET) Search Post");

        final var response = getRequest()
                .basePath("posts/search")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void createPost(Post post) {
        Logs.info("POST) Create Post");

        final var response = getRequest()
                .basePath("posts/add")
                .body(post)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    public void updatePost(int id, Post post) {
        Logs.info("(PUT) Update Post");

        final var response = getRequest()
                .basePath("post/{id}")
                .pathParam("id", id)
                .body(post)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    public void partialUpdatePost(int id, PartialPost partialPost) {
        Logs.info("(PATCH) Partial Update Post");

        final var response = getRequest()
                .basePath("post/{id}")
                .pathParam("id", id)
                .body(partialPost)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }
}

