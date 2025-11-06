package org.docencia.hotel.persistence.jpa.interfaces;

import java.util.List;

public interface CrudInterface<T, ID> {
    public boolean exists(ID id);
    public T findById(ID id);
    public List<T> findAll();
    public T save(T entity);
    public boolean delete(ID id);
}
