package JMH.BenchMark;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/**
 * Created by sebi on 10/31/2017.
 */
 /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar JMHSample_26 -f 1
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

public class BenchmarksRunner {
    public static void main(String[] args) throws Exception{
        Options options = new OptionsBuilder()
                .include(TestAdd.class.getSimpleName()+".*")
                .shouldFailOnError(true)
                .timeout(TimeValue.minutes(30))
                .resultFormat(ResultFormatType.CSV)
                .build();
        new Runner(options).run();
    }
}
