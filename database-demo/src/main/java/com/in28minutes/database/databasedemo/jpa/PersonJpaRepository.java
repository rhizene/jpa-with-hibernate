package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Person;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager em;

    public List<Person> findAll() {
        return em.createNamedQuery("find_all_person", Person.class).getResultList();
    }

    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    public Person save(Person person) {
        return em.merge(person);
    }

    public Person deleteById(int id) {
        Person person = findById(id);
        em.remove(person);
        return person;
    }

    public Collection<Person> findByName(String name) {
        return em.createNamedQuery("find_by_name", Person.class)
                .setParameter("name", name)
                .getResultList();
    }
}
