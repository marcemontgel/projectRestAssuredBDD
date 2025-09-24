package request;

import io.restassured.http.Method;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.io.File;

public class AuthRequest extends BaseRequest {


    public void login(String filePath) {
        Logs.info("(POST) Login Request");

        final var response = getRequest()
                .basePath("login")
                .body(new File(filePath))
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }
}
