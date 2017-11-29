package Utils;

import java.io.File;

public class Globals {
    private static ClassLoader classLoader;
    private static File input_file, output_file;

    public Globals() {
        classLoader = Thread.currentThread().getContextClassLoader();
        input_file = new File(classLoader.getResource("input4.txt").getFile());
        output_file = new File(classLoader.getResource("output4.txt").getFile());
    }

    public File getInputFile(){
        return input_file;
    }

    public File getOutputFile(){
        return output_file;
    }
}
