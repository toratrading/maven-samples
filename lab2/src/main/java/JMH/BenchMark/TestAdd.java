package JMH.BenchMark;

import JMH.repository.Order;
import JMH.states.RepoState;
import JMH.states.SizeState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by sebi on 10/31/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 20, time = 1)
@Fork(2)
public class TestAdd {

    @State(Scope.Benchmark)
    public static class BeforeState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {repoState.orders.remove(order);}
    }

    @Benchmark
    public boolean add_before(RepoState repoState, BeforeState before) {
        return repoState.orders.add(before.order);
    }

    @Benchmark
    public boolean add_existing(RepoState repoState, ExistingState existing) {return repoState.orders.add(existing.order);}

    @Benchmark
    public boolean add_after(RepoState repoState, AfterState after) {return repoState.orders.add(after.order);}

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

    //java -jar target/benchmarks.jar

//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(TestAdd.class.getSimpleName()+".*")
//                .build();
//
//        new Runner(opt).run();
//    }
}
