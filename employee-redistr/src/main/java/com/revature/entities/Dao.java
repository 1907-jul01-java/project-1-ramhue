package com.revature.entities;

import java.util.List;

/**
 * Dao
 */
public interface Dao<E> {
    void insert(E e);

    List<E> getAll();

    void update(int id, String status);

    void delete();
    List<E> getByEmployee(String e);
}