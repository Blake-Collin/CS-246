package helloworld;
import java.util.Scanner;

public class CircleCalculator {

    //Variables
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CircleCalculator temp = new CircleCalculator();
        double radius = temp.getRadius();
        temp.displayCircumference(radius);
        temp.displayArea(radius);
    }

    public double getRadius() {
        //Ask user for input
        System.out.print("Please input a radius: ");

        double radius = scanner.nextDouble();

        return radius;
    }

    public void displayCircumference(double radius) {
        double circumference = 2 * radius * Math.PI;

        System.out.print("Circumference: ");
        System.out.format("%.2f%n",circumference);
    }

    public void displayArea(double radius) {
        double area = Math.PI * Math.pow(radius,2);

        System.out.print("Area: ");
        System.out.format("%.2f%n",area);
    }


}
