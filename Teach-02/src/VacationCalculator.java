import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Vacation Calculator to take a user's input for days and give calculation for each destination
 *
 * @author Collin Blake
 * @since 4-29-2019
 */
public class VacationCalculator {

  // Scanner Variable
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    VacationCalculator vc = new VacationCalculator();

    // Get days from user
    System.out.print("Please Input Desired Vacation Days: ");
    int days = scanner.nextInt();

    // Calculate some vacation costs...
    float japanCost = vc.calculateVacationCost(Destination.Japan, days);
    float mexicoCost = vc.calculateVacationCost(Destination.Mexico, days);
    float europeCost = vc.calculateVacationCost(Destination.Europe, days);

    // Print the cost...
    System.out.println(
        "\nJapan Cost: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(japanCost));
    System.out.println(
        "Mexico Cost: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(mexicoCost));
    System.out.println(
        "Europe Cost: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(europeCost));
  }

  /**
   * Calculates the total cost for vacationing at a given location for a specific number of nights.
   *
   * @param dest the destination of the vacation
   * @return the total cost of the vacation
   */
  public float calculateVacationCost(Destination dest, int days) {
    // Create List for expenses
    ArrayList expenses = new ArrayList<Expense>();

    // Cruise Cost
    expenses.add(new Cruise(dest));

    // Lodging Cost
    expenses.add(new Lodging(days, dest));

    // Dining Cost
    expenses.add(new Dining(days, dest));

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
