package Calculator.Operations;

import java.util.List;

/**
 * Created by sebi on 10/5/2017.
 */
public interface IOperation  {
    double compute(List<Double> elements) throws CalcException;
}
