package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.product.PartialProduct;
import models.product.Product;
import request.ProductRequest;
import utilities.ResponseManager;

import java.util.Map;

public class ProductStepDefinition {

    private final ProductRequest productRequest = new ProductRequest();

    private Map<String, String> queryParamMap;
    private Product product;
    private PartialProduct partialProduct;

    @When("Llamar al request de obtener todos los productos")
    public void getAllProducts() {
        productRequest.getAllProducts();
    }

    @When("Llamar al request de obtener un solo Product con id {int}")
    public void getSingleProduct(int id) {
        productRequest.getSingleProduct(id);
    }

    @And("Hacer un SchemaValidation del responseBody de Product")
    public void doSchemaValidation() {
        ResponseManager.verifySchemaValidation("src/test/resources/schemas/product.json");
    }

    @When("Llamar al request de eliminar Product con id {int}")
    public void deleteProduct(int id) {
        productRequest.deleteProduct(id);
    }

    @Given("Ordenar productos por el valor de {string} y de manera {string}")
    public void prepareSortProducts(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("Llamar al request de ordenar Product")
    public void sortProduct() {
        productRequest.sortProducts(queryParamMap);
    }

    @Given("Buscar productos por opción {string}")
    public void prepareSearchProducts(String query) {
        queryParamMap = Map.of(
                "q", query
        );
    }

    @When("Llamar al request de buscar Products")
    public void searchProducts() {
        productRequest.searchProducts(queryParamMap);
    }

    @Given("Generar RequestBody de Product")
    public void generateRandomProduct() {
        product = Product.generateRandomProduct();
    }

    @When("Llamar al request de crear un Product")
    public void createProduct() {
        productRequest.createProduct(product);
    }


    @When("Llamar al request de actualizar un Product con id {int}")
    public void UpdateProduct(int id) {
        productRequest.updateProduct(id, product);
    }

    @Given("Generar RequestBody para actualizar de manera parcial un Product")
    public void generarPartialUpdateProduct() {
        partialProduct = PartialProduct.generateRandomPartialProduct();
    }

    @When("Llamar al request de actualizar parcialmente un Product con id {int}")
    public void partialUpdateProduct(int id) {
        productRequest.partialUpdateProduct(id, partialProduct);
    }
}
