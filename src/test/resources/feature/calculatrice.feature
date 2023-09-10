Feature: test fonctionnement calculatrice

  Scenario: Operation addition reussite

    Given J'accède à l'application via l'url "https://www.ma-calculatrice.fr/"
    When J'additionne les chiffres 9 et 5
    Then Je trouve le resulat 14