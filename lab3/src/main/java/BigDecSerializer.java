import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sebi on 11/14/2017.
 */
public class BigDecSerializer {
    private static int no_elements;

    public static void serializeBigDecimals(List<BigDecimal> bigDecimals, String file) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {

            for (BigDecimal bigDecimal : bigDecimals) {
                outputStream.writeObject(bigDecimal);
                no_elements += 1;
            }
            System.out.println("serialized:" + no_elements + " big decimals");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BigDecimal> deserializeBigDecimals(String file) {
        List<BigDecimal> bigDecimals = new LinkedList<>();

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {

            while (no_elements > 0) {
                bigDecimals.add((BigDecimal) inputStream.readObject());
                no_elements -= 1;
            }
            System.out.println("deserialized the big decimals from file " + file);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bigDecimals;
    }
}