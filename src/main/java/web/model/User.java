package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String hobby;

    @Column
    private int age;

    public User() {
    }

    public User(String name, String surname, String hobby, int age) {
        this.name = name;
        this.surname = surname;
        this.hobby = hobby;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User[ " + "id: " + id + " | name: " + name + " | surname: " + surname +
                 " | hobby: " + hobby + " | age: " + age + " ]";
    }



}