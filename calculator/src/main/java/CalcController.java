import Operations.*;

import java.util.List;

/**
 * Created by sebi on 10/5/2017.
 */
public class CalcController {
    public Double calculate(List<?> elements, OperationType operation) throws CalcException {
        if (validArguments(elements)) {
            List<Double> elementsList = (List<Double>)(List<?>) elements;
            switch (operation) {
                case ADD:
                    Addition addition = new Addition();
                    return addition.compute(elementsList);
                case DIVIDE:
                    Division division = new Division();
                    return division.compute(elementsList);
                case MULTIPLY:
                    Multiply multiply = new Multiply();
                    return multiply.compute(elementsList);
                case SUBSTRACT:
                    Substraction substraction = new Substraction();
                    return substraction.compute(elementsList);
                case SQUARE_ROOT:
                    SquareRoot squareRoot = new SquareRoot();
                    return squareRoot.compute(elementsList);
                case MAX:
                    Maximum maximum = new Maximum();
                    return maximum.compute(elementsList);
                case MIN:
                    Minim minim = new Minim();
                    return minim.compute(elementsList);
                default:
                    throw new CalcException("invalid operation!");
            }
        }else {
            throw new CalcException("invalid arguments");
        }
    }

    private boolean validArguments(List<?> objectsList){
        for (Object o: objectsList) {
            if (!(o instanceof Double)) {
                return false;
            }
        }
        return true;
    }
}
