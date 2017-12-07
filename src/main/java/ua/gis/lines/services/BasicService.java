package ua.gis.lines.services;

import java.io.Serializable;
import java.util.List;

/**
 * Basic interface of all services
 *
 * @param <T> generic for entities extends {@link Object}
 * @author Boiko Ivan
 */
public interface BasicService<T extends Serializable> {

    /**
     * Method searches entity with given id in repository
     *
     * @param id {@code long} id of entity to search
     * @return entity from repository
     */
    T getById(int id);

    /**
     * Method searches all entities in repository
     *
     * @return {@link List} of all entities
     */
    List<T> getAll();

    /**
     * Method saves entity to repository
     *
     * @param value entity to save
     */
    void save(T value);

    /**
     * Method updates entity in repository
     *
     * @param value entity to update
     */
    void update(T value);

    /**
     * Method deletes entity from repository
     *
     * @param value entity to delete
     */
    void delete(T value);

    /**
     * Method deletes entity with given id
     *
     * @param id id of entity to remove
     */
    void deleteById(int id);

    /**
     * Method checks if repository is empty
     *
     * @return true if repository is empty
     */
    boolean isEmpty();
}
