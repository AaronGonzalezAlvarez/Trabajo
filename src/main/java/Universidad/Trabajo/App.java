package Universidad.Trabajo;

import dao.BaseDatosService;
import hibernate.Asignatura;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	var sf=Hibernateconexion.getSessionFactory();   
//    	var persona = sf.openSession().get(Persona.class, "1");
//    	System.out.println(persona);
    	BaseDatosService service = new BaseDatosService();
    	

    	
    	//service.DatosPersonalesHQL();
    	//service.TotalAsignarurasProfesor();
    	//service.TotalAsignarurasProfesorSQL();
    	//service.DatosPersonalesSQL();
    	
//    	//ejercicio4
//    	Asignatura a = new Asignatura("Prueba 33", 4, "TipoPrueba",2,1);
//    	service.addAsignatura(4, a,5);
//    	
//    	//ejercicio5
//    	service.updateTelefonoProfesor(3, "999999999");
//    	
//    	//ejercicio7
//    	service.deleteGrado(7);
    	
    	
    	

    	//añadir nuevo alumno a asignatura curso escolar
    	//service.addAlumnoMatriculaAsignatura(24, 20, 5);
    	//pruebas    	
    	//service.CantidadAsignaturasPorAlumno();
    	//service.totalAlumnosPorAsignatura();
    	//service.totalAlumnosPorAsignaturaEnConcreto("Física para informática");
    	//service.asignaturaQueDaCadaProfesor();
    	//service.asignaturaQueDaCadaProfesorPorIdProfesor(3);
    	//service.profesoresPorGenero("M");
    	//service.asignaturaQueDaCadaProfesorPorGenero("H");
    	//service.totalAsignaturaPorDepartamento();
    	//service.AsignaturaPorDepartamento();
    	//service.totalGeneroPorDepartamento();
    	//service.creditostotalesPorGrado();
    	//service.asignatiraGradoYProfesor();
    	//service.cursoEscolaYAlumnosPorCurso();
    	//service.asignaturasDeCadaPersona();
    	//service.getAlumnoProfesorAsignatura();

    	//
    	//service.addPersonaAsignatura();
    	
    	//service.addAsignaturaAlumno(34);
    	//service.borrarAsignaturaAlumno(34, 24, 5);
    	service.updateCretiosPorGrado(4);
    	
    }
}
