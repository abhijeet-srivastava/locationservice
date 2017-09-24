package com.cvent.locationservice.resources;

import com.cvent.locationservice.core.Person;
import com.cvent.locationservice.dao.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.cvent.locationservice.LocationServiceConstants.LOCATIONSERVICE_RESOURCE;
import static com.cvent.locationservice.LocationServiceConstants.SERVICE_ROOT;
import static com.cvent.locationservice.LocationServiceConstants.VERSION_URI;

//import com.cvent.locationservice.model.Entity;
//import javax.validation.constraints.NotNull;
/*import com.sun.net.httpserver.HttpContext;
import org.eclipse.jetty.http.HttpStatus;*/

/**
 * A resource containing specific endpoints to access the service.
 */
@Path(SERVICE_ROOT + VERSION_URI + LOCATIONSERVICE_RESOURCE)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationServiceResource {

    private static final Logger LOG = LoggerFactory.getLogger(LocationServiceResource.class);
    
    private final PersonDAO personDAO;

    public LocationServiceResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GET
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") Integer id) {
        return personDAO.findById(id);
    }

    @POST
    public Person add(@Valid Person person) {
        personDAO.insert(person);

        return person;
    }

    @PUT
    @Path("/{id}")
    public Person update(@PathParam("id") Integer id, @Valid Person person) {
        Person updatePerson = new Person(id, person.getName());

        personDAO.update(updatePerson);

        return updatePerson;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        personDAO.deleteById(id);
    }

    /**
     * Get Operation
     *
     * @param uriInfo
     * @return String
     */
   /* @GET
    @Timed
    @ExceptionMetered
    public Response getEntity(@Context UriInfo uriInfo) {

        LOG.info("getEntity() request.");

        return Response.ok(ImmutableEntity.builder()
                .field("foo")
                .anotherField("another")
                .complexEntity(ImmutableComplexEntity.of(1))
                .build()
        ).build();
    }*/

    /**
     * Post Operation
     *
     * @param uriInfo
     * @param context
     * @param incomingEntity
     * @return Response
     */
    /*@POST
    @Timed
    @ExceptionMetered
    public Response createEntity(
            @Context UriInfo uriInfo,
            @Context HttpContext context,
            @Valid @NotNull Entity incomingEntity) {

        LOG.info("createEntity() request.");

        return Response.status(HttpStatus.CREATED_201).build();
    }*/
}
