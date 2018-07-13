Feature: Loan request

  Scenario: EX1 request a car loan
    Given I have opened the loan request page
    When I select loan type 'Car-loan'
    And the amount I want to borrow is '2500'
    And I continue to explanation

  Scenario: EX3 request a car loan
    Given I have opened the loan request page
    When I select loan type 'Car-loan'
    And the amount I want to borrow is '2500'
    And I continue to explanation
    When I select that I have knowledge about loans
    And I continue to personal data
    When I fill the name as "Iron Man"
    And I am a male
    And I am born on 10-10-1978
    And I live on "Herostreet 3"
    And I have an income of 40000
    And I am married
    And I have a permanent contract
    And I upload my payment slip
    And I continue to submit the loan request
    Then I have to confirm my data

  Scenario Outline: EX5 validate loan information text
    Given the customer wants information about a loan
    When the customer wants a loan for "<loan type>"
    Then the customer receives the information text "<target information>"
    Examples:
      | loan type   | target information                                                           |
      | Groceries   | It is not a good idea to apply for a loan for just groceries.                |
      | Investments | Perhaps it is not such a good idea to apply for a loan for just investments. |
      | Bills       | A Revolving Credit or a Personal loan is probably the way to go.             |
      | Furniture   | A mini-loan or a Personal loan is probably the best choice.                  |
      | Car         | A Car-loan is the best choice when buying a car.                             |
      | House       | You need a mortgage.                                                         |

  Scenario: EX9 request a car loan
    Given I want a car loan
    When I loan the amount of "5000" euro
    Then I can get it