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
        // Given
        String lastName = "Pate";

        // When
        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // Then
        assertNotNull(patients);
        assertEquals(1, patients.size());

        for (PatientEntity patient: patients) {
            assertEquals(lastName, patient.getLastName());
        }
    }

    @Transactional
    @Test
    public void testFindPatientsWithMoreThanCountOfVisits() {
        // Given
        long countOfVisits = 2;
        // When
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanCountOfVisits(countOfVisits);
        // Then
        assertNotNull(patients);
        assertEquals(1,patients.size());
    }

    @Transactional
    @Test
    public void testFindPatientsWithMedicalPackage() {
        // When
        List<PatientEntity> patientsWithMedicalPackage = patientDao.findPatientsWithMedicalPackage();
        // Then
        assertNotNull(patientsWithMedicalPackage);
        assertEquals(2,patientsWithMedicalPackage.size());
        assertTrue(patientsWithMedicalPackage.stream().allMatch(PatientEntity::getMedicalPackage));
    }
}