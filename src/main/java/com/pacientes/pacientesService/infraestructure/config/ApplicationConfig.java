package com.pacientes.pacientesService.infraestructure.config;

import com.pacientes.pacientesService.application.service.PatientService;
import com.pacientes.pacientesService.application.useCase.PatientUseCaseImpl;
import com.pacientes.pacientesService.domain.port.in.PatientUseCase;
import com.pacientes.pacientesService.domain.port.out.PatientRepositoryPort;
import com.pacientes.pacientesService.infraestructure.out.persistence.entity.JpaPatientRepository;
import com.pacientes.pacientesService.infraestructure.out.persistence.entity.JpaPatientRepositoryPortImpl;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig {

    @Bean
    public PatientService patientService(PatientRepositoryPort patientRepositoryPort,
            PatientUseCase patientUseCase, JpaPatientRepository jpaPatientRepositoryRepository){

        return new PatientService(
                new PatientUseCaseImpl(patientRepositoryPort)
        );
    }

    @Bean
    public PatientRepositoryPort patientRepositoryPort(JpaPatientRepositoryPortImpl jpaPatientRepository)   {

        return jpaPatientRepository;
    }









}
