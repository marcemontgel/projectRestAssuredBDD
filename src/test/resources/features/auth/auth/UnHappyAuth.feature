Feature: Auth con credenciales erroneas

  @regression
  Scenario: Login con credenciales vacias
    Given Obtener requestBody de login con credenciales "vacias"
    When Llamar al requestLogin
    Then Verificar StatusCode sea 400

  @regression
  Scenario: Login con credenciales invalidas
    Given Obtener requestBody de login con credenciales "invalidas"
    When Llamar al requestLogin
    Then Verificar StatusCode sea 400