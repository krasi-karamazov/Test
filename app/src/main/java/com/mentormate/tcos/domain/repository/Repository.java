package com.mentormate.tcos.domain.repository;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

/**
 * A sample repository with CRUD operations on a model.
 */

public interface Repository<T> {
    boolean insert(T model);

    boolean update(T model);

    T get(long id);

    boolean delete(T model);
}
