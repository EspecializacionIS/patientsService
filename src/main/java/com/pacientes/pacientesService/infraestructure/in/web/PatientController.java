package com.pacientes.pacientesService.infraestructure.in.web;

import com.pacientes.pacientesService.infraestructure.out.persistence.entity.JpaPatientRepository;
import com.pacientes.pacientesService.infraestructure.out.persistence.entity.PatientEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/patients")
public class PatientController {


    private final JpaPatientRepository jpaPatientRepository;

    public PatientController(JpaPatientRepository jpaPatientRepository) {
        this.jpaPatientRepository = jpaPatientRepository;
    }

    @PostMapping
    public ResponseEntity<PatientEntity> create(@RequestBody PatientEntity entity) {
        return ResponseEntity.ok(jpaPatientRepository.save(entity));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PatientEntity> getById(@PathVariable String id) {

        return jpaPatientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @GetMapping
    public ResponseEntity<List<PatientEntity>> list() {
        return  ResponseEntity.ok(jpaPatientRepository.findAll());
    }


   /* @PutMapping("/{id}")
    public ResponseEntity<PatientEntity> update(@PathVariable String id, @RequestBody PatientEntity entity) {
        entity.setId(id);
        Patient updated = patientUseCase.updatePatient(mapper.toModel(entity));
        return ResponseEntity.ok(mapper.toEntity(updated));
    }*/



   /* @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        patientUseCase.deletePatient(id);
        return ResponseEntity.noContent().build();
    }*/
}
