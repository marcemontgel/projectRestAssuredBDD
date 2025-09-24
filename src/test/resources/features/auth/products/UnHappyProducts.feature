Feature: UnHappy Path de Product

  Background: Autenticarse con el registro
    Given El usuario se autentica con el servidor

  @regression @smoke
  Scenario: Obtener un solo Producto Inexistente
    When Llamar al request de obtener un solo Product con id 2500
    Then Verificar StatusCode sea 404
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Eliminar Producto Inexistente
    When Llamar al request de eliminar Product con id 2500
    Then Verificar StatusCode sea 404
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Actualizar Producto Inexistente
    Given Generar RequestBody de Product
    When Llamar al request de actualizar un Product con id 2500
    Then Verificar StatusCode sea 404
    And Verificar ResponseTime sea menor a 1200ms

  @regression @smoke
  Scenario: Actualizar Parcialmente un Producto Inexistente
    Given Generar RequestBody para actualizar de manera parcial un Product
    When Llamar al request de actualizar parcialmente un Product con id 2500
    Then Verificar StatusCode sea 404
    And Verificar ResponseTime sea menor a 1200ms