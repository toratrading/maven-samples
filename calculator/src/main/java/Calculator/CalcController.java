package Calculator;

import Calculator.Operations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Calculator.Operations.OperationType.*;

/**
 * Created by sebi on 10/5/2017.
 */
public class CalcController {

    private Map<OperationType, IOperation> operationMap;

    public CalcController(){
        operationMap = new HashMap<>();
        operationMap.put(OperationType.ADD, new Addition());
        operationMap.put(OperationType.SUBSTRACT, new Substraction());
        operationMap.put(OperationType.DIVIDE, new Division());
        operationMap.put(OperationType.MULTIPLY, new Multiply());
        operationMap.put(OperationType.MIN, new Minim());
        operationMap.put(OperationType.MAX, new Maximum());
        operationMap.put(OperationType.SQUARE_ROOT, new SquareRoot());
    }

    public Double calculate(List<?> elements, OperationType operation) throws CalcException {
        if (validArguments(elements)) {
            List<Double> elementsList = (List<Double>)(List<?>) elements;

            return operationMap.get(operation).compute(elementsList);
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
