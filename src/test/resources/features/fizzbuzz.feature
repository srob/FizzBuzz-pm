Feature: FizzBuzz scoring
  Players take turns answering and earn a point for each correct answer.
  The game displays both scores after every turn.

  Scenario: A correct answer earns player 1 a point
    Given a new two-player FizzBuzz game
    When player 1 answers "1"
    Then player 1 should have 1 point
    And player 2 should have 0 points
    And player 2 should be next
    And the game should display:
      """
      Turn 1 by Player 1: 1 (ScorePlayer1: 1, ScorePlayer2: 0)
      """

  Scenario: An incorrect answer earns no points
    Given a new two-player FizzBuzz game
    When player 1 answers "Fizz"
    Then player 1 should have 0 points
    And player 2 should have 0 points
    And player 2 should be next
    And the game should display:
      """
      Turn 1 by Player 1: 1 (ScorePlayer1: 0, ScorePlayer2: 0)
      """

  Scenario: Both scores are displayed after each player's turn
    Given a new two-player FizzBuzz game
    When player 1 answers "1"
    And player 2 answers "2"
    And player 1 answers "Fizz"
    Then player 1 should have 2 points
    And player 2 should have 1 point
    And player 2 should be next
    And the game should display:
      """
      Turn 1 by Player 1: 1 (ScorePlayer1: 1, ScorePlayer2: 0)
      Turn 2 by Player 2: 2 (ScorePlayer1: 1, ScorePlayer2: 1)
      Turn 3 by Player 1: Fizz (ScorePlayer1: 2, ScorePlayer2: 1)
      """
