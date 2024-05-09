package com.capgemini.wsb.dto;

public class RelationsConnectorTO {
    private PatientTO patient;

    private AddressTO address;
    private DoctorTO doctor;
    private VisitTO visit;

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public VisitTO getVisit() {
        return visit;
    }

    public void setVisit(VisitTO visit) {
        this.visit = visit;
    }
}
