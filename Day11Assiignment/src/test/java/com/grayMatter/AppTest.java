package com.grayMatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class AppTest 
{
	App app = new App();
    @Test
    public void testGetAllPersonInfo() throws ClassNotFoundException, SQLException	{
        List<Person> actualList = app.getAllPersonsInfo();
        assertNotNull(actualList);DataSourceClass dc = new DataSourceClass();
        assertTrue("Person Data retrived", actualList.size() > 0);
    }


    @Test
    public void testGetPersonById() throws SQLException, ClassNotFoundException {
    	Connection con = DataSourceClass.getConnection();
        Person person = app.getPerson(3);
        assertNotNull(person);
        assertEquals(3, person.getId());
        assertEquals("Jim Brown", person.getName());
    }

    @Test
    public void testAddPerson() throws SQLException, ClassNotFoundException {
        Person person = new Person(101, "usera", 22, "1234567890", "usera@gmail.com");
        Person addedPerson = app.addPerson(person);
        assertEquals(person.getName(), addedPerson.getName());
    }

    @Test
    public void testUpdatePerson() throws SQLException, ClassNotFoundException {
        Person person = new Person(102, "userb", 24, "2345678901", "userb@gmail.com");
        Person updatedPerson = app.updatePerson(person, 1);
        assertNotNull(updatedPerson);
        assertEquals(person.getName(), updatedPerson.getName());
    }

    @Test
    public void testDeletePerson() throws SQLException, ClassNotFoundException {
        Person person = app.deletePerson(100);
        assertEquals(100, person.getId());
    }
    
    
}
