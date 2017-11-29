package Calculator.Operations;

import java.util.List;

/**
 * Created by sebi on 10/10/2017.
 */
public class SquareRoot implements IOperation {
    @Override
    public double compute(List<Double> elements) throws CalcException {
        if(elements.size()==1){
            return Math.sqrt(elements.get(0));
        }else {
            throw new CalcException("invalid no arguments at square root!");
        }
    }
}
