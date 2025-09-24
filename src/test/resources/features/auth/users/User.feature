Feature: User

  Background: Autenticarse con el registro
    Given El usuario se autentica con el servidor

  @regression
  Scenario: Obtener todos los Users
    When Llamar al request de obtener todos los Users
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Obtener un solo User
    When Llamar al request de obtener un solo User con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms
    And Hacer un SchemaValidation del responseBody de User

  @regression @smoke
  Scenario: Eliminar User
    When Llamar al request de eliminar User con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression
  Scenario: Ordenar User
    Given Ordenar User por el valor de "age" y de manera "desc"
    When Llamar al request de ordenar User
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression
  Scenario: Filter User
    Given Buscar User por el filtro de "address.city" y la opcion "Phoenix"
    When Llamar al request de buscar User
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Crear User
    Given Generar RequestBody de User
    When Llamar al request de crear un User
    Then Verificar StatusCode sea 201
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Actualizar User
    Given Generar RequestBody de User
    When Llamar al request de actualizar un User con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Actualizar Parcialmente un User
    Given Generar RequestBody para actualizar de manera parcial un User
    When Llamar al request de actualizar parcialmente un User con id 2
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms
