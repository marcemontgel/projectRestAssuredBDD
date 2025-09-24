Feature: Products

  Background: Autenticarse con el registro
    Given El usuario se autentica con el servidor

  @regression
  Scenario: Obtener todos los Productos
    When Llamar al request de obtener todos los productos
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Obtener un solo Producto
    When Llamar al request de obtener un solo Product con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms
    And Hacer un SchemaValidation del responseBody de Product

  @regression @smoke
  Scenario: Eliminar Producto
    When Llamar al request de eliminar Product con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression
  Scenario: Ordenar Productos
    Given Ordenar productos por el valor de "price" y de manera "asc"
    When Llamar al request de ordenar Product
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression
  Scenario: Buscar Productos
    Given Buscar productos por opción "kitchen"
    When Llamar al request de buscar Products
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms


  @regression @smoke
  Scenario: Crear Producto
    Given Generar RequestBody de Product
    When Llamar al request de crear un Product
    Then Verificar StatusCode sea 201
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Actualizar Producto
    Given Generar RequestBody de Product
    When Llamar al request de actualizar un Product con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Actualizar Parcialmente un Producto
    Given Generar RequestBody para actualizar de manera parcial un Product
    When Llamar al request de actualizar parcialmente un Product con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms