package prove02;

import com.sun.javafx.scene.traversal.Direction;
import java.awt.Color;
import java.util.Random;

/**
 * Keep
 *
 * @author Collin Blake
 * @since 5-2-2019
 */

public class GiantOwl extends Creature implements Movable, Flying {

  // Variables
  Random _rand = new Random();
  private Direction direction;
  private int counter;

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

  /**
   * Owl will travel in 5 step straight lines.
   */
  @Override
  public void move() {
    //New Random Direction once we have traveled 5
    if(counter > 4) {
      direction = Direction.values()[_rand.nextInt(4)];
      counter = 0;
    }
    //Move
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

    //Increase Counter
    counter++;

  }
}
