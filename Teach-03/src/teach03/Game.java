package teach03;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Game Class Will store all game variables
 *
 * @author Richard, David, & Collin
 * @since 5-6-2019
 * @version 1.0.0
 */
public class Game {

  // Variables
  private Player player1;

  public Game(Player pPlayer) {
    player1 = pPlayer;
  }

  public Player getPlayer1() {
    return player1;
  }

  /**
   * Function saveGame will convert player data into json string and save to text file "saveGame1"
   */
  public void saveGame() {
    Gson gson = new Gson();
    String savePlayer = gson.toJson(player1);
    try {
      File file = new File("saveGame1.txt");
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(savePlayer);
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Will load a player from file create new game and return
   *
   * @return Game Object
   */
  public static Game loadGame() {

    Player loadedPlayer = null;
    try {
      Gson gson = new Gson();
      String oldPlayer = new Scanner(new File("saveGame1.txt")).useDelimiter("\\Z").next();
      // System.out.println(oldPlayer); //Old Test code
      loadedPlayer = gson.fromJson(oldPlayer, Player.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Game newGame = new Game(loadedPlayer);
    return newGame;
  }
}
