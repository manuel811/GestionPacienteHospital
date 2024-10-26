package com.manuel.hospital.pacientes.services;

import java.util.List;

import com.manuel.hospital.pacientes.entity.Paciente;

public interface PacienteService {
	
	
	
	public void eliminarNombre(String nombre);
	
	
	public Paciente buscarPacienteDni(String dni);
	
	public List<Paciente>buscarPorNombre(String nombre);

	

}
