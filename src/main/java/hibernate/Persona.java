package hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Persona implements Serializable{
	
	int id;
	String nif;
	String nombre;
	String apellido1;
	String apellido2;
	String ciudad;
	String direccion;
	String telefono;
	Date fecha_nacimiento;
	String sexo;
	String tipo;
	Profesor profesor;
	Set<AlumnoSeMatriculaAsignatura> asignaturas = new HashSet<AlumnoSeMatriculaAsignatura>(0);	
	
	public Persona() {
		
	}
	
	
	
	public Persona(String nif, String nombre, String apellido1, String apellido2, String ciudad, String direccion,
			String telefono, Date fecha_nacimiento, String sexo, String tipo) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNif() {
		return nif;
	}
	
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getApellido1() {
		return apellido1;
	}
	
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	
	public String getApellido2() {
		return apellido2;
	}
	
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	
	public String getCiudad() {
		return ciudad;
	}
	
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	
	public String getSexo() {
		return sexo;
	}
	
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public String getTipo() {
		return tipo;
	}
	
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	


	public Set<AlumnoSeMatriculaAsignatura> getAsignaturas() {
		return asignaturas;
	}


	public void setAsignaturas(Set<AlumnoSeMatriculaAsignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}


	@Override
	public String toString() {
//		String aux=" No es profesor";
//		if(profesor != null) {
//			profesor.ge
//		}
		
		String data = "";
		
		if(profesor == null) {
			data = "Persona [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
					+ apellido2 + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono=" + telefono
					+ ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + ", tipo=" + tipo + " , asignaturas: " + asignaturas.size() +" ]";
		}else {
			data = "Persona [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
					+ apellido2 + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono=" + telefono
					+ ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + ", tipo=" + tipo + " profesor: "+ 				
					profesor.getId_profesor()+" , asignaturas: " + asignaturas.size() +" ]";
		}
		
		return data;
	}
	
	
	
	
}