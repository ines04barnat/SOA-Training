package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestAPI {
    //GET list UEs
    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUEs() {
        return Response.status(200).entity(helper.getListeUE()).build();

    }

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUe(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response.status(200).entity("ok").build();
        }
        else{return Response.status(400).entity("error").build();}
    }
    @Path("/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUE(@PathParam("code") int code) {
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUEsBySemestre(@QueryParam("semestre") int semestre) {
        return Response.status(200).entity(helper.getUEBySemestre(semestre)).build();
    }
    @Path("delete/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteUE(@PathParam("code") int code) {
        if (helper.deleteUniteEnseignement(code)) {
            return Response.status(200).entity("supprimer avec succes ").build();
        }
        return Response.status(400).entity("not found ").build();
    }

}
