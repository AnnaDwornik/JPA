package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p" +
                        " WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanCountOfVisits(Long countOfVisits) {
        return entityManager.createQuery("SELECT DISTINCT p FROM PatientEntity p " +
                " JOIN p.visits v " +
                " GROUP BY p " +
                " HAVING COUNT(v) > :countOfVisits", PatientEntity.class)
                .setParameter("countOfVisits", countOfVisits)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMedicalPackage() {
        return entityManager.createQuery("SELECT p FROM PatientEntity p " +
                        " WHERE p.medicalPackage = true", PatientEntity.class)
                .getResultList();
    }
}
