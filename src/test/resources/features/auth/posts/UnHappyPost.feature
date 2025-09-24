Feature: Post

  Background: Autenticarse con el registro
    Given El usuario se autentica con el servidor

  @regression @smoke
  Scenario: Obtener un solo Post
    When Llamar al request de obtener un solo Post con id 2500
    Then Verificar StatusCode sea 404

  @regression @smoke
  Scenario: Eliminar Post
    When Llamar al request de eliminar Post con id 2500
    Then Verificar StatusCode sea 404

  @regression @smoke
  Scenario: Actualizar Post
    Given Generar RequestBody de Post
    When Llamar al request de actualizar un Post con id 2500
    Then Verificar StatusCode sea 404

  @regression @smoke
  Scenario: Actualizar Parcialmente un Post
    Given Generar RequestBody para actualizar de manera parcial un Post
    When Llamar al request de actualizar parcialmente un Post con id 2500
    Then Verificar StatusCode sea 404