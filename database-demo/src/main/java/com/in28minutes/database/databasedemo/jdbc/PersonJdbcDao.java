package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getDate("birth_date")
            );
        }
    }

    private BeanPropertyRowMapper<Person> createPersonRowMapper() {
        return new BeanPropertyRowMapper<Person>(Person.class);
    }

    public Collection<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM Person", createPersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id = ?", new PersonRowMapper(), new Object[]{id});
    }

    public Collection<Person> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE name = ?", createPersonRowMapper(), new Object[]{name});
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update("INSERT INTO Person(id, name, location, birth_date) " +
                "VALUES (?,?,?,?)", person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public Object updateNameById(int id, String name) {
        return jdbcTemplate.update("UPDATE Person SET name = ? WHERE id = ?", new Object[]{name, id});
    }

    public int update(Person person) {
        return jdbcTemplate.update("UPDATE Person SET name = ?, location = ?, birth_date = ?  WHERE id = ?",
                person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
    }
}
