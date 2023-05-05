package org.example;

import org.example.MusicEntity;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T extends MusicEntity> {
    void create(T item) throws SQLException;

    List<T> findAll() throws SQLException;

    T findByName(String name) throws SQLException;

    T findById(int id) throws SQLException;
}