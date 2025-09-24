package request;

import io.restassured.http.Method;
import models.product.PartialProduct;
import models.product.Product;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class ProductRequest extends BaseRequest {

    public void getAllProducts() {
        Logs.info("(GET) Get All Products");

        final var response = getRequest()
                .basePath("products")
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void getSingleProduct(int id) {
        Logs.info("(GET) Get Single Product");

        final var response = getRequest()
                .basePath("products/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void sortProducts(Map<String, String> queryMap) {
        Logs.info("(GET) Sort Products");

        final var response = getRequest()
                .basePath("products")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void searchProducts(Map<String, String> queryMap) {
        Logs.info("(GET) Search Products");

        final var response = getRequest()
                .basePath("products/search")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void createProduct(Product product) {
        Logs.info("(POST) Create Product");

        final var response = getRequest()
                .basePath("products/add")
                .body(product)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    public void updateProduct(int id, Product product) {
        Logs.info("(PUT) Update Product");

        final var response = getRequest()
                .basePath("products/{id}")
                .pathParam("id", id)
                .body(product)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    public void partialUpdateProduct(int id, PartialProduct partialProduct) {
        Logs.info("(PATCH) Partial Update Product");

        final var response = getRequest()
                .basePath("products/{id}")
                .pathParam("id", id)
                .body(partialProduct)
                .request(Method.PATCH);

        ResponseManager.setResponse(response);
    }

    public void deleteProduct(int id) {
        Logs.info("(DELETE) Delete Product");

        final var response = getRequest()
                .basePath("products/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);
    }
}

