package request;

import io.restassured.http.Method;
import models.user.PartialUser;
import models.user.User;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class UserRequest extends BaseRequest {

    public void getAllUsers() {
        Logs.info("(GET) Get All Users");

        final var response = getRequest()
                .basePath("users")
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void getSingleUser(int id) {
        Logs.info("(GET) Get Single User");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void deleteUser(int id) {
        Logs.info("(DELETE) Delete User");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);
    }

    public void sortUsers(Map<String, String> queryMap) {
        Logs.info("(GET) Sort Users");

        final var response = getRequest()
                .basePath("users")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void filterUsers(Map<String, String> queryMap) {
        Logs.info("(GET) Filter Users");

        final var response = getRequest()
                .basePath("users/filter")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void createUser(User user) {
        Logs.info("(POST) Create User");

        final var response = getRequest()
                .basePath("users/add")
                .body(user)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    public void updateUser(int id, User user) {
        Logs.info("(PUT) Update User");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .body(user)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    public void partialUpdateUser(int id, PartialUser partialUser) {
        Logs.info("(PATCH) Partial Update User");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .body(partialUser)
                .request(Method.PATCH);

        ResponseManager.setResponse(response);
    }
}

