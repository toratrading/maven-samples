import Utils.FileParser;
import Utils.Globals;
import Utils.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.*;

public class PoolThreadRecoverCorruptedData {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Globals globals = new Globals();
        String inputText =new String(Files.readAllBytes(globals.getInputFile().toPath()));

        final ExecutorService executorService = Executors.newFixedThreadPool(100);
        final BlockingQueue<Person> entries = new LinkedBlockingQueue<>();

        Person poisonPill = new Person();

        //producer
        executorService.submit(() -> {
            for (String personText : inputText.split("%")) {
                Person person = FileParser.parseRawPerson(personText);
                if(person!=null) {
                    System.out.println("->> producing in... " + Thread.currentThread().getName() + "  ::  " + person.toString());
                    entries.add(person);
                }
            }
            entries.add(poisonPill);
        });

        //consumer
        executorService.submit(() -> {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(globals.getOutputFile().getAbsolutePath())))) {
                while (true) {
                    Person person = entries.take();
                    if(person == poisonPill)
                        break;

                    if(person!=null) {
                        bufferedWriter.write(person.toString());
                        System.out.println("->> consuming in... " + Thread.currentThread().getName() + "  ::  " + person.toString());
                        bufferedWriter.write(person.toString());
                    }
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
