package JMH.repository;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sebi on 10/17/2017.
 */
public class TreeSetBasedRepository<T> implements InMemoryRepository<T> {

    private Set<T> repo;

    public TreeSetBasedRepository() {
        this.repo = new TreeSet<T>();
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
