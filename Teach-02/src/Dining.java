/**
 * Dining Expenses based on days and location
 *
 * @author Collin Blake
 * @since 4-29-2019
 */
public class Dining implements Expense {

  // Variables
  private int days;
  private Destination destination;

  Dining(int pDays, Destination pDestination) {
    days = pDays;
    destination = pDestination;
  }

  /**
   * This getCost will calculate the cost based on the destination in question and days spent there
   *
   * @return cost of the dining
   */
  public float getCost() {
    float cost = 0;

    // Switch for each destination
    switch (destination) {
      case Mexico:
        cost = 10 * days;
        break;
      case Europe:
        cost = 20 * days;
        cost *= 1.1;
        break;
      case Japan:
        cost = 30 * days;
        cost *= 1.3;
        break;
      default:
        cost = 0;
    }

    return cost;
  }
}
