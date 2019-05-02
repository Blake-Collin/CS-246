package prove02;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 *  Animals move around and eat plants. They are represented by red squares.
 * <p>
 * @author  Brother Falin
 * @version 1.0
 * @since   2016-12-08
 * @see Creature
 */
public class Animal extends Creature implements Movable, Aggressor, Spawner {

  Random _rand;
  private boolean canSpawn;

  /**
   * Creates an animal with 1 health point.
   */
  public Animal() {
    _rand = new Random();
    canSpawn = false;
    _health = 1;
  }

  // No javadocs are necessary for these methods because they will inherit the
  // documentation from the superclass. We only need to add docs here if we are
  // doing something non-obvious in our overridden version.

  public Boolean isAlive() {
    return _health > 0;
  }

  public Shape getShape() {
    return Shape.Square;
  }

  public Color getColor() {
    return new Color(165, 33, 135);
  }

  /**
   * If the creature we've encountered is a plant, we'll eat it. Otherwise, we ignore it.
   * @param target The {@link Creature} we've encountered.
   */
  public void attack(Creature target) {
    // Animals only eat plants. Give the plant 1 damage
    // and increase our health by one.
    if(target instanceof Plant) {
      target.takeDamage(1);
      _health++;
      canSpawn = true;
    }
  }

  /**
   * Move the animal in a random direction.
   */
  public void move() {

    // Choose a random direction each time move() is called.
    switch(_rand.nextInt(4)) {
      case 0:
        _location.x++;
        break;
      case 1:
        _location.x--;
        break;
      case 2:
        _location.y++;
        break;
      case 3:
        _location.y--;
        break;
      default:
        break;
    }
  }

  //Added animal spawning from eating plants for fun
  @Override
  public Creature spawnNewCreature() {
    if (canSpawn) {
      Animal newBorn = new Animal(); // Create new Animal
      canSpawn = false; // Remove spawn ability
      newBorn.setLocation((Point) _location.clone()); // Copy current location
      newBorn._location.x++; // Move right one
      return newBorn;
    } else {
      return null;
    }
  }
}
