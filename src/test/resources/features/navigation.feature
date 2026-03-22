Feature: Site Navigation Flow

  @smoke
  Scenario: User opens whats covered page, verifies content and clicks Get Quote
    Given I am on the whats covered page
    Then the whats covered page should be displayed
    And coverage items should be listed on the page
    When I click Get Quote from the whats covered page