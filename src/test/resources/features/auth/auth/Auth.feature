Feature: Auth

  @regression @smoke
  Scenario: Login Valido
    Given Obtener requestBody de login con credenciales "validas"
    When Llamar al requestLogin
    Then Verificar StatusCode sea 200
    And Verificar ResponseTime sea menor a 1200ms
    And Obtener requestBody de Login
    And Verificar Id sea positivo
    And Verificar longitud de accessToken y refreshToken sea igual a 360
