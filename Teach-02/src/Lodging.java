/**
 * Lodging Expenses based on days and location
 *
 * @author Collin Blake
 * @since 4-29-2019
 */
public class Lodging implements Expense {

  // Variables
  private int days;
  private Destination destination;

  Lodging(int pDays, Destination pDestination) {
    days = pDays;
    destination = pDestination;
  }

  /**
   * This getCost will calculate the cost based on the destination in question and days spent there
   *
   * @return cost of the lodging
   */
  public float getCost() {
    float cost = 0;

    // Switch for each destination
    switch (destination) {
      case Mexico:
        cost = 100 * days;
        break;
      case Europe:
        cost = 200 * days;
        break;
      case Japan:
        cost = 300 * days;
        break;
      default:
        cost = 0;
    }

    return cost;
  }
}
