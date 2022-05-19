package ru.webapp.service;

import java.util.List;

public interface WebService<T> {

    public Iterable<T> getAll();
    public T getById(Long id);
    public void delete(Long id);
    public List<T> getByName(String name);
    public void add(T entity);
}
