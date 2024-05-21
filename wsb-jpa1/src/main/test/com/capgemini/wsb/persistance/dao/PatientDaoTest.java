package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testFindByLastName() {
        String lastName = "Pate";

        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        assertNotNull(patients);
        assertEquals(1, patients.size());

        for (PatientEntity patient: patients) {
            assertEquals(lastName, patient.getLastName());
        }
    }

    @Transactional
    @Test
    public void testFindPatientsWithMoreThanCountOfVisits() {

        long countOfVisits = 2;

        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanCountOfVisits(countOfVisits);

        assertNotNull(patients);
        assertEquals(1,patients.size());
    }

    @Transactional
    @Test
    public void testFindPatientsWithMedicalPackage() {

        List<PatientEntity> patientsWithMedicalPackage = patientDao.findPatientsWithMedicalPackage();

        assertNotNull(patientsWithMedicalPackage);
        assertEquals(2,patientsWithMedicalPackage.size());
        assertTrue(patientsWithMedicalPackage.stream().allMatch(PatientEntity::getMedicalPackage));
    }
}