import static org.junit.Assert.assertEquals;

import org.junit.Test;
import sep.Project;

public class JunitTest {
  /**
   * Method to test square root function.
   */
  @Test
  public void squarerootTest() {
    double value = Project.findSquareRoot(16);
    assertEquals(4.0, value, 0);
  }

  /**
   * Method to test the actual values of x.
   */
  @Test
  public void arccosTest() {
    double x = Project.arccos(1);
    double y = Project.arccos(-1);
    assertEquals(0.0, x, 0);
    assertEquals(3.141592653589793, y, 0);

  }

  /**
   * Method to test the invalid value of x.
   */

  @Test
  public void arccosInvalidTest() {
    double x = Project.arccos(3);
    System.out.println(x);
    assertEquals(-1.0, x, 0);
  }

}
