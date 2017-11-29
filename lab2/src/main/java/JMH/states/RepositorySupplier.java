package JMH.states;

import JMH.repository.CollectionRepository;
import JMH.repository.InMemoryRepository;
import JMH.repository.Order;
import com.koloboke.collect.map.FloatFloatMap;
import com.koloboke.collect.map.hash.HashObjObjMaps;
import org.eclipse.collections.impl.factory.Sets;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import static com.koloboke.collect.map.hash.HashDoubleObjMaps.newUpdatableMap;

/**
 * Created by sebi on 10/30/2017.
 */
public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
//    HASH_SET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(HashSet::new);
//        }
//    },
//
//
//    TREE_SET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(TreeSet::new);
//        }
//    },
//
//    ARRAY_LIST() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(ArrayList::new);
//        }
//    },
//
//    LINKED_LIST() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(LinkedList::new);
//        }
//    },
//
//    CONCURRENT_HASH_MAP() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(() -> Collections.newSetFromMap(new ConcurrentHashMap<Order, Boolean>()));
//        }
//    },
    ECLISPE_MUTABLE_SET(){
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(Sets.mutable::empty);
        }
    },

    KOLOBOKE_HASH_MAP(){
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(() -> Collections.newSetFromMap(HashObjObjMaps.newMutableMap()));
        }
    }
}