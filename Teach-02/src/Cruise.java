/**
 * @author Collin Blake
 * @since 4-29-2019
 */
public class Cruise implements Expense {

  // Variable
  private Destination destination;

  /**
   * Cruise class constructor that will save the destination and hold getCost function from
   * Interface Expense
   *
   * @param destination is the Destination of the cruise
   */
  Cruise(Destination destination) {
    this.destination = destination;
  }

  /**
   * This getCost will calculate the cost based on the destination in question for a Cruise
   *
   * @return cost of the Cruise
   */
  public float getCost() {
    float cost = 0;

    // Switch for each destination
    switch (destination) {
      case Mexico:
        cost = 1000;
        break;
      case Europe:
        cost = 2000;
        break;
      case Japan:
        cost = 3000;
        break;
      default:
        cost = 0;
    }

    return cost;
  }
}
