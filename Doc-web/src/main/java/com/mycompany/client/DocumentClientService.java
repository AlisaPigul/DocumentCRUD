package com.mycompany.client;

import com.mycompany.util.GeneratorUtil;
import com.mycompany.vo.DocumentItemVO;
import com.mycompany.vo.DocumentVO;
import com.mycompany.vo.DocumentsVO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * Document client service
 */
public class DocumentClientService {

    //Default uri
    private static final String BASE_URI = "http://127.0.0.1:8082/doc-web/rest/json";

    /**
     * Test Creation of document
     * @return document service object
     */
    public DocumentVO testCreation() {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(BASE_URI+"/create");

        DocumentVO document = GeneratorUtil.generateDocument();
        try {

            document = myResource.request(MediaType.APPLICATION_JSON).post(Entity.json(document), DocumentVO.class);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return document;
    }

    /**
     * Test Update of document
     * @id - id of updated document
     * @return document service object
     */
    public DocumentVO testUpdate(Integer id) {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(BASE_URI+"/update");

        DocumentVO document = GeneratorUtil.generateDocument();
        document.setId(id);
        Collection<DocumentItemVO> items = document.getItems();
        items.remove(items.iterator().next());
        try {

            document = myResource.request(MediaType.APPLICATION_JSON).post(Entity.json(document), DocumentVO.class);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return document;
    }

    /**
     * Test Deletion of document
     * @id - id of deleted document
     */
    public void testDelete(Integer id) {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(BASE_URI+"/delete").queryParam("id", id);

        try {

            myResource.request(MediaType.APPLICATION_JSON).get();

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Test get documents
     * @return list of documents
     */
    public List<DocumentVO> testGetAll() {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(BASE_URI+"/getAll");
        DocumentsVO result = null;
        try {

            result = myResource.request(MediaType.APPLICATION_JSON).get(DocumentsVO.class);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return result.getDocuments();
    }

}
