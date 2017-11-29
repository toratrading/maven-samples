import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by sebi on 10/31/2017.
 */
public class TestBigDecimals {

    private List<BigDecimal> getBigDecimalsList(){
        List<BigDecimal> list = new ArrayList<>();
//        list.add(new BigDecimal(10.333));
//        list.add(new BigDecimal(13.43));
//        list.add(new BigDecimal(50.333));
//        list.add(new BigDecimal(14.333));
//        list.add(new BigDecimal(14.333));
//        list.add(new BigDecimal(184.356));
//        list.add(new BigDecimal(824.36));
//        list.add(new BigDecimal(84.356));
//        list.add(new BigDecimal(145.873));
//        list.add(new BigDecimal(15.333));

        Random r = new Random();

        for(int i=0;i<100;i++){
            list.add(new BigDecimal(i+ r.nextDouble()*101.101));
        }

        return list;
    }

    private BigDecimal getSum(List<BigDecimal> lista){
        BigDecimal result = new BigDecimal(0);
        for (BigDecimal b : lista) {
            result = result.add(b);
        }
        return result;
    }

    @Test
    public void SumElements(){
        List<BigDecimal> list= getBigDecimalsList();
        BigDecimal rslt1 = getSum(list);

//        List<BigDecimal> list2 = Arrays.asList(new BigDecimal(10.333), new BigDecimal(14.333));
        Optional<BigDecimal> result2 = list.stream().reduce(BigDecimal::add);

        if(result2.isPresent())
            assert (rslt1.equals(result2.get()));
    }

    @Test
    public void AverageBigDecimals(){
        List<BigDecimal> list= getBigDecimalsList();

        BigDecimal sum1 = getSum(list);
        BigDecimal result1 = sum1.divide(new BigDecimal(list.size()), BigDecimal.ROUND_CEILING);

        BigDecimal sum2 = list.stream()
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal result2 = sum2.divide(new BigDecimal(list.size()), BigDecimal.ROUND_CEILING);

        assertEquals(result1, result2);

    }

    @Test
    public void TopTenPercentDecimals(){
        List<BigDecimal> lista = getBigDecimalsList();

        lista.stream()
                .sorted(Comparator.reverseOrder())
                .limit((long)(0.1 * lista.size()))
                .forEach(System.out::println);

    }
}
