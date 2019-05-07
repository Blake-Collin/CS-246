package teach03;

/**
 * Main Class for Testing Purposes
 *
 * @author Richard, David, & Collin
 * @since 5-6-2019
 * @version 1.0.0
 */
public class Main {

  public static void main(String[] args) {
    //Player
    Player currentPlayer = new Player("Yojimbo", 100, 100, 25143);
    //Equipment added
    currentPlayer.addEquipment("Longsword", 100);
    currentPlayer.addEquipment("Plate Mail", 300);
    currentPlayer.addEquipment("Shield", 50);
    currentPlayer.addEquipment("Necklace of Fireballs", 35000);
    currentPlayer.addEquipment("Boots of Springing/Striding", 3500);

    //Game Created
    Game currentGame = new Game(currentPlayer);

    //Display the stats
    currentGame.getPlayer1().display();

    //Save the game
    currentGame.saveGame();

    //Load the Game
    Game newGame = currentGame.loadGame();

    //Display new Game player stats
    newGame.getPlayer1().display();
  }
}
