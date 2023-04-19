package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class GameBetter implements IGame {
   private final Players players;
   private final Questions questions;
   private final GameConfiguration gameConfiguration;
   private boolean isGettingOutOfPenaltyBox;

   public GameBetter() {
      this.questions = new Questions();
      this.players = new Players();
      this.gameConfiguration = new GameConfiguration();
   }

   private int rollDiceAction(int roll) {
      gameConfiguration.setPlayerPlace(players.getCurrentPlayer(), roll);

      System.out.println(players.getCurrentPlayerName()
              + "'s new location is "
              + gameConfiguration.getPlaces(players.getCurrentPlayer()));

      System.out.println("The category is " + currentCategory());
      return gameConfiguration.getPlaces(players.getCurrentPlayer());
   }

   public boolean add(String playerName) {
      players.addPlayer(playerName);
      gameConfiguration.addNewPlayerConfig(players.getCapacity());

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.getCapacity());
      return true;
   }

   public void roll(int roll) {
      System.out.println(players.getCurrentPlayerName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (gameConfiguration.getInPenaltyBox(players.getCurrentPlayer())) {
         isGettingOutOfPenaltyBox = roll % 2 != 0;

         if (isGettingOutOfPenaltyBox) {
            System.out.println(players.getCurrentPlayerName() + " is getting out of the penalty box");
            gameConfiguration.setPlaces(players.getCurrentPlayer(), rollDiceAction(roll));
            questions.askQuestion(currentCategory());
         } else {
            System.out.println(players.getCurrentPlayerName() + " is not getting out of the penalty box");
         }
      } else {
         rollDiceAction(roll);
         questions.askQuestion(currentCategory());
      }

   }

   private String currentCategory() {
      int place = gameConfiguration.getPlaces(players.getCurrentPlayer());
      return questions.getQuestionCategoryByPlace(place);
   }

   public boolean wasCorrectlyAnswered() {
      if (gameConfiguration.getInPenaltyBox(players.getCurrentPlayer())) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            boolean winner = gameConfiguration.incrementGoldCoins(players.getCurrentPlayer(), players.getCurrentPlayerName());
            players.incrementCurrentPlayer();
            return winner;
         } else {
            players.incrementCurrentPlayer();
            return true;
         }
      } else {
         System.out.println("Answer was correct!!!!");
         boolean winner = gameConfiguration.incrementGoldCoins(players.getCurrentPlayer(), players.getCurrentPlayerName());
         players.incrementCurrentPlayer();
         return winner;
      }
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(players.getCurrentPlayerName() + " was sent to the penalty box");

//      isGettingOutOfPenaltyBox = false;
      gameConfiguration.setInPenaltyBox(players.getCurrentPlayer(), true);
      players.incrementCurrentPlayer();
      return true;
   }
}
