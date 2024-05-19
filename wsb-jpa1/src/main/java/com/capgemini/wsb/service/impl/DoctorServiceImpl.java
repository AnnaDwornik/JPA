package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao pdoctorDao)
    {
        doctorDao = pdoctorDao;
    }

    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity entity = doctorDao.findOne(id);
        return DoctorMapper.mapToTO(entity);
    }
}
