package hibernate;

import java.io.Serializable;

public class AlumnoSeMatriculaAsignatura implements Serializable{
	
	AlumnoSeMatriculaAsignaturaId id;
	Persona persona;
	Asignatura asignatura;
	CursoEscolar cursoEscolar;
	
	public AlumnoSeMatriculaAsignaturaId getId() {
		return id;
	}
	public void setId(AlumnoSeMatriculaAsignaturaId id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public CursoEscolar getCursoEscolar() {
		return cursoEscolar;
	}
	public void setCursoEscolar(CursoEscolar cursoEscolar) {
		this.cursoEscolar = cursoEscolar;
	}
	
	@Override
	public String toString() {
		return "AlumnoSeMatriculaAsignatura [id=" + id + ", persona=" + persona + ", asignatura=" + asignatura
				+ ", cursoEscolar=" + cursoEscolar + "]";
	}
	
	


}
