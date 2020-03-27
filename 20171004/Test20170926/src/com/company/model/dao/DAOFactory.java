package com.company.model.dao;

import com.company.model.dao.impl.JDBCDAOFactory;

public abstract  class DAOFactory {
    private static DAOFactory daoFactory;
    public abstract NoteBookDAO createNoteBookDAO();

    public static DAOFactory getInstance(){
        if (daoFactory ==null){
            synchronized (DAOFactory.class){
                if (daoFactory == null){
                    daoFactory = new JDBCDAOFactory();
                }
            }
        }
        return daoFactory;
    }
}
