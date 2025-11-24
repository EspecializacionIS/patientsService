package com.pacientes.pacientesService.application.service;


import com.pacientes.pacientesService.domain.model.Patient;
import com.pacientes.pacientesService.domain.port.in.PatientUseCase;

import java.util.List;
import java.util.Optional;


public class PatientService implements PatientUseCase {

    private final PatientUseCase patientUseCase;

    public PatientService( PatientUseCase patientUseCase) {
        this.patientUseCase = patientUseCase;
    }


    @Override
    public Patient createPatient(Patient patient) {
        return patientUseCase.createPatient(patient);
    }


    @Override
    public Optional<Patient> getPatientById(String id) {
        return patientUseCase.getPatientById(id);
    }


    @Override
    public List<Patient> listPatients() {
        return patientUseCase.listPatients();
    }


    @Override
    public Patient updatePatient(Patient patient) {

        return patientUseCase.updatePatient(patient);
    }


    @Override
    public void deletePatient(String id) {
        patientUseCase.deletePatient(id);
    }
}
