import Calculator.CalcController;
import Calculator.Operations.OperationType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.primitives.Doubles.asList;
import static org.junit.Assert.*;

/**
 * Created by sebi on 10/10/2017.
 */
public class CalcControllerTest {

    CalcController calcController = new CalcController();
    @Test
    public void addTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(12.0,10.0));
        Double res = calcController.calculate(elements, OperationType.ADD);
        assertTrue(res == 22.0);
    }
    @Test
    public void subTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(12.0,10.0));
        Double res = calcController.calculate(elements, OperationType.SUBSTRACT);
        assertTrue(res == 2.0);
    }
    @Test
    public void multiplyTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(12.0,10.0));
        Double res = calcController.calculate(elements, OperationType.MULTIPLY);
        assertTrue(res == 120.0);
    }
    @Test
    public void divisionTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(12.0,10.0));
        Double res = calcController.calculate(elements, OperationType.DIVIDE);
        assertTrue(res == 1.2);
    }
    @Test
    public void minTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(12.0,10.0));
        Double res = calcController.calculate(elements, OperationType.MIN);
        assertTrue(res == 10.0);
    }
    @Test
    public void maxTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(12.0,10.0));
        Double res = calcController.calculate(elements, OperationType.MAX);
        assertTrue(res == 12.0);
    }
    @Test
    public void squareRootTest() throws Exception {
        List<Object> elements = new ArrayList<Object>(asList(16.0));
        Double res = calcController.calculate(elements, OperationType.SQUARE_ROOT);
        assertTrue(res == 4.0);
    }
}

//matchers & assertThat
//eclpse collections