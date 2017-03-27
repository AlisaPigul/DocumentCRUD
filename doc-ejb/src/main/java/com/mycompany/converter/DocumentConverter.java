package com.mycompany.converter;

import com.mycompany.domain.DocumentEntity;
import com.mycompany.domain.DocumentItemEntity;
import com.mycompany.vo.DocumentItemVO;
import com.mycompany.vo.DocumentVO;

import java.util.HashSet;
import java.util.Set;

/**
 * Converter for document entity and service
 */
public class DocumentConverter {

    private DocumentConverter() {
    }

    /**
     * Convert from service document to entity
     * @param vo - service document
     * @return entity document
     */
    public static DocumentEntity fromVOToEntity(DocumentVO vo) {
        DocumentEntity entity = new DocumentEntity();
        entity.setId(vo.getId());
        entity.setDate(vo.getDate());
        entity.setCode(vo.getCode());
        entity.setName(vo.getName());
        if (vo.getItems() != null) {
            Set<DocumentItemEntity> items = new HashSet<>();
            DocumentItemEntity item;
            for (DocumentItemVO itemVO : vo.getItems()) {
                item = DocumentItemConverter.fromVOToEntity(itemVO);
                item.setDocument(entity);
                items.add(item);
            }
            entity.setItems(items);
        }
        return entity;
    }

    /**
     * Convert from entity document to service
     * @param entity - entity document
     * @return service document
     */
    public static DocumentVO fromEntityToVO(DocumentEntity entity) {
        DocumentVO vo = new DocumentVO();
        vo.setId(entity.getId());
        vo.setDate(entity.getDate());
        vo.setCode(entity.getCode());
        vo.setName(entity.getName());
        if (entity.getItems() != null) {
            Set<DocumentItemVO> items = new HashSet<>();
            for (DocumentItemEntity item : entity.getItems()) {
                items.add(DocumentItemConverter.fromEntityToVO(item));
            }
            vo.setItems(items);
        }
        return vo;
    }
}
