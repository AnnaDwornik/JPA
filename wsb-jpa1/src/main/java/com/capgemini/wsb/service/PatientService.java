package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    PatientTO findPatientById(final Long id);
    void deletePatient(final Long id);

    List<VisitTO> findPatientsVisitsByPatientId(Long id);
}
