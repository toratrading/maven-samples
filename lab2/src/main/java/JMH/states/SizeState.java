package JMH.states;

import JMH.repository.Order;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * Created by sebi on 10/30/2017.
 */
@State(Scope.Benchmark)
public class SizeState {
    @Param({"1000", "10000"})
    public int size;

    public Supplier<Order> existing = new Supplier<Order>() {
        private final Random random = new Random();

        @Override
        public Order get() {
            return new Order(random.nextInt(size));
        }
    };

    public Supplier<Order> before = new Supplier<Order>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);
        @Override
        public Order get() {
            return new Order(currentSize.decrementAndGet());
        }
    };

    public Supplier<Order> after = new Supplier<Order>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);
        @Override
        public Order get() {
            return new Order(currentSize.incrementAndGet());
        }
    };
}
