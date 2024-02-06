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
	
	
	
	
	
	//pruebas repaso
	//HQL
	
	//Me gusta poner esta mejor en la entrega
	public void CantidadAsignaturasPorAlumno() {
		Session session = sf.openSession();
		String hql = "SELECT p,COALESCE(COUNT(as), 0) FROM Persona p LEFT JOIN p.asignaturas as where p.tipo = 'alumno' GROUP BY p.id";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Persona persona = (Persona) resultado[0];
	        long total = (long) resultado[1];
	        System.out.println("DNI Persona: " + persona.getNif() + ", total asignaturas: " + total + " tipo: " + persona.getTipo());
	    }
		session.close();
	}
	
	public void totalAlumnosPorAsignatura() {
		Session session = sf.openSession();
		String hql = "SELECT a,COALESCE(COUNT(as), 0) FROM Asignatura a LEFT JOIN a.alumnos as GROUP BY a.id";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Asignatura asignatura = (Asignatura) resultado[0];
	        long total = (long) resultado[1];
	        System.out.println("Asignatura: " + asignatura.getNombre() + ", total asignaturas: " + total);
	    }
		session.close();
	}
	
	public void totalAlumnosPorAsignaturaEnConcreto(String asignatura) {
		Session session = sf.openSession();
		String hql = "SELECT a,COALESCE(COUNT(as), 0) FROM Asignatura a LEFT JOIN a.alumnos as where a.nombre = :asignatura GROUP BY a.id";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("asignatura",asignatura);
		List<Object[]> results = query.list();
	    for (Object[] resultado : results) {
	    	Asignatura a = (Asignatura) resultado[0];
	    	long nif = (long) resultado[1];
	        System.out.println("Asignatura: " + a.getNombre() + ", total asignatura: " + nif);
	    }
		session.close();
	}
	
	public void asignaturaQueDaCadaProfesor() {
		Session session = sf.openSession();
		String hql = "SELECT p,a FROM Profesor p LEFT JOIN p.asignaturas a";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Profesor profesor = (Profesor) resultado[0];
	        Asignatura asignatura = (Asignatura) resultado[1];
	        if(asignatura != null) {
	        	System.out.println("idProfesor: " + profesor.getId_profesor() + ", Asignaturas: " + asignatura.getNombre());
	        }else {
	        	System.out.println("idProfesor: " + profesor.getId_profesor() + ", No da ninguna asignatura");	        	
	        }
	        
	    }
		session.close();
	}
	
	public void asignaturaQueDaCadaProfesorPorIdProfesor(int idProfesor) {
		Session session = sf.openSession();
		String hql = "SELECT p,a FROM Profesor p LEFT JOIN p.asignaturas a where p.id = :idProfesor";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("idProfesor",idProfesor);
		List<Object[]> results = query.list();
	    for (Object[] resultado : results) {
	    	Profesor profesor = (Profesor) resultado[0];
	        Asignatura asignatura = (Asignatura) resultado[1];
	        if(asignatura != null) {
	        	System.out.println("idProfesor: " + profesor.getId_profesor() + ", Asignaturas: " + asignatura.getNombre());
	        }else {
	        	System.out.println("idProfesor: " + profesor.getId_profesor() + ", No da ninguna asignatura");	        	
	        }
	    }
		session.close();
	}
	
	public void profesoresPorGenero(String genero) {
		Session session = sf.openSession();
		String hql = "SELECT p,per FROM Profesor p JOIN p.persona per where per.sexo = :genero";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("genero",genero);
		List<Object[]> results = query.list();
	    for (Object[] resultado : results) {
	    	Profesor profesor = (Profesor) resultado[0];
	        Persona persona = (Persona) resultado[1];
	        System.out.println("idProfesor: " + profesor.getId_profesor() + ", sexo: " + persona.getSexo());
	        
	    }
		session.close();
	}
	
	public void asignaturaQueDaCadaProfesorPorGenero(String genero) {
		Session session = sf.openSession();
		String hql = "SELECT p,a,per FROM Profesor p LEFT JOIN p.asignaturas a INNER JOIN p.persona per where per.sexo = :genero";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("genero",genero);
		List<Object[]> results = query.list();
	    for (Object[] resultado : results) {
	    	Profesor profesor = (Profesor) resultado[0];
	        Asignatura asignatura = (Asignatura) resultado[1];
	        Persona persona = (Persona) resultado[2];
	        if(asignatura != null) {
	        	System.out.println("idProfesor: " + profesor.getId_profesor() + ", Asignaturas: " + asignatura.getNombre() + " , genero =" + persona.getSexo());
	        }else {
	        	System.out.println("idProfesor: " + profesor.getId_profesor() + ", No da ninguna asignatura , genero =" + persona.getSexo());	        	
	        }
	        
	    }
		session.close();
	}
	
	public void totalAsignaturaPorDepartamento() {
		Session session = sf.openSession();
		String hql = "SELECT de,COALESCE(COUNT(a), 0) FROM Profesor p LEFT JOIN p.asignaturas a INNER JOIN p.departamento de GROUP BY de.id";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Departamento departamento = (Departamento) resultado[0];
	    	long total = (long) resultado[1];
	        System.out.println("departamento: " + departamento.getNombre() + " , asignaturas: " + total);
	        
	    }
		session.close();
	}
	
	public void AsignaturaPorDepartamento() {
		Session session = sf.openSession();
		String hql = "SELECT de,a FROM Profesor p LEFT JOIN p.asignaturas a INNER JOIN p.departamento de";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Departamento departamento = (Departamento) resultado[0];
	    	Asignatura asignatura = (Asignatura) resultado[1];
	    	if(asignatura != null) {
		        System.out.println("departamento: " + departamento.getNombre() + " , asignatura: " + asignatura.getNombre());
	    	}else {
		        System.out.println("departamento: " + departamento.getNombre() + " , asignatura: No tiene");
	    	}
	        
	    }
		session.close();
	}
	
	public void totalGeneroPorDepartamento() {
		Session session = sf.openSession();
		String hql = "SELECT de,COALESCE(COUNT(pe), 0) FROM Profesor p LEFT JOIN p.persona pe INNER JOIN p.departamento de where pe.sexo = 'M' GROUP BY de.id";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Departamento departamento = (Departamento) resultado[0];
	    	long total = (long) resultado[1];
	        System.out.println("departamento: " + departamento.getNombre() + " , profesores por genero: " + total);
	        
	    }
		session.close();
	}
	
	public void creditostotalesPorGrado() {
		Session session = sf.openSession();
		String hql = "SELECT gr,COALESCE(sum(a.creditos),0) as creditos FROM Grado gr LEFT JOIN gr.asignaturas a GROUP BY gr.id order by creditos desc";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Grado grado = (Grado) resultado[0];
	    	Double total = (Double) resultado[1];
		    System.out.println("grado: " + grado.getNombre() + " , total creditos: " + total);	 
	    }
		session.close();
	}
	
	public void asignatiraGradoYProfesor() {
		Session session = sf.openSession();
		String hql = "SELECT gr,asi,pr FROM Grado gr LEFT JOIN gr.asignaturas asi LEFT JOIN asi.profesor pr";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    //session.close();
	    for (Object[] resultado : resultados) {
	    	Grado grado = (Grado) resultado[0];
	    	Asignatura asignatura = (Asignatura) resultado[1];
	    	Profesor profesor = (Profesor) resultado[2];
	    	if(asignatura == null) {
	    		asignatura = new Asignatura();
	    	}
	    	if(profesor == null) {
	    		profesor = new Profesor();
	    	}
		    System.out.println("grado: " + grado.getNombre() + " , asignatura: " + asignatura.getNombre() + " , profesor: " + profesor.getId_profesor());	 
	    }
		session.close();
	}
	
	public void cursoEscolaYAlumnosPorCurso() {
		Session session = sf.openSession();
		String hql = "SELECT cur,pr FROM CursoEscolar cur JOIN cur.alumnos al JOIN al.persona pr";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	CursoEscolar cursoEscolar = (CursoEscolar) resultado[0];
	    	Persona persona = (Persona) resultado[1];
		    System.out.println("Curso escolar: " + cursoEscolar.getAnyo_inicio() + " , NIF alumno: " + persona.getNif());	 
	    }
		session.close();
	}
	
	public void asignaturasDeCadaPersona() {
		Session session = sf.openSession();
		String hql = "SELECT asi,pr FROM Asignatura asi JOIN asi.alumnos al JOIN al.persona pr ORDER BY pr.nif asc";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Asignatura asignatura = (Asignatura) resultado[0];
	    	Persona persona = (Persona) resultado[1];
		    System.out.println("Nif: " + persona.getNif() + " , Asignatura: " + asignatura.getNombre());	 
	    }
		session.close();
	}
	
	public void getAlumnoProfesorAsignatura() {
		Session session = sf.openSession();
		String hql = "SELECT per,pr,asi FROM Persona per JOIN per.asignaturas asis JOIN asis.asignatura asi JOIN asi.profesor pr ORDER BY per.nif desc";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Persona persona = (Persona) resultado[0];
	    	Profesor profesor = (Profesor) resultado[1];
	    	Asignatura asignatura = (Asignatura) resultado[2];
		    System.out.println("Nif: " + persona.getNif() + " , profesor: " +profesor.getId_profesor()+" , Asignatura: " + asignatura.getNombre());	 
	    }
		session.close();
	}
	
	public void HQL16() {
		
	}
	
	public void HQL17() {
		
	}
	
	public void HQL18() {
		
	}
	
	public void HQL19() {
		
	}
	
	public void HQL20() {
		
	}
	
	
	//SQL
	
	// SELECT p.id_profesor, COUNT(a.id) AS total FROM profesor p left JOIN asignatura a ON p.id_profesor=a.id_profesor GROUP BY p.id_profesor ORDER BY total desc;
	// SELECT g.nombre, COUNT(a.id) AS total FROM grado g left JOIN asignatura a ON g.id=a.id_grado GROUP BY g.nombre ORDER BY total desc;
	// SELECT g.nombre, COUNT(a.tipo) AS total FROM grado g left JOIN asignatura a ON g.id=a.id_grado WHERE a.tipo = 'optativa' GROUP BY g.nombre ORDER BY total desc;
	// SELECT c.id, COUNT(a.id_curso_escolar) AS alumnos FROM curso_escolar c LEFT JOIN alumno_se_matricula_asignatura a ON c.id=a.id_curso_escolar GROUP BY c.id;
	
	// interesante consulta
	// SELECT g.nombre, a.nombre, p.id_profesor FROM grado g left JOIN asignatura a ON g.id=a.id_grado left JOIN profesor p ON p.id_profesor=a.id_profesor
	
	// SELECT cur.anyo_inicio, per.nif FROM curso_escolar cur INNER JOIN alumno_se_matricula_asignatura al ON cur.id=al.id_curso_escolar INNER JOIN persona per ON per.id=al.id_alumno
	// SELECT per.nif, asi.nombre FROM persona per INNER JOIN alumno_se_matricula_asignatura al ON al.id_alumno=per.id INNER JOIN asignatura asi ON asi.id=al.id_asignatura ORDER BY per.nif asc;
	// SELECT per.nif, pr.id_profesor, asi.nombre FROM persona per INNER JOIN alumno_se_matricula_asignatura al ON al.id_alumno=per.id INNER JOIN asignatura asi ON asi.id=al.id_asignatura INNER JOIN profesor pr ON pr.id_profesor=asi.id_profesor ORDER BY per.nif desc;
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	
	public void SQL1() {
		
	}
	
	public void SQL2() {
		
	}
	
	public void SQL3() {
		
	}
	
	public void SQL4() {
		
	}
	
	public void SQL5() {
		
	}
	
	public void SQL6() {
		
	}
	
	public void SQL7() {
		
	}
	
	public void SQL8() {
		
	}
	
	public void SQL9() {
		
	}
	
	public void SQL10() {
		
	}
	
	public void SQL11() {
		
	}
	
	public void SQL12() {
		
	}
	
	public void SQL13() {
		
	}
	
	public void SQL14() {
		
	}
	
	public void SQL15() {
		
	}
	
	public void SQL16() {
		
	}
	
	public void SQL17() {
		
	}
	
	public void SQL18() {
		
	}
	
	public void SQL19() {
		
	}
	
	public void SQL20() {
		
	}
	
	// añadir nuevo fila a alunmo_se_matricula
	public void addAlumnoMatriculaAsignatura(int idAlumno, int idAsignatura, int idCursoEscolar) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Persona persona = session.get(Persona.class, idAlumno);
		Asignatura asignatura = session.get(Asignatura.class, idAsignatura);
		CursoEscolar cursoEscolar = session.get(CursoEscolar.class, idCursoEscolar);
		AlumnoSeMatriculaAsignatura nuevaMatricula = new AlumnoSeMatriculaAsignatura();
		AlumnoSeMatriculaAsignaturaId id = new AlumnoSeMatriculaAsignaturaId();
		id.setIdAlumno(idAlumno);
		id.setIdAsignatura(idAsignatura);
		id.setIdCursoEscolar(idCursoEscolar);
		nuevaMatricula.setId(id);
		session.persist(nuevaMatricula);
		tx1.commit();
		session.close();
	}
	
	
	//crear persona y asignarle asignatura
	public void addPersonaAsignatura() {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Date fechaActual = new Date();
		Persona persona = new Persona("21153608C","Aaron","Gonzalez","Alvarez","Sevilla","C/la mia","695211425",fechaActual,"H","alumno");
		session.persist(persona);
		//tx1.commit();
		
		//conseguir id persona
		String hql = "SELECT p from Persona p where p.nif = :nif";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("nif","21153608C");
		List<Object[]> results = query.list();
		Persona idPErsona = null;
	    for (Object[] resultado : results) {
	    	idPErsona = (Persona) resultado[0];
	        
	    }		
		AlumnoSeMatriculaAsignatura nueva = new AlumnoSeMatriculaAsignatura();
		AlumnoSeMatriculaAsignaturaId id = new AlumnoSeMatriculaAsignaturaId();
		id.setIdAlumno(idPErsona.getId());
		id.setIdAsignatura(24);
		id.setIdCursoEscolar(5);
		nueva.setId(id);
		persona.getAsignaturas().add(nueva);
		session.merge(persona);
		tx1.commit();
		session.close();
	}
	
	//buscar alumno y añadir asignatura
	public void addAsignaturaAlumno(int idAlumno) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		//tx1.commit();
		
		//conseguir id persona
		String hql = "SELECT p from Persona p where p.id = :id";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("id",idAlumno);
		List<Object[]> results = query.list();
		Persona alumno = null;
	    for (Object[] resultado : results) {
	    	alumno = (Persona) resultado[0];
	        
	    }
	    
	    Set<AlumnoSeMatriculaAsignatura> asignaturas = alumno.getAsignaturas();
	    AlumnoSeMatriculaAsignatura nueva = new AlumnoSeMatriculaAsignatura();
		AlumnoSeMatriculaAsignaturaId id = new AlumnoSeMatriculaAsignaturaId();
		id.setIdAlumno(alumno.getId());
		id.setIdAsignatura(28);
		id.setIdCursoEscolar(5);
		nueva.setId(id);	
		session.persist(nueva);
		asignaturas.add(nueva);
		session.merge(alumno);
		tx1.commit();
		session.close();
	}
	
	
	public void borrarAsignaturaAlumno(int idAlumno,int idAsignatura, int idCursoEscolar) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		//tx1.commit();
		
		//conseguir id persona
		String hql = "SELECT p from Persona p where p.id = :id";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("id",idAlumno);
		List<Object[]> results = query.list();
		Persona alumno = null;
	    for (Object[] resultado : results) {
	    	alumno = (Persona) resultado[0];
	        
	    }
	    
	    Set<AlumnoSeMatriculaAsignatura> asignaturas = alumno.getAsignaturas();
	    
	    for(AlumnoSeMatriculaAsignatura x: asignaturas) {
	    	if(x.getId().getIdAsignatura() == idAsignatura && x.getId().getIdCursoEscolar() == idCursoEscolar) {
	    		session.remove(x);
	    	}
	    }
		tx1.commit();
		session.close();	    
	}

	public void updateCretiosPorGrado(int idGrado) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		//conseguir id persona
		String hql = "SELECT g from Grado g where g.id = :id";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("id",idGrado);
		List<Object[]> results = query.list();
		Grado grado = null;
	    for (Object[] resultado : results) {
	    	grado = (Grado) resultado[0];
	        
	    }
	    
	    Set<Asignatura> asignaturas = grado.getAsignaturas();
	    
	    for(Asignatura x: asignaturas) {
	    	if(x.getCreditos() >5) {
	    		x.setCreditos(10);
	    		session.merge(x);
	    	}
	    }
		tx1.commit();
		session.close();
	}
	
	
	
}
