import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VacationCalculator {

  public static void main(String[] args) {

    VacationCalculator vc = new VacationCalculator();

    // Calculate some vacation costs...
    float japanCost = vc.calculateVacationCost(Destination.Japan);

    // Print the cost...
    System.out.println(
        "Cost for a Vacation to Japan: "
            + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(japanCost));
  }

  /**
   * Calculates the total cost for vacationing at a given location for a specific number of nights.
   *
   * @param dest the destination of the vacation
   * @return the total cost of the vacation
   */
  public float calculateVacationCost(Destination dest) {
    // Create List for expenses
    ArrayList expenses = new ArrayList<Expense>();

    // Cruise Cost
    expenses.add(new Cruise(dest));

    // Other Costs to be added.

    // Call tallyExpenses and return value
    return tallyExpenses(expenses);
  }

  /**
   * An internal method used by VacationCalculator to loop through a List of items that implement
   * the Expense interface and determine their cost
   *
   * @param expenses A list of items that implement the Expense interface
   * @return the total cost calculated by the items
   */
  float tallyExpenses(List<Expense> expenses) {
    float totalCost = 0;

    // Loop through
    for (Expense item : expenses) {
      totalCost += item.getCost();
    }
    return totalCost;
  }
}
