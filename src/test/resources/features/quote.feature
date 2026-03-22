Feature: Travel Insurance Quote Flow

  Scenario: User navigation UK page, fills complete form for Japan trip
    Given I am on the travel insurance quote page
    When I enter destination "Japan"
    Then I click on next button
    And I enter departure date "01/08/2026"
    And I enter return date "15/08/2026"
    Then I click on next button
    And I enter traveller age "06/09/2000"
    Then I click on checkbox
    And I click Get Quote
    Then the quote page should be displayed

  Scenario: User navigation to US site
    Given I am on the us home page
    Then the us quote page should be displayed
    When I selects "Alaska" as residence
    Then I click on next button
    When I enter destination "france"
    Then I click on next button
    And I enter departure date "01/08/2026"
    And I enter return date "15/08/2026"
    Then I click on next button
    Then the us quote page should be displayed


