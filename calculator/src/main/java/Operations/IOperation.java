package Operations;

import java.util.List;

/**
 * Created by sebi on 10/5/2017.
 */
interface IOperation  {
    double compute(List<Double> elements) throws CalcException;
}
