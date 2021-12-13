Feature: devTo basic features
  Scenario: Open first seeing blog
    Given I go to devTo main page
    When I click on first blog displayed
    Then I should be redirected to blog page

  Scenario: Open and play first seeing podcast
    Given I go to devTo main page
    When I go to Podcasts section
    When I click on first Podcast on the list
    And I play the podcast
    Then Podcast Should be played

  Scenario: Search the phrase
    Given I go to devTo main page
    When I search for "spring" phrase
    Then Top 3 blogs found should have correct phrase in title

