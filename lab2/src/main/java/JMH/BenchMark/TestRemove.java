package JMH.BenchMark;

import JMH.repository.Order;
import JMH.states.RepoState;
import JMH.states.SizeState;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by sebi on 10/31/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 20, time = 1)
@Fork(2)
public class TestRemove {

    @State(Scope.Benchmark)
    public static class AfterStateRemove {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }
    }

    /*
    Generates random orders that are in repo
    reinserts them afterwards
     */
    @State(Scope.Benchmark)
    public static class ExistingStateRemove {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepoState repositoryState){
            repositoryState.orders.add(order);
        }
    }

    @Benchmark
    public void removeExisting(RepoState repositoryState, ExistingStateRemove existingState){repositoryState.orders.remove(existingState.order);}

    @Benchmark
    public void removeAfter(RepoState repositoryState, AfterStateRemove newState){repositoryState.orders.remove(newState.order);}
}


/// // TODO: 10/31/2017 make new repo pt primitive 