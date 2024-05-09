package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.util.List;

public interface DoctorDao extends Dao<DoctorEntity, Long> {

    List<DoctorEntity> findByDescription(final String pDesc);
}
