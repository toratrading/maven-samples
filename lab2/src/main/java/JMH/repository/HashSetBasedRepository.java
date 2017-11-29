package JMH.repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sebi on 10/17/2017.
 */
public class HashSetBasedRepository<T> implements InMemoryRepository<T> {

    private Set<T> repo;

    public HashSetBasedRepository() {
        this.repo = new HashSet<T>();
    }

    @Override
    public void clear() {
        repo.clear();
    }

    @Override
    public boolean add(T entity) {
        return repo.add(entity);
    }

    @Override
    public boolean remove(T entity) {
        return repo.remove(entity);
    }

    @Override
    public boolean contains(T entity) {
        return repo.contains(entity);
    }
}
