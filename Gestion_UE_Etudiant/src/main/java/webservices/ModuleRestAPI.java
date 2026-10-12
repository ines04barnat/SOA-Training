package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/module")
public class ModuleRestAPI {
    static ModuleBusiness helper = new ModuleBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListModule()
    {
        return Response.status(200).entity(helper.getAllModules()).build();  }
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createModule(Module module)
    {
        if (helper.addModule(module)){
            return Response.status(200).entity("Module successfully created!").build();
        }
        else{
            return Response.status(400).entity("Module could not be created!").build();
        }
    }
    @Path("/{matricule}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getModuleByMatricule(@PathParam("matricule") String matricule )
    {
        return Response.status(200).entity(helper.getModuleByMatricule(matricule)).build();
    }
    @Path("/delete/{matricule}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteModuleByMatricule(@PathParam("matricule") String matricule )
    {   if (helper.deleteModule(matricule)){
            return Response.status(200).entity("Module successfully deleted!").build();}
        else{
            return Response.status(400).entity("Module could not be deleted!").build();
    }
    }
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetModuleByType(@QueryParam("type") Module.TypeModule type)
    {
        return Response.status(200).entity(helper.getModulesByType(type)).build();
    }



}
