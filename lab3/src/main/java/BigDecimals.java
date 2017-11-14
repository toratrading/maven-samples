import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by sebi on 10/31/2017.
 */
public class BigDecimals {

    private static String file = "./results2.txt";


    private static List<BigDecimal> generateBigDecimalList(int size){
        List<BigDecimal> list = new LinkedList<>();

        Random random = new Random();

        for (int i = 0; i < size; i++){
            int nr = random.nextInt();
            if (nr < 0){
                nr = -nr;
            }

            list.add(new BigDecimal(nr + "." + nr % 100));
        }

        return list;
    }

    public static void main(String[] args) {

        List<BigDecimal> bigDecimals = generateBigDecimalList(100000);

        BigDecSerializer.serializeBigDecimals(bigDecimals, file);

        List<BigDecimal> deserialized = BigDecSerializer.deserializeBigDecimals(file);

        System.out.println("Top 10 deserialized big decimals: ");
        deserialized.stream().limit(10).forEach(System.out::println);
    }

}
