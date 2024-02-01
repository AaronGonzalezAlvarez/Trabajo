package hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CursoEscolar implements Serializable{
	
	int id;
	Integer anyo_inicio;
	Integer anyo_fin;
	Set<AlumnoSeMatriculaAsignatura> alumnos = new HashSet<>(0);
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getAnyo_inicio() {
		return anyo_inicio;
	}
	public void setAnyo_inicio(Integer anyo_inicio) {
		this.anyo_inicio = anyo_inicio;
	}
	public Integer getAnyo_fin() {
		return anyo_fin;
	}
	public void setAnyo_fin(Integer anyo_fin) {
		this.anyo_fin = anyo_fin;
	}
	public Set<AlumnoSeMatriculaAsignatura> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Set<AlumnoSeMatriculaAsignatura> alumnos) {
		this.alumnos = alumnos;
	}
	@Override
	public String toString() {
		return "CursoEscolar [id=" + id + ", anyo_inicio=" + anyo_inicio + ", anyo_fin=" + anyo_fin + ", alumnos="
				+ alumnos.size() + "]";
	}
	
	
	
	
}
