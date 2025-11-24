package com.pacientes.pacientesService.application.useCase;


import com.pacientes.pacientesService.domain.model.Patient;
import com.pacientes.pacientesService.domain.port.in.PatientUseCase;
import com.pacientes.pacientesService.domain.port.out.PatientRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientUseCaseImpl implements PatientUseCase {


    private final PatientRepositoryPort patientRepository;


    public PatientUseCaseImpl(PatientRepositoryPort patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        // Validaciones de negocio
        if (patient.getId() != null) {
            throw new IllegalArgumentException("El ID debe ser generado, no enviado.");
        }

        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        if (patient.getId() == null) {
            throw new IllegalArgumentException("Para actualizar un paciente, el ID no puede ser null.");
        }

        Optional<Patient> existing = patientRepository.findById(patient.getId());

        if (existing.isEmpty()) {
            throw new RuntimeException("Paciente con ID " + patient.getId() + " no existe.");
        }

        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String id) {
        Optional<Patient> existing = patientRepository.findById(id);

        if(existing.isEmpty()) {
            throw new RuntimeException("No existe un paciente con el ID " + id);
        }

        patientRepository.deleteById(id);
    }

}
