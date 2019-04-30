/**
 * Class to hold and calculate the cost of a Cruise to a specific location
 *
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
   * @param pDestination is the Destination of the cruise
   */
  Cruise(Destination pDestination) {
    destination = pDestination;
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
