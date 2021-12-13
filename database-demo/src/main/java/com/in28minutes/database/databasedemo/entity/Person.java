package com.in28minutes.database.databasedemo.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_person",query = "SELECT p FROM Person p"),
        @NamedQuery(name = "find_by_name",query = "SELECT p FROM Person p WHERE p.name = :name")
})
public class Person {

    @Id
    @GeneratedValue()
    private int id;

    private String name;
    private String location;
    private Date birthDate;

    public Person(){}

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public int getId() { return id; }
    public String getName() { return name; }

    public String getLocation() { return location; }

    public Date getBirthDate() { return birthDate; }

    @Override
    public String toString() { return "Person{ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
