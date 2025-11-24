package com.pacientes.pacientesService.application.mapper;


import com.pacientes.pacientesService.domain.model.Patient;
import com.pacientes.pacientesService.infraestructure.out.persistence.entity.PatientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toModel(PatientEntity patientEntity);

    PatientEntity toEntity(Patient patient);


}
