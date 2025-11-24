package com.pacientes.pacientesService.infraestructure.out.persistence.entity;

import com.pacientes.pacientesService.application.mapper.PatientMapper;
import com.pacientes.pacientesService.domain.model.Patient;
import com.pacientes.pacientesService.domain.port.out.PatientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JpaPatientRepositoryPortImpl implements PatientRepositoryPort {

    private final JpaPatientRepository springRepo;
    private final PatientMapper mapper;


    @Override
    public Patient save(Patient patient) {
        PatientEntity entity = mapper.toEntity(patient);
        PatientEntity saved = springRepo.save(entity);
        return mapper.toModel(saved);
    }


    @Override
    public Optional<Patient> findById(String id) {
        return springRepo.findById(id).map(mapper::toModel);
    }


    @Override
    public List<Patient> findAll() {
        return springRepo.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }


    @Override
    public void deleteById(String id) {
        springRepo.deleteById(id);
    }
}


