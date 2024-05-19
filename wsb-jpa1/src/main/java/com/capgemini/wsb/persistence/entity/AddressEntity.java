package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String addressLine1;

	private String addressLine2;

	@Column(nullable = false)
	private String postalCode;

	// Relations
	@ManyToMany(mappedBy = "addresses")
	private Collection<PatientEntity> patients;

	@ManyToMany(mappedBy = "addresses")
	private Collection<DoctorEntity> doctors;

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public PatientEntity getPatients() {
		return (PatientEntity) patients;
	}

	public void setPatients(PatientEntity patients) {
		this.patients = (Collection<PatientEntity>) patients;
	}

	public DoctorEntity getDoctors() {
		return (DoctorEntity) doctors;
	}

	public void setDoctors(DoctorEntity doctors) {
		this.doctors = (Collection<DoctorEntity>) doctors;
	}
}
