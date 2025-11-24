package com.pacientes.pacientesService.domain.port.in;

import com.pacientes.pacientesService.domain.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientUseCase {

    Patient createPatient(Patient patient);
    Optional<Patient> getPatientById(String id);
    List<Patient> listPatients();
    Patient updatePatient(Patient patient);
    void deletePatient(String id);
}
