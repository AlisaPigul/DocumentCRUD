package com.mycompany.rest;

import com.mycompany.service.DocumentService;
import com.mycompany.vo.DocumentVO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * Rest document service
 */
@Path("/docs")
public class DocumentRestService {

    @Inject
    DocumentService docProcessor;

    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createDocument(DocumentVO document) {
        if (document == null) {
            Response.status(201).build();
        }
        return Response.status(200).entity(docProcessor.createDocument(document)).build();

    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateDocument(DocumentVO document) {
        if (document == null) {
            Response.status(201).build();
        }
        return Response.status(200).entity(docProcessor.updateDocument(document)).build();

    }

    @GET
    @Path("/getById")
    @Produces("application/json")
    public Response getDocumentById(@QueryParam("id") Integer id) {
        if (id == null) {
            Response.status(201).build();
        }
        return Response.status(200).entity(docProcessor.getDocumentById(id)).build();
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Response getDocuments() {
        return Response.status(200).entity(docProcessor.getAllDocuments()).build();
    }

    @GET
    @Path("/delete")
    @Produces("application/json")
    public Response deleteDocumentById(@QueryParam("id") Integer id) {
        if (id == null) {
            Response.status(201).build();
        }
        docProcessor.deleteDocumentById(id);
        return Response.status(200).build();
    }
}
