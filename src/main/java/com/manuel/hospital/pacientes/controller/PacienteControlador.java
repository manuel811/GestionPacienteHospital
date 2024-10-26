package com.manuel.hospital.pacientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.hospital.pacientes.entity.Paciente;
import com.manuel.hospital.pacientes.services.PacienteServiceImpl;

@RestController
@RequestMapping("/paciente")
public class PacienteControlador {

	
	@Autowired
	private PacienteServiceImpl pacienteServiceImpl;
	
	
	@PostMapping
	public ResponseEntity<Paciente>createPatient(@RequestBody Paciente paciente){
		
		return ResponseEntity.ok(pacienteServiceImpl.createPatient(paciente));
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Paciente>>getAllPatient(){
		
		
		return ResponseEntity.ok(pacienteServiceImpl.getAllPacient());
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente>getPatientByid(@PathVariable Long id){
		
		Optional<Paciente>pacienteOpcional =Optional.of(pacienteServiceImpl.getPatientById(id));
		
		if(pacienteOpcional.isPresent()) {
			
			return ResponseEntity.ok(pacienteOpcional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente>updatePatient(@RequestBody Paciente paciente, @PathVariable Long id){
		
		
		return ResponseEntity.ok(pacienteServiceImpl.updatePacient(paciente, id));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deletePatient(@PathVariable Long id){
		
		pacienteServiceImpl.deletePacient(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("eliminar/{nombre}")
	
	public ResponseEntity<Void>deleteByName(@PathVariable String nombre){
		
		pacienteServiceImpl.eliminarNombre(nombre);
		return ResponseEntity.noContent().build();
	}
	
	
	
	//Restemplate
	
	
	@GetMapping("dni/{dni}")
	public ResponseEntity<Paciente>findPatientDni(@PathVariable String dni){
	
		return ResponseEntity.ok(pacienteServiceImpl.buscarPacienteDni(dni));
	}
	
	
	
	@GetMapping("nombre/{nombre}")
	public ResponseEntity<List<Paciente>>buscarPorNombre(@PathVariable String nombre){
		return ResponseEntity.ok(pacienteServiceImpl.buscarPorNombre(nombre));
	}
	
	
	
	
}
