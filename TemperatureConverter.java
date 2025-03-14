/*
14. Write a java program to implement abstract class and abstract method with following details:

Create a abstract Base Class Temperature Data members:
double temp;
Method members:
void setTempData(double) abstact void changeTemp()
   
Sub Class Fahrenheit (subclass of Temperature) Data members:
double ctemp;
method member:
Override abstract method changeTemp() to convert Fahrenheit temperature into degree Celsius by using formula C=5/9*(F-32) and display converted temperature

Sub Class Celsius	(subclass of Temperature)
Data member:
double ftemp;
Method member:
Override abstract method changeTemp() to convert degree Celsius into Fahrenheit temperature by using formula F=9/5*c+32 and display converted temperature
*/

import java.util.Scanner;

// Abstract Base Class Temperature
abstract class Temperature {
    protected double temp;
    
    // Method to set temperature data
    public void setTempData(double temp) {
        this.temp = temp;
    }
    
    // Abstract method to change temperature
    abstract void changeTemp();
}

// Sub Class Fahrenheit
class Fahrenheit extends Temperature {
    private double ctemp;
    
    // Override abstract method to convert Fahrenheit to Celsius
    @Override
    void changeTemp() {
        ctemp = 5.0 / 9.0 * (temp - 32);
        System.out.println(temp + "°F = " + ctemp + "°C");
    }
}

// Sub Class Celsius
class Celsius extends Temperature {
    private double ftemp;
    
    // Override abstract method to convert Celsius to Fahrenheit
    @Override
    void changeTemp() {
        ftemp = 9.0 / 5.0 * temp + 32;
        System.out.println(temp + "°C = " + ftemp + "°F");
    }
}

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create objects of both subclasses
        Fahrenheit fahrenheit = new Fahrenheit();
        Celsius celsius = new Celsius();
        
        // Menu for temperature conversion
        int choice;
        do {
            System.out.println("\nTemperature Conversion Menu:");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fTemp = scanner.nextDouble();
                    fahrenheit.setTempData(fTemp);
                    fahrenheit.changeTemp();
                    break;
                case 2:
                    System.out.print("Enter temperature in Celsius: ");
                    double cTemp = scanner.nextDouble();
                    celsius.setTempData(cTemp);
                    celsius.changeTemp();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        
        scanner.close();
    }
} 