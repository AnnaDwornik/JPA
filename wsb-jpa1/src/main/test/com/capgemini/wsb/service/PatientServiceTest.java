package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityManager entityManager;

    private DoctorEntity createNewDoctor() {
        DoctorEntity doctor = new DoctorEntity();

        doctor.setFirstName("John");
        doctor.setLastName("Goldberg");
        doctor.setTelephoneNumber("(042) 13543694");
        doctor.setEmail("john.goldberg@icloud.com");
        doctor.setDoctorNumber("512347");
        doctor.setSpecialization(Specialization.OCULIST);
        return doctor;
    }

    private PatientEntity createNewPatient() {
        PatientEntity patient = new PatientEntity();

        patient.setFirstName("Karen");
        patient.setLastName("Baldwin");
        patient.setTelephoneNumber("(093) 92375022");
        patient.setEmail("karenbaldwin@gmail.com");
        patient.setPatientNumber("312948");
        patient.setDateOfBirth(LocalDate.of(2000,9,2));
        patient.setMedicalPackage(Boolean.TRUE);
        return patient;
    }

    private VisitEntity createNewVisit() {
        VisitEntity visit = new VisitEntity();
        DoctorEntity doctor = createNewDoctor();
        entityManager.persist(doctor);
        visit.setDoctor(doctor);
        visit.setPatient(createNewPatient());
        visit.setTime(LocalDateTime.now());
        visit.setDescription("Rutynowa kontrola");
        return visit;
    }
    @Test
    public void testFindPatientById() {
        PatientEntity patient = createNewPatient();
        patientDao.save(patient);

        PatientTO patientTO = patientService.findPatientById(patient.getId());

        assertNotNull(patientTO);

        assertEquals(patient.getId(), patientTO.getId());
        assertEquals(patient.getFirstName(), patientTO.getFirstName());
        assertEquals(patient.getLastName(), patientTO.getLastName());
        assertEquals(patient.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patient.getEmail(), patientTO.getEmail());
        assertEquals(patient.getPatientNumber(), patientTO.getPatientNumber());
        assertEquals(patient.getDateOfBirth(), patientTO.getDateOfBirth());
        assertEquals(patient.getMedicalPackage(), patientTO.getMedicalPackage());
    }

    @Test
    public void testDeletePatient() {
        PatientEntity patient = createNewPatient();
        patientDao.save(patient);

        VisitEntity visit = createNewVisit();
        visit.setPatient(patient);
        entityManager.persist(visit);

        patientService.deletePatient(patient.getId());
        PatientTO patientTO = patientService.findPatientById(patient.getId());
        assertNull(patientTO);

        List<VisitEntity> visits = entityManager.createQuery("SELECT visits FROM VisitEntity visits" +
                " WHERE visits.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patient.getId())
                .getResultList();

        assertTrue(visits.isEmpty());

        DoctorEntity doctorExist = entityManager.find(DoctorEntity.class, visit.getDoctor().getId());
        assertNotNull(doctorExist);
    }

    @Test
    public void testFindPatientsVisitsByPatientId() {
        Long patientId = 2L;

        List<VisitTO> visitTOs = patientService.findPatientsVisitsByPatientId(patientId);

        assertNotNull(visitTOs);
        assertEquals(3, visitTOs.size());
    }
}