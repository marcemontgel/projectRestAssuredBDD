Feature: User

  Background: Autenticarse con el registro
    Given El usuario se autentica con el servidor

  @regression
  Scenario: Obtener un solo User
    When Llamar al request de obtener un solo User con id 2500
    Then Verificar StatusCode sea 404

  @regression
  Scenario: Eliminar User
    When Llamar al request de eliminar User con id 2500
    Then Verificar StatusCode sea 404

  @regression
  Scenario: Actualizar User
    Given Generar RequestBody de User
    When Llamar al request de actualizar un User con id 2500
    Then Verificar StatusCode sea 404

  @regression
  Scenario: Actualizar Parcialmente un User
    Given Generar RequestBody para actualizar de manera parcial un User
    When Llamar al request de actualizar parcialmente un User con id 2500
    Then Verificar StatusCode sea 404
