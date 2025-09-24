package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.post.PartialPost;
import models.post.Post;
import request.PostRequest;
import utilities.ResponseManager;

import java.util.Map;

public class PostStepDefinition {

    private final PostRequest postRequest = new PostRequest();
    private Map<String, String> queryParamMap;
    private Post post;
    private PartialPost partialPost;

    @When("Llamar al request de obtener todos los post")
    public void getAllPost() {
        postRequest.getAllPost();
    }

    @When("Llamar al request de obtener un solo Post con id {int}")
    public void getSinglePost(int id) {
        postRequest.getSinglePost(id);
    }

    @And("Hacer un SchemaValidation del responseBody de Post")
    public void doSchemaValidationPost() {
        ResponseManager.verifySchemaValidation("src/test/resources/schemas/post.json");
    }

    @When("Llamar al request de eliminar Post con id {int}")
    public void deletePost(int id) {
        postRequest.deletePost(id);
    }

    @Given("Ordenar post por el valor de {string} y de manera {string}")
    public void prepareSortOrder(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("Llamar al request de ordenar Post")
    public void sortPosts() {
        postRequest.sortPosts(queryParamMap);

    }

    @Given("Buscar post por opcion {string}")
    public void prepareSearchOption(String query) {
        queryParamMap = Map.of(
                "q", query
        );
    }

    @When("Llamar al request de buscar Post")
    public void searchPosts() {
        postRequest.searchPosts(queryParamMap);
    }

    @Given("Generar RequestBody de Post")
    public void generateRequestBodyPost() {
        post = Post.generateRandomPost();
    }

    @When("Llamar al request de crear un Post")
    public void createPost() {
        postRequest.createPost(post);
    }

    @When("Llamar al request de actualizar un Post con id {int}")
    public void updatePost(int id) {
        postRequest.updatePost(id, post);
    }

    @Given("Generar RequestBody para actualizar de manera parcial un Post")
    public void generateRequestBodyPartialPost() {
        partialPost = PartialPost.generateRandomPartilPost();
    }

    @When("Llamar al request de actualizar parcialmente un Post con id {int}")
    public void partialUpdatePost(int id) {
        postRequest.partialUpdatePost(id, partialPost);
    }
}
