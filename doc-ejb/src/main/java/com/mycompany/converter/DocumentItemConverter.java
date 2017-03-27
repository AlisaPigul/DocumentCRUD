package com.mycompany.converter;

import com.mycompany.domain.DocumentItemEntity;
import com.mycompany.vo.DocumentItemVO;

/**
 * Converter between item entity and service
 */
public class DocumentItemConverter {
    private DocumentItemConverter() {
    }

    /**
     * Converter from service to entity
     * @param vo - service item
     * @return entity
     */
    public static DocumentItemEntity fromVOToEntity(DocumentItemVO vo) {
        DocumentItemEntity entity = new DocumentItemEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setPrice(vo.getPrice());
        return entity;
    }

    /**
     * Converter from entity to service object
     * @param entity - item entity
     * @return service item
     */
    public static DocumentItemVO fromEntityToVO(DocumentItemEntity entity) {
        DocumentItemVO vo = new DocumentItemVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setPrice(entity.getPrice());
        return vo;
    }
}
