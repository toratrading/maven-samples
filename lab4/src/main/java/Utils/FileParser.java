package Utils;


/**
 * Created by sebi on 11/14/2017.
 */
public class FileParser {
    private static String regex_name = "([a-zA-Z])+";
    private static String regex_cnp = "(?<id>[1-8])(?<year>[7890][1-9])(?<month>([0][0-9])|[12])(?<day>([0-2][1-9])|(3[01]))(?<county>(01)|([1-4][0-9])|(5[0-2]))(?<NNN>\\d{3})(?<control>\\d{1})";
    private static String regex_email = "(.+@[^\\.].*\\.[a-z]{2,}$)";

//
//    private static void readContent(){
//        try (Stream<String> lines = Files.lines(Utils.Globals.input_file.toPath())) {
//            lines.forEach(s -> System.out.println(s));
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }


    public static Person parseRawPerson(String raw_person){

        String[] fields = raw_person.split("~");

        if (!fields[0].matches(regex_name)){
            System.out.println("Invalid name1 " + fields[0]);
            return null;
        }
        if (!fields[1].matches(regex_name)){
            System.out.println("Invalid name2 " + fields[1]);
            return null;
        }
        if (!fields[2].matches(regex_name)){
            System.out.println("Invalid name3 " + fields[2]);
            return null;
        }
        if (!fields[3].matches(regex_cnp)){
            System.out.println("Invalid cnp " + fields[3]);
            return null;
        }

        if (!fields[4].matches(regex_email)){
            System.out.println("Invalid email " + fields[4]);
            return null;
        }

        return new Person(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }
}

