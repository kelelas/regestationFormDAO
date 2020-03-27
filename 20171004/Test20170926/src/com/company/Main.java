package com.company;

import com.company.controller.Controller;
import com.company.model.Model;
import com.company.model.dao.DAOFactory;
import com.company.model.dao.NoteBookDAO;
import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;
import com.company.view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getInstance();
        NoteBookDAO dao = factory.createNoteBookDAO();

        System.out.println(dao.findById((long) 1));

        System.out.println(dao.findAll());

        try {
            dao.create(new NoteBook("Max", "Max@gmail.com"));
        } catch (NotUniqueLoginException e) {
            e.printStackTrace();
        }

        List<NoteBook> noteBookList = dao.findAll();
        for (NoteBook noteBook : noteBookList)
            System.out.println(noteBook);

        dao.update(new NoteBook((long) 1, "Bob", "Bob@gmail.com"));
        System.out.println(dao.findById((long) 1));

        dao.delete((long) 1);

    }
}
