package ua.gis.lines.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.services.BasicService;

import java.io.Serializable;
import java.util.List;

/**
 * Abstract service for managing entities in repositories
 *
 * @param <T> generic for entities
 * @author Boiko Ivan
 * @see BasicService
 */
public abstract class AbstractBasicServiceImpl<T extends Serializable> implements BasicService<T> {

    private final JpaRepository<T, Integer> dao;

    @Autowired
    public AbstractBasicServiceImpl(JpaRepository<T, Integer> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public T getById(int id) {
        return dao.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public void save(T value) {
        dao.save(value);
    }

    @Override
    @Transactional
    public void update(T value) {
        dao.save(value);
    }

    @Override
    @Transactional
    public void delete(T value) {
        dao.delete(value);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public boolean isEmpty() {
        return dao.count() == 0;
    }
}
