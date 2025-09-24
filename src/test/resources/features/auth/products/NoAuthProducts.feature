Feature: No Auth Products

  @regression
  Scenario: Obtener todos los Productos
    When Llamar al request de obtener todos los productos
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Obtener un solo Producto
    When Llamar al request de obtener un solo Product con id 2
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Eliminar Producto
    When Llamar al request de eliminar Product con id 2
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Ordenar Productos
    Given Ordenar productos por el valor de "price" y de manera "asc"
    When Llamar al request de ordenar Product
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Buscar Productos
    Given Buscar productos por opción "kitchen"
    When Llamar al request de buscar Products
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Crear Producto
    Given Generar RequestBody de Product
    When Llamar al request de crear un Product
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Actualizar Producto
    Given Generar RequestBody de Product
    When Llamar al request de actualizar un Product con id 2
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Actualizar Parcialmente un Producto
    Given Generar RequestBody para actualizar de manera parcial un Product
    When Llamar al request de actualizar parcialmente un Product con id 2
    Then Verificar StatusCode sea 401