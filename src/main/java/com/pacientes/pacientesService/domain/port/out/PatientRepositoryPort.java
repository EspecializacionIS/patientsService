package com.pacientes.pacientesService.domain.port.out;

import com.pacientes.pacientesService.domain.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepositoryPort {

    Patient save(Patient patient);
    Optional<Patient> findById(String id);
    List<Patient> findAll();
    void deleteById(String id);

}
