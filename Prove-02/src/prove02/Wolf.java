package prove02;

import com.sun.javafx.scene.traversal.Direction;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 * Wolf class that will move be aware and attack animals it hunts
 *
 * @author Collin Blake
 * @since 5-1-2019
 */
public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {

  Random _rand = new Random();
  private Direction pDirection;
  private boolean canSpawn;

  public Wolf() {
    pDirection = Direction.values()[_rand.nextInt(4)];
    _health = 1;
    canSpawn = false;
  }

  @Override
  public Boolean isAlive() {
    return _health > 0;
  }

  @Override
  public Shape getShape() {
    return Shape.Square;
  }

  @Override
  public Color getColor() {
    return new Color(128, 128, 128);
  }

  /**
   * Attack creature we encounter if it is not a plant or zombie
   *
   * @param target The {@link Creature}
   */
  @Override
  public void attack(Creature target) {
    if (target == null || !(target instanceof Animal)) {
      return;
    }
    target.takeDamage(5);
    _health++;
    canSpawn = true;
  }

  /** Move the Zombie Right to left. */
  @Override
  public void move() {
    switch (pDirection) {
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
  }

  /**
   * Wolf will chase closest animal looking in a clockwise pattern or if it is directly in front of
   * it first
   *
   * @param above The {@link Creature} directly above us.
   * @param below The {@link Creature} directly below us.
   * @param left The {@link Creature} directly to the left of us.
   * @param right The {@link Creature} directly to the right of us.
   */
  @Override
  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

    // Check if any animals even exist
    if (above == null && right == null && below == null && left == null) {
      return;
    }

    // check preferred direction first
    switch (pDirection) {
      case RIGHT:
        if (right instanceof Animal) {
          return;
        }
        break;
      case LEFT:
        if (left instanceof Animal) {
          return;
        }
        break;
      case UP:
        if (above instanceof Animal) {
          return;
        }
        break;
      case DOWN:
        if (below instanceof Animal) {
          return;
        }
        break;
      default:
        break;
    }

    // Check for animals clockwise from up
    if (above instanceof Animal) {
      pDirection = Direction.UP;
    } else if (right instanceof Animal) {
      pDirection = Direction.RIGHT;
    } else if (below instanceof Animal) {
      pDirection = Direction.DOWN;
    } else if (left instanceof Animal) {
      pDirection = Direction.LEFT;
    }

    // No Animals detected change nothing

  }

  @Override
  public Creature spawnNewCreature() {
    if (canSpawn) {
      Wolf puppy = new Wolf(); // Create new Wolf
      canSpawn = false; // Remove spawn ability
      puppy.setLocation((Point) _location.clone()); // Copy current location
      puppy._location.x--; // Move left one
      return puppy;
    } else {
      return null;
    }
  }
}
