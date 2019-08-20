package com.revature.domain;

import java.util.List;

/**
 * Service
 */
public interface Service<E> {
    void insert(E e);

    List<E> getAll();

    void update(int i, String s);

    void delete();
}