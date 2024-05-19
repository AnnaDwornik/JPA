package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

    @Override
    public List<DoctorEntity> findByVisitDescription(String pDesc) {
        return entityManager.createQuery("select d from DoctorEntity d " +
                "join d.visits visit " +
                "where visit.description like :param1", DoctorEntity.class)
                .setParameter("param1", "%"+pDesc+"%")
                .getResultList();
    }
}
