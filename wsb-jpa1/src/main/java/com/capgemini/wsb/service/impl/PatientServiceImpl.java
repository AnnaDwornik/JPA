package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findPatientById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        entityManager.createQuery("DELETE FROM VisitEntity v " +
                        " WHERE v.patient.id = :patientId")
                .setParameter("patientId", id)
                .executeUpdate();

        PatientEntity patient = patientDao.findOne(id);
        patientDao.delete(patient);
    }

    @Override
    public List<VisitTO> findPatientsVisitsByPatientId(Long id) {
        PatientEntity patient = patientDao.findOne(id);

        if (patient == null) {
            return null;
        }
        return patient.getVisits().
                stream().
                map(VisitMapper::mapToTO).
                collect(Collectors.toList());
    }
}
