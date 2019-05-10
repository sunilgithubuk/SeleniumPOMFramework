Feature: test the sun web Oauth E2E scenarios

  @SunRegister
  Scenario Outline: user should be able to register on Sub website with Optin to marketing permission
    Given user is on sun homepage
    When  sign up with marketing permission <status>
    Then  user should be logged in on sun

    Examples:
      | status |
      | no  |
      | yes |

  @SunRegister
    Scenario: user should be able to login to Sun web site using Oath
      Given user is on sun homepage
      When  log in with existing user credentials
      Then user should get logged in

  @SunRegister33
  Scenario: user should be able to log out from Sun web site using Oath
    Given user is on sun homepage
    And  log in with existing user credentials
    When click sign out
    Then user should get logged out

