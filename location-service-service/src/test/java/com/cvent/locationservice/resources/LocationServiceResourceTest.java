package com.cvent.locationservice.resources;

import com.cvent.locationservice.core.Person;
import com.cvent.locationservice.core.PersonTests;
import com.cvent.locationservice.dao.PersonDAO;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

//import com.sun.net.httpserver.HttpContext;
//import org.junit.Before;
//import com.sun.jersey.api.core.HttpContext;

/**
 * Unit tests for the LocationServiceService
 */
public class LocationServiceResourceTest {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LocationServiceResourceTest.class);
    private LocationServiceResource serviceResource;


    private static final PersonDAO PERSON_DAO = mock(PersonDAO.class);

    static {
        Logger.getLogger("com.sun.jersey").setLevel(Level.OFF);
    }

    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule.builder()
            .addResource(new LocationServiceResource(PERSON_DAO))
            .build();

    @Test
    public void getAll() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "person1"));
        persons.add(new Person(2, "person2"));
        when(PERSON_DAO.getAll()).thenReturn(persons);

        List<Person> result = RESOURCES.client().target("/person").request().get(new GenericType<List<Person>>() {
            
        });

        assertEquals(2, result.size());
        assertEquals("person1", result.get(0).getName());
    }

    @Test
    public void get() throws Exception {
        when(PERSON_DAO.findById(1)).thenReturn(
                new Person(1, "person1")
        );

        Person person = RESOURCES.client().target("/person/1").request().get(new GenericType<Person>() {
            
        });

        assertEquals("person1", person.getName());
    }

    @Test
    public void update() throws Exception {
        Person person = PersonTests.getPerson();

        Person updatedPerson = RESOURCES.client().target("/person/10")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(person), Person.class);

        assertEquals(person.getId(), updatedPerson.getId());
        assertEquals(person.getName(), updatedPerson.getName());
        verify(PERSON_DAO, times(1)).update(person);
    }

    @Test
    public void update_invalid_person() throws Exception {
        Person person = new Person(10, null);

        try {
            Person updatedPerson = RESOURCES.client().target("/person/10")
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.json(person), Person.class);
            fail("Should have thrown validation error");
        } catch (ClientErrorException ex) {
            LOGGER.error("Error ", ex);
        }
    }

    @Test()
    public void add() throws Exception {
        Person newPerson = PersonTests.getPerson();

        Person person = RESOURCES.client().target("/person")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newPerson), Person.class);

        assertEquals(newPerson.getName(), person.getName());
        verify(PERSON_DAO, times(1)).insert(any(Person.class));
    }

    @Test
    public void add_invalid_person() throws Exception {
        Person newPerson = new Person(10, null);

        try {
            Person person = RESOURCES.client().target("/person")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(newPerson), Person.class);
            fail("Should have thrown validation error");
        } catch (ClientErrorException ex) {
            LOGGER.error("Error ", ex);
        }
    }

    @Test()
    public void delete() throws Exception {
        RESOURCES.client().target("/person/1").request().delete();
        verify(PERSON_DAO, times(1)).deleteById(1);
    }
    
   /* @Test
    public void getEntity() {
        UriInfo uriInfo = null;
        Response response = serviceResource.getEntity(uriInfo);
        assertNotNull(response);
    }*/

    /*@Test
    public void createEntity() {
        UriInfo uriInfo = null;
        HttpContext context = null;
        com.cvent.locationservice.model.Entity incomingEntity = null;
        Response response = serviceResource.createEntity(uriInfo, context, incomingEntity);
        assertNotNull(response);
    }*/

}
