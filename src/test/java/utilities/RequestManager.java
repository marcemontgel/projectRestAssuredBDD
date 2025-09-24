package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import request.AuthRequest;

public class RequestManager {
    public void initRequest() {
        Logs.info("Creando Request");
        final var request = RestAssured.given().spec(buildRequestSpec());

        Logs.debug("Guardar el request en el Request Provider");
        new RequestProvider().set(request);
    }

    public RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .addFilter(new RequestFilter())
                .setBaseUri("https://dummyjson.com/auth")
                .setContentType(ContentType.JSON)
                .build();
    }

    public void initAuth() {
        Logs.info("Autenticacion con el request de login");
        final var authResponse = new AuthRequest();
        authResponse.login("src/test/resources/requestsBody.dummyjson/login.json");
        final var token = ResponseManager.getPathAsString("accessToken");

        new RequestProvider().get().auth().preemptive().oauth2(token);
    }
}

