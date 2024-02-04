package hibernate;

import java.util.HashSet;
import java.util.Set;

public class Grado {
	int id;
	String nombre;
	Set<Asignatura> asignaturas = new HashSet<>(0);
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Grado [id=" + id + ", nombre=" + nombre + ", asignaturas=" + asignaturas.size() + "]";
	}
	
	
	
}
