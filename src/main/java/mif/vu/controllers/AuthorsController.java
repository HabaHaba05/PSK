package mif.vu.controllers;

import mif.vu.configurations.cdi.CheckRequestInterceptor;
import mif.vu.dtos.CreateAuthorDto;
import mif.vu.dtos.UpdateAuthorDto;
import mif.vu.entities.Author;
import mif.vu.mappers.AuthorMappers;
import mif.vu.persistance.DAO.AuthorsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorsController {
    @Inject
    AuthorsDAO authorsDAO;

    @Inject
    AuthorMappers authorMappers;

    @GET
    @Path("/{id}")
    @CheckRequestInterceptor(role = "USER")
    public Author getById(@PathParam("id") Integer id) {
        return authorsDAO.findById(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Author create(CreateAuthorDto dto) {
        Author author = authorMappers.CreateAuthorDtoToAuthor(dto);
        authorsDAO.create(author);
        return author;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Integer id) {
        try{
            authorsDAO.remove(id);
            return Response.ok().build();
        }catch(Exception ex) {
            return Response.noContent().build();
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(UpdateAuthorDto dto) throws InterruptedException {

        try{
            authorsDAO.update(dto);
            return Response.ok().build();
        }catch (OptimisticLockException ex){
            System.out.println(ex);
            return Response.status(Response.Status.CONFLICT).build();
            // Uncomment to retry update method
            //try{
            //    authorsDAO.update(dto);
            //    return Response.ok().build();
            //}catch (OptimisticLockException ex2){
            //    return Response.status(Response.Status.CONFLICT).build();
            //}
        }
        catch (Exception ex){
            System.out.println(ex);
            return Response.noContent().build();
        }
    }
    @PUT
    @Path("/update2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update2(UpdateAuthorDto dto) {
        try{
            authorsDAO.update2(dto);
            return Response.ok().build();
        }
        catch (Exception ex){
            System.out.println(ex);
            return Response.noContent().build();
        }
    }
}