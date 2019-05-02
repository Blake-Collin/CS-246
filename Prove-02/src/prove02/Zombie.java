package prove02;

import java.awt.Color;

/** Zombie Class that attacks anything not a plant or flying
 *
 * @author Collin Blake
 * @since 5-2-2019
 */
public class Zombie extends Creature implements Movable, Aggressor {

  private int direction;

  public Zombie() {
    direction = 0;
    _health = 1;
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
    return new Color(33, 33, 135);
  }

  /**
   * Attack creature we encounter if it is not a plant do 10
   *
   * @param target The {@link Creature}
   */
  @Override
  public void attack(Creature target) {
    if (target == null || target instanceof Plant || target instanceof Flying) {
      return;
    }
    target.takeDamage(10);
    _health++;
  }

  /** Move the Zombie from Right to left. */
  @Override
  public void move() {
    _location.x++;
  }
}
