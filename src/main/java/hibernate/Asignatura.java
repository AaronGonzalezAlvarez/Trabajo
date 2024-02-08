package hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Asignatura implements Serializable{
	
	int id;
	String nombre;
	float creditos;
	String tipo;
	int curso;
	int cuatrimestre;
	Profesor profesor;
	Grado grado;
	Set<AlumnoSeMatriculaAsignatura> alumnos = new HashSet<AlumnoSeMatriculaAsignatura>(0);
	
	public Asignatura() {
		
	}
	
	
	
	public Asignatura(String nombre, float creditos, String tipo, int curso, int cuatrimestre) {
		this.nombre = nombre;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		this.cuatrimestre = cuatrimestre;
	}
	
	public Set<AlumnoSeMatriculaAsignatura> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Set<AlumnoSeMatriculaAsignatura> alumnos) {
		this.alumnos = alumnos;
	}
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
	public float getCreditos() {
		return creditos;
	}
	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public Grado getGrado() {
		return grado;
	}
	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	
	
	
	@Override
	public String toString() {
		String string= "";
		if(getProfesor() == null) {
			string ="Asignatura [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", tipo=" + tipo + ", curso="
					+ curso + ", cuatrimestre=" + cuatrimestre + ", grado= " +grado.getNombre()+
					" alumnos = "+ alumnos.size()+"]";
			
		}else {
			string ="Asignatura [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", tipo=" + tipo + ", curso="
					+ curso + ", cuatrimestre=" + cuatrimestre + ", profesor=" + profesor.getNombre() + ", grado= " +grado.getNombre()+
					" alumnos = "+ alumnos.size()+"]";
			
		}
		return string;
	}
	
	
	
	
	
	
}
