package com.company.model.dao.impl;

import com.company.model.dao.DAOFactory;
import com.company.model.dao.NoteBookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDAOFactory extends DAOFactory {
    @Override
    public NoteBookDAO createNoteBookDAO() {
        return new JDBCNoteBookDAO(getConnection());
    }
    private Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/reg_form",
                    "root",
                    "root");
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
