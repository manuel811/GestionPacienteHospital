package com.manuel.hospital.pacientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manuel.hospital.pacientes.entity.Paciente;
import com.manuel.hospital.pacientes.repository.PacienteRepository;

import jakarta.transaction.Transactional;


@Service
public class PacienteServiceImpl implements PacienteService {

	private PacienteRepository pacienteRepository;

	public PacienteServiceImpl(PacienteRepository pacienteRepository) {
		super();
		this.pacienteRepository = pacienteRepository;
	}
	
	
	public List<Paciente>getAllPacient(){
		
		return pacienteRepository.findAll();
	}
	
	public Paciente getPatientById(Long id){
		

		return pacienteRepository.findById(id).get();
	}
	
	public Paciente createPatient(Paciente paciente) {
		
		return pacienteRepository.save(paciente);
	}
	
	
	public void deletePacient(Long id) {
		
		pacienteRepository.deleteById(id);
	}
	
	public Paciente updatePacient(Paciente paciente,Long id) {
		
		Optional<Paciente>pacientes=pacienteRepository.findById(id);
		
		Paciente pacienteActualizado=pacientes.get();
		
		pacienteActualizado.setNombre(paciente.getNombre());
		pacienteActualizado.setApellidos(paciente.getApellidos());
		pacienteActualizado.setDni(paciente.getDni());
		pacienteActualizado.setDireccion(paciente.getDireccion());
		pacienteActualizado.setTelefono(paciente.getTelefono());
		
		pacienteRepository.save(pacienteActualizado);
		
		return pacienteActualizado;
		
	
		
	}


	/*@Override
	public void deleteByName(String nombre) {
		if(nombre==null||nombre.isEmpty()) {
			System.out.println("el nombre no puede ser nulo");
		}
		pacienteRepository.deleteByName(nombre);
	}*/


	@Override
	@Transactional 
	public void eliminarNombre(String nombre) {
		pacienteRepository.deleteByNombre(nombre);
		
	}

	
	//Restemplate

	@Override
	public Paciente buscarPacienteDni(String dni) {
	
		return pacienteRepository.findByDni(dni);
	}


	@Override
	public List<Paciente> buscarPorNombre(String nombre) {
		
		return pacienteRepository.findByNombre(nombre);
	}
	
	
}
