package com.company.model.entity;

/**
 * Created by student on 04.10.2017.
 */
public class NoteBook {
    private Long id;
    private String firstName;
    private String loginData;

    public NoteBook() {
    }

    public NoteBook(String firstName, String loginData)
                            throws NotUniqueLoginException{
        this.firstName = firstName;
        this.loginData = loginData;
    }

    public NoteBook(Long id, String firstName, String loginData) {
        this.id = id;
        this.firstName = firstName;
        this.loginData = loginData;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLoginData() {
        return loginData;
    }
    public void setLoginData(String loginData) {
        this.loginData = loginData;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", loginData='" + loginData + '\'' +
                '}';
    }
}
