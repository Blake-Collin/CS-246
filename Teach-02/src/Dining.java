/**
 * Dining Expenses based on
 *
 * @author Collin Blake
 * @since 4-29-2019
 */

public class Dining implements Expense {

  //Variables
  int days;
  Destination destination;

  Dining(int pDays, Destination pDestination)
  {
    days = pDays;
    destination = pDestination;
  }


  public float getCost() {
    return 0;
  }

}
