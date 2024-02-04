package Universidad.Trabajo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.AlumnoSeMatriculaAsignatura;
import hibernate.AlumnoSeMatriculaAsignaturaId;
import hibernate.Asignatura;
import hibernate.CursoEscolar;
import hibernate.Departamento;
import hibernate.Grado;
import hibernate.Persona;
import hibernate.Profesor;

public class Hibernateconexion {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();

				addClasses(configuration); // Cambia en cada proyecto

				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());

			} catch (Exception e) {
				System.out.println("Error" + e);
			}
		}
		return sessionFactory;
	}

	private static void addClasses(Configuration configuration) {
		configuration.addClass(Persona.class);
		configuration.addClass(Profesor.class);
		configuration.addClass(Departamento.class);
		configuration.addClass(Asignatura.class);
		configuration.addClass(Grado.class);
		configuration.addClass(CursoEscolar.class);
		configuration.addClass(AlumnoSeMatriculaAsignatura.class);
	}
}