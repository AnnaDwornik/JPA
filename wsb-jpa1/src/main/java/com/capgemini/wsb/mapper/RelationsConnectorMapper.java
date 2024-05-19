package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.RelationsConnectorTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class RelationsConnectorMapper {

    public static RelationsConnectorTO mapToTO(final PatientEntity patientEntity, final DoctorEntity doctorEntity, final VisitEntity visitEntity, final AddressEntity addressEntity) {
        if (visitEntity == null || doctorEntity == null || patientEntity == null || addressEntity == null)
        {
            return null;
        }
        final RelationsConnectorTO relationsConnectorTO = new RelationsConnectorTO();
        relationsConnectorTO.setPatient(PatientMapper.mapToTO(patientEntity));
        relationsConnectorTO.setDoctor(DoctorMapper.mapToTO(doctorEntity));
        relationsConnectorTO.setVisit(VisitMapper.mapToTO(visitEntity));
        relationsConnectorTO.setAddress(AddressMapper.mapToTO(addressEntity));
        return relationsConnectorTO;
    }
}
