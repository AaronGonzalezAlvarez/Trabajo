package hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Profesor implements Serializable{
	
	int id_profesor;
	String nombre;
	Departamento departamento;
	Set<Asignatura> asignaturas = new HashSet<>(0);
	Persona persona;
	
	
	public int getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	@Override
	public String toString() {
		return "Profesor [id_profesor=" + id_profesor +" , departamento=" + departamento.getNombre()
				+ " asignaturas = " +asignaturas.size()+"  , datosPErsona = "+persona.getNif()+"]";
	}

}
