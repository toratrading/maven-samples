package JMH.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebi on 10/17/2017.
 */
public class ArrayListBasedRepository<T> implements InMemoryRepository<T> {

    private List<T> repo;

    public ArrayListBasedRepository() {
        this.repo = new ArrayList<>();
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
