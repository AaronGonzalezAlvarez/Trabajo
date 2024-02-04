package hibernate;

import java.io.Serializable;

public class AlumnoSeMatriculaAsignaturaId implements Serializable{
	int idAlumno;
	int idAsignatura;
	int idCursoEscolar;
	
	
	public AlumnoSeMatriculaAsignaturaId(int idAlumno, int idAsignatura, int idCursoEscolar) {
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.idCursoEscolar = idCursoEscolar;
	}
	
	public AlumnoSeMatriculaAsignaturaId() {
		
	}

	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	public int getIdAsignatura() {
		return idAsignatura;
	}


	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}


	public int getIdCursoEscolar() {
		return idCursoEscolar;
	}


	public void setIdCursoEscolar(int idCursoEscolar) {
		this.idCursoEscolar = idCursoEscolar;
	}


	@Override
	public String toString() {
		return "AlumnoSeMatriculaAsignaturaId [idAlumno=" + idAlumno + ", idAsignatura=" + idAsignatura
				+ ", idCursoEscolar=" + idCursoEscolar + "]";
	}
	
	
	
	

}
