Feature: No Auth Post

  @regression
  Scenario: Obtener todos los Post
    When Llamar al request de obtener todos los post
    Then Verificar StatusCode sea 401

  @regression @smoke
  Scenario: Obtener un solo Post
    When Llamar al request de obtener un solo Post con id 2
    Then Verificar StatusCode sea 401

  @regression @smoke
  Scenario: Eliminar Post
    When Llamar al request de eliminar Post con id 2
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Ordenar Post
    Given Ordenar post por el valor de "views" y de manera "asc"
    When Llamar al request de ordenar Post
    Then Verificar StatusCode sea 401

  @regression
  Scenario: Buscar Post
    Given Buscar post por opcion "history"
    When Llamar al request de buscar Post
    Then Verificar StatusCode sea 401

  @regression @smoke
  Scenario: Crear Post
    Given Generar RequestBody de Post
    When Llamar al request de crear un Post
    Then Verificar StatusCode sea 401

  @regression @smoke
  Scenario: Actualizar Post
    Given Generar RequestBody de Post
    When Llamar al request de actualizar un Post con id 2
    Then Verificar StatusCode sea 401

  @regression @smoke
  Scenario: Actualizar Parcialmente un Post
    Given Generar RequestBody para actualizar de manera parcial un Post
    When Llamar al request de actualizar parcialmente un Post con id 2
    Then Verificar StatusCode sea 401