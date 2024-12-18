Feature: Проверка функции field

  Scenario: Получение одного поля из списка товаров
    Given a list of goods
    When I get the "title" field
    Then I should get the result ["Ковер", "Диван для отдыха"]

  Scenario: Получение нескольких полей
    Given a list of goods
    When I get the "title" and "price" fields
    Then I should get the result [{"title": "Ковер", "price": 2000}, {"title": "Диван для отдыха"}]

  Scenario: Передача пустых аргументов
    Given a list of goods
    When I try to get an empty field list
    Then I should receive an error "Необходимо передать хотя бы одно поле."
