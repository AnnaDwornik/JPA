package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

    @Override
    public List<DoctorEntity> findByDescription(String pDesc) {
        return entityManager.createQuery("select doc from DoctorEntity doc " +
                "join doc.visitEntities visits " +
                "where visits.description like :param1", DoctorEntity.class)
                .setParameter("param1", pDesc)
                .getResultList();
    }
}
