package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Universidad.Trabajo.Hibernateconexion;
import hibernate.Asignatura;
import hibernate.Grado;
import hibernate.Profesor;

public class AsignaturaService {

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
	
	public void addAsignatura(int id_grado, Asignatura a,int profesor) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Grado grado = session.get(Grado.class, id_grado);
		Profesor pr = session.get(Profesor.class, profesor);
		a.setProfesor(pr);
		var asignarutas = grado.getAsignaturas();
		
		asignarutas.add(a);
		
		session.merge(grado);
		tx1.commit();
		session.close();
	}
}