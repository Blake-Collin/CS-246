public class Cruise implements Expense {

  // Variable
  private Destination destination;

  Cruise(Destination destination) {
    this.destination = destination;
  }

  public float getCost() {
    float cost = 0;

    //Switch for each destination
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
