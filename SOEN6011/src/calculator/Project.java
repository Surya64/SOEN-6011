package calculator;

import calculator.Utility;
import java.util.Scanner;

/**
 * The Project program implements an application to calculate
 * the inverse cosine of value x and prints the output on the screen.
 * @author Surya Prakash Govindaraju
 * @version 1.0
 * @since 2019-07-25
 *
 */

public class Project {
  /**
   * This Method calculates square root of a number.
   * 
   * @param number This is parameter to findSquareRoot method
   */
  public static double findSquareRoot(double number) {


    double temp;

    double sr = number / 2;

    do {
      temp = sr;
      sr = (temp + (number / temp)) / 2;
    } while ((temp - sr) != 0);

    return sr;
  }

  /**
   * This Method calculates inverse cosine of x.
   * 
   * @param x This is the input value to calculate inverse cosine
   * @return double This returns inverse cosine of x.
   */

  public static double arccos(double x) {
    boolean negative = x < 0;
    if (negative) {
      x = -x;
    }
    if (!(x <= 1)) {
      return -1;
    }
    if (x == 1) {
      return negative ? Utility.PI : 0;
    }
    if (x < 0.5) {
      if (x < 1 / Utility.TWO_57) {
        return Utility.PI / 2;
      }
      double z = x * x;
      double p = z * (Utility.PS0 + z
          * (Utility.P1 + z * (Utility.P2 + z * (Utility.P3 + z * (Utility.P4 + z * Utility.P5)))));
      double q = 1 + z * (Utility.Q1 + z * (Utility.Q2 + z * (Utility.Q3 + z * Utility.Q4)));
      double r = x - (Utility.PI_L / 2 - x * (p / q));
      return negative ? ((Utility.PI) / 2 + r) : (Utility.PI / 2 - r);
    }
    if (negative) {
      double z = (1 + x) * 0.5;
      double p = z * (Utility.PS0 + z
          * (Utility.P1 + z * (Utility.P2 + z * (Utility.P3 + z * (Utility.P4 + z * Utility.P5)))));
      double q = 1 + z * (Utility.Q1 + z * (Utility.Q2 + z * (Utility.Q3 + z * Utility.Q4)));
      double s = findSquareRoot(z);
      double w = p / q * s - Utility.PI_L / 2;
      return Utility.PI - 2 * (s + w);
    }
    double z = (1 - x) * 0.5; // x>0.5.
    double s = findSquareRoot(z);
    double df = (float) s;
    double c = (z - df * df) / (s + df);
    double p = z * (Utility.PS0 + z
        * (Utility.P1 + z * (Utility.P2 + z * (Utility.P3 + z * (Utility.P4 + z * Utility.P5)))));
    double q = 1 + z * (Utility.Q1 + z * (Utility.Q2 + z * (Utility.Q3 + z * Utility.Q4)));
    double w = p / q * s + c;
    return 2 * (df + w);
  }

  /**
   * This is the main method which makes use of arccos method.
   * 
   * @param args unused.
   */

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("ETERNITY: FUNCTIONS - arccos(x)");
    System.out.println("");
    System.out.println("Please enter the value of x: ");
    double x = input.nextDouble();
    double res = arccos(x);
    if (res == -1) {
      System.out.println("Invalid Input, please provide input of x");
    } else {
      System.out.println("Select below option to display result in");
      System.out.println("1. Radian");
      System.out.println("2. Degree");
      System.out.println("");
      int option = Integer.parseInt(input.next());
      switch (option) {
        case 1:
          System.out.println("Result of arrcos(" + x + ") is " + res + "rad");
          break;

        case 2:
          res = res * (180 / Utility.PI);
          System.out.println("Result of arrcos(" + x + ") is " + res + "�");
          break;
        default:
          break;
      }
    }

    input.close();

  }

}
