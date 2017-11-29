package JMH.BenchMark;

import JMH.repository.ArrayListBasedRepository;
import JMH.repository.InMemoryRepository;
import JMH.repository.Order;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by sebi on 10/17/2017.
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class RepoBenchmark {
    @Param({"1", "31", "65", "101", "103", "1024", "10240", "65535", "21474836"})
    public int size;


    @Benchmark
    public void add(Blackhole consumer) {
        InMemoryRepository<Order> repo = new ArrayListBasedRepository<>();
        for(int i=0; i< size; i++){
            repo.add(new Order(1,2,3));
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RepoBenchmark.class.getSimpleName())
//                .addProfiler(HotspotMemoryProfiler.class)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
