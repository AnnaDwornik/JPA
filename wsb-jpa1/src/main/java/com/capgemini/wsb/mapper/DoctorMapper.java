package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public final class DoctorMapper {


    public static DoctorTO mapToTO(final DoctorEntity doctorEntity)
    {
        if (doctorEntity == null)
        {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(patientTO.getId());
        doctorEntity.setFirstName(patientTO.getFirstName());
        doctorEntity.setLastName(patientTO.getLastName());
        doctorEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        doctorEntity.setEmail(patientTO.getEmail());
        doctorEntity.setDoctorNumber(patientTO.getDoctorNumber());
        doctorEntity.setSpecialization(patientTO.getSpecialization());
        return doctorEntity;
    }
}
