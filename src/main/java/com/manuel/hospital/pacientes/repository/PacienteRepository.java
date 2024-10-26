package com.manuel.hospital.pacientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.hospital.pacientes.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	public void deleteByNombre (String nombre);
	
	public Paciente findByDni(String dni);
	
	public List<Paciente>findByNombre(String nombre) ; //El nombre debe ser como el modelo

}
