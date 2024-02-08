package dao;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Universidad.Trabajo.Hibernateconexion;
import hibernate.AlumnoSeMatriculaAsignatura;
import hibernate.AlumnoSeMatriculaAsignaturaId;
import hibernate.Asignatura;
import hibernate.CursoEscolar;
import hibernate.Departamento;
import hibernate.Grado;
import hibernate.Persona;
import hibernate.Profesor;

public class BaseDatosService {

	private SessionFactory sf = Hibernateconexion.getSessionFactory();
	
	//ejercicio 2
	public void DatosPersonalesHQL() {
		Session session = sf.openSession();
		String hql = "SELECT p.id_profesor, n.nif FROM Profesor p JOIN p.persona n";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	        int idProfesor = (int) resultado[0];
	        String nif = (String) resultado[1];
	        System.out.println("ID Profesor: " + idProfesor + ", NIF: " + nif);
	    }
		session.close();
	}
	
	public void TotalAsignarurasProfesor() {
		//SELECT pro.id_profesor ,COUNT(*) FROM profesor pro INNER JOIN asignatura ai ON pro.id_profesor = ai.id_profesor group BY pro.id_profesor;
		Session session = sf.openSession();
		String hql = "SELECT p.id_profesor , COUNT(a) FROM Profesor p JOIN p.asignaturas a GROUP BY p.id_profesor";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	        int idProfesor = (int) resultado[0];
	        Long nif = (Long) resultado[1];
	        System.out.println("ID Profesor: " + idProfesor + ", Total asignaturas: " + nif);
	    }
		session.close();
	}
	//ejercicio 3
	
	public void TotalAsignarurasProfesorSQL() {
	    // Consulta SQL nativa
	    String sql = "SELECT pro.id_profesor, COUNT(*) " +
	                 "FROM profesor pro " +
	                 "INNER JOIN asignatura ai ON pro.id_profesor = ai.id_profesor " +
	                 "GROUP BY pro.id_profesor";

	    Session session = sf.openSession();
	    List<Object[]> resultados = session.createNativeQuery(sql, Object[].class).list();

	    for (Object[] resultado : resultados) {
	        int idProfesor = (int) resultado[0];
	        Long totalAsignaturas = (Long) resultado[1]; // Utiliza BigInteger para COUNT en SQL
	        System.out.println("ID Profesor: " + idProfesor + ", Total asignaturas: " + totalAsignaturas);
	    }

	    session.close();
	}
	
	public void DatosPersonalesSQL() {
		Session session = sf.openSession();
		String hql = "SELECT p.id_profesor, per.nif FROM Profesor p INNER JOIN persona per ON p.id_profesor = per.id";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	        int idProfesor = (int) resultado[0];
	        String nif = (String) resultado[1];
	        System.out.println("ID Profesor: " + idProfesor + ", NIF: " + nif);
	    }
		session.close();
	}
	
	// ejercicio 4
	
	public void addAsignatura(int id_grado, Asignatura a,int profesor) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Grado grado = session.get(Grado.class, id_grado);
		Profesor pr = session.get(Profesor.class, profesor);
		a.setProfesor(pr);
		a.setGrado(grado);
		session.persist(a);
		tx1.commit();
		session.close();
	}
	
	// ejercicio 5
	
	public void updateTelefonoProfesor(int idProfesor, String telefono) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Profesor profesor = session.get(Profesor.class, idProfesor);
		Persona datosProfesor = profesor.getPersona();
		datosProfesor.setTelefono(telefono);
		session.merge(profesor);
		tx1.commit();
		session.close();
	}
	
	//ejercicio 6
	
	public void deleteGrado(int idGrado) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Grado grado = session.get(Grado.class, idGrado);
		session.remove(grado);
		tx1.commit();
		session.close();		
	}

	public void mostrarGrados() {
		Session session = sf.openSession();
		String hql = "SELECT g FROM Grado g";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Grado data = (Grado) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();
	}
	
	public void mostrarCursoEscolar() {
		Session session = sf.openSession();
		String hql = "SELECT c FROM CursoEscolar c";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	CursoEscolar data = (CursoEscolar) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();
	}

	public void mostraAsginaturas() {
		Session session = sf.openSession();
		String hql = "SELECT c FROM Asignatura c";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Asignatura data = (Asignatura) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();
	}

	public void mostraProfesor() {
		Session session = sf.openSession();
		String hql = "SELECT c FROM Profesor c";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Profesor data = (Profesor) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();
	}

	public void mostraDepartamento() {
		Session session = sf.openSession();
		String hql = "SELECT c FROM Departamento c";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Departamento data = (Departamento) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();		
	}

	public void mostraPeople() {
		Session session = sf.openSession();
		String hql = "SELECT c FROM Persona c";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Persona data = (Persona) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();	
		
	}

	public void mostraPeopleAsignatura() {
		Session session = sf.openSession();
		String hql = "SELECT c FROM AlumnoSeMatriculaAsignatura c";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	AlumnoSeMatriculaAsignatura data = (AlumnoSeMatriculaAsignatura) resultado[0];
	        System.out.println("data : " + data.toString());
	        
	    }
		session.close();
		
	}
	
	
	
}
