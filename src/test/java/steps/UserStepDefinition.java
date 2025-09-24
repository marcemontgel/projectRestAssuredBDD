package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.user.PartialUser;
import models.user.User;
import request.UserRequest;
import utilities.ResponseManager;

import java.util.Map;

public class UserStepDefinition {

    private final UserRequest userRequest = new UserRequest();
    private Map<String, String> queryParamMap;
    private User user;
    private PartialUser partialUser;

    @When("Llamar al request de obtener todos los Users")
    public void getAllUsers() {
        userRequest.getAllUsers();
    }

    @When("Llamar al request de obtener un solo User con id {int}")
    public void getSingleUser(int id) {
        userRequest.getSingleUser(id);
    }

    @And("Hacer un SchemaValidation del responseBody de User")
    public void doSchemaResponseBodyUser() {
        ResponseManager.verifySchemaValidation("src/test/resources/schemas/user.json");
    }

    @When("Llamar al request de eliminar User con id {int}")
    public void deleteUser(int id) {
        userRequest.deleteUser(id);
    }

    @Given("Ordenar User por el valor de {string} y de manera {string}")
    public void prepareSortUser(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("Llamar al request de ordenar User")
    public void sortUsers() {
        userRequest.sortUsers(queryParamMap);
    }

    @Given("Buscar User por el filtro de {string} y la opcion {string}")
    public void prepareFilterUser(String key, String value) {
        queryParamMap = Map.of(
                "key", key,
                "value", value
        );
    }

    @When("Llamar al request de buscar User")
    public void searchUsers() {
        userRequest.filterUsers(queryParamMap);
    }

    @Given("Generar RequestBody de User")
    public void generateRequestBodyUser() {
        user = User.generateRandomUser();
    }

    @When("Llamar al request de crear un User")
    public void createUser() {
        userRequest.createUser(user);
    }

    @When("Llamar al request de actualizar un User con id {int}")
    public void updateUser(int id) {
        userRequest.updateUser(id, user);
    }

    @Given("Generar RequestBody para actualizar de manera parcial un User")
    public void generatePartialUpdateUser() {
        partialUser = PartialUser.generateRandomPartialUser();
    }

    @When("Llamar al request de actualizar parcialmente un User con id {int}")
    public void partialUpdateUser(int id) {
        userRequest.partialUpdateUser(id, partialUser);
    }
}
