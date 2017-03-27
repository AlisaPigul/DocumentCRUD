package com.mycompany.util;

import com.mycompany.vo.DocumentItemVO;
import com.mycompany.vo.DocumentVO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Util for generation of documents
 */
public class GeneratorUtil {

    private GeneratorUtil() {

    }

    /**
     * Generate document
     * @return service document
     */
    public static DocumentVO generateDocument() {
        DocumentVO document = new DocumentVO();
        int randNum = (int) (Math.random()*10);
        document.setName("Doc"+randNum);
        document.setCode(1);
        document.setDate(new Date(1000));
        document.setItems(generateItems());
        return document;
    }

    /**
     * Generate document item
     * @return document item service object
     */
    public static DocumentItemVO generateDocumentItem() {
        DocumentItemVO item = new DocumentItemVO();
        int randNum = (int) (Math.random()*10);
        item.setName("item"+ randNum);
        item.setPrice(new BigDecimal(Math.abs(randNum)));
        return item;
    }

    /**
     * Generate items
     * @return set of items
     */
    public static Set<DocumentItemVO> generateItems() {
        Set<DocumentItemVO> items = new HashSet<>();
        items.add(generateDocumentItem());
        items.add(generateDocumentItem());
        return items;
    }
}
