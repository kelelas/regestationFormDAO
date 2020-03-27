package com.company.model.dao;

import com.company.model.entity.NoteBook;

import java.util.List;

public interface NoteBookDAO extends AutoCloseable  {
    void create(NoteBook noteBook);
    NoteBook findById(Long id);
    List<NoteBook> findAll();
    void update(NoteBook noteBook);
    void delete(Long id);
}
