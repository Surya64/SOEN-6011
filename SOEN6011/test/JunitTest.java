import static org.junit.Assert.assertEquals;

import org.junit.Test;
import sep.Project;

public class JunitTest {

  @Test
  public void squarerootTest() {
    double value = Project.findSquareRoot(16);
    assertEquals(4.0, value, 0);
  }

  @Test
  public void arccosTest() {
    double x = Project.arccos(1);
    double y = Project.arccos(-1);
    System.out.println(y);
    assertEquals(0.0, x, 0);
    assertEquals(3.141592653589793, y, 0);

  }

}
