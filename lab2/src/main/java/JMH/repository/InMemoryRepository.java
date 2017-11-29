package JMH.repository;

/**
 * Created by sebi on 3/8/2017.
 */
public interface InMemoryRepository<T> {
    void clear();
    boolean add(T entity);
    boolean remove(T entity);
    boolean contains(T entity);
}