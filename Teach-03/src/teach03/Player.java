package teach03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Basic Player Class to hold player statistics
 *
 * @author Richard, David, & Collin
 * @since 5-6-2019
 * @version 1.0.0
 */
public class Player {

  // Variables
  private String name;
  private int health;
  private int mana;
  private int gold;
  private Map<String, Integer> equipment;


  public Player(String pName, int pHealth, int pMana, int pGold) {
    name = pName;
    health = pHealth;
    mana = pMana;
    gold = pGold;
    equipment = new HashMap();
  }

  /** Will Display our Player stats to the terminal */
  public void display() {
    System.out.println("Name: " + this.name);
    System.out.println("Health: " + this.health);
    System.out.println("Mana: " + this.mana);
    System.out.println("Gold: " + this.gold);
    for (Map.Entry<String, Integer> item : equipment.entrySet()) {
      System.out.println(item.getKey() + ": " + item.getValue());
    }
  }

  public void addEquipment(String pName, int pPrice) {
    equipment.put(pName, pPrice);
  }
}
