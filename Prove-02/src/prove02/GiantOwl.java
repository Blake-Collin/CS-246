package prove02;

import com.sun.javafx.scene.traversal.Direction;
import java.awt.Color;
import java.util.Random;

/**
 * GiantOwl will look for Zombies but is not hunting
 *
 * @author Collin Blake
 * @since 5-2-2019
 */
public class GiantOwl extends Creature implements Movable, Flying {

  // Variables
  Random _rand = new Random();
  private Direction direction;
  private int counter;
  private int maxCounter;

  public GiantOwl() {
    direction = Direction.values()[_rand.nextInt(4)];
    counter = 0;
    _health = 1;
  }

  @Override
  Shape getShape() {
    return Shape.Circle;
  }

  @Override
  Color getColor() {
    return new Color(255, 165, 0);
  }

  @Override
  Boolean isAlive() {
    return (_health > 0);
  }

  @Override
  public void swoop(Creature target) {
    if (target != null && target instanceof Zombie) {
      target.takeDamage(5);
      _health++;
    }
  }

  /** Owl will travel in random direction for a random amount of time before switching directions */
  @Override
  public void move() {
    // New Random Direction once we have traveled our random max
    if (counter > maxCounter) {
      direction = Direction.values()[_rand.nextInt(4)];
      maxCounter = _rand.nextInt(10);
      counter = 0;
    }

    // Move
    switch (direction) {
      case RIGHT:
        _location.x++;
        break;
      case LEFT:
        _location.x--;
        break;
      case DOWN:
        _location.y++;
        break;
      case UP:
        _location.y--;
        break;
      default:
        break;
    }

    // Increase Counter
    counter++;
  }
}
