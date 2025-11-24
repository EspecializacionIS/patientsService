package com.pacientes.pacientesService.infraestructure.out.persistence.entity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPatientRepository extends JpaRepository<PatientEntity, String> {

}
