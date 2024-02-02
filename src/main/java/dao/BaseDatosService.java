package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Universidad.Trabajo.Hibernateconexion;
import hibernate.Asignatura;
import hibernate.Grado;
import hibernate.Persona;
import hibernate.Profesor;

public class BaseDatosService {

	private SessionFactory sf = Hibernateconexion.getSessionFactory();

//	public Asignatura findById(String id) {
//		return sf.openSession().get(Asignatura.class, id);
//	}
//	
//	public List<Asignatura> findByNivel(String nivel) {
//		Session session = sf.openSession();
//		String hql = "FROM Editor E WHERE E.nivel = :nivelPasado";
//		Query<Asignatura> query = session.createQuery(hql,Asignatura.class);
//		query.setParameter("nivelPasado",nivel);
//		
//		
//		List<Asignatura> results = query.list();
//		return results;
//	}
//	
//	public void aa() {
//		Session session = sf.openSession();
//	List<Object[]> personsWithPhones = session.createQuery(
//			"from Escritor Join Libro", Object[].class)
//			.getResultList();
//		for (Object[] personWithPhone: personsWithPhones) {
//			Asignatura p = (Asignatura) personWithPhone[0];
//			Libro ph = (Libro) personWithPhone[1];
//			System.out.println(p);
//			System.out.println(ph);
//		}
//	}
//
//	public void save(Asignatura user) {
//		Session session = sf.openSession();
//		Transaction tx1 = session.beginTransaction();
//		session.persist(user);
//	
//		tx1.commit();
//		session.close();
//	}
//
//	public void update(Asignatura user) {
//		Session session = sf.openSession();
//		Transaction tx1 = session.beginTransaction();
//		session.merge(user);
//		tx1.commit();
//		session.close();
//	}
//
//	public void delete(Asignatura cliente) {
//		Session session = sf.openSession();
//		Transaction tx1 = session.beginTransaction();
//		session.remove(cliente);
//		tx1.commit();
//		session.close();
//	}
//
//	public List<Asignatura> findAllHQL() {
//		Session session =sf.openSession();
//		List<Asignatura> editores = (List<Asignatura>)session.createQuery("From Asignatura", Asignatura.class).list();
//		 //System.out.println(editores);
//		session.close();
//		return editores;
//	}
//	
//	//https://docs.jboss.org/hibernate/orm/6.1/userguide/html_single/Hibernate_User_Guide.html#sql
//	//18. Native SQL
//	public List<Editor> findAllSQL() {
//		Session session =sf.openSession();
//		List<Editor> editores = session.createNativeQuery("Select * From Editor", Editor.class).getResultList();
//		 System.out.println(editores);
//		session.close();
//		return editores;
//	}
	
	
	
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
}
