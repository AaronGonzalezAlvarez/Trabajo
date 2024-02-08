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
    	

    	//ejercicio 1
    	//grado
    	service.mostrarGrados();
    	//curso_escola
    	service.mostrarCursoEscolar();
//    	asignatura
    	service.mostraAsginaturas();
//    	profesor
    	service.mostraProfesor();    	
//    	departamento
    	service.mostraDepartamento();  
//    	persona
    	service.mostraPeople();  
//    	alumno_asignatura
    	service.mostraPeopleAsignatura();
    	
    	//ejercicio2
    	service.DatosPersonalesHQL();
    	service.TotalAsignarurasProfesor();
    	//ejercicio3
    	service.TotalAsignarurasProfesorSQL();
    	service.DatosPersonalesSQL();
    	
//    	//ejercicio4
    	Asignatura a = new Asignatura("Prueba 23", 4, "TipoPrueba",2,1);
    	service.addAsignatura(4, a,5);
   	
//    	//ejercicio5
    	service.updateTelefonoProfesor(3, "999999999");
    	
//    	//ejercicio7
    	service.deleteGrado(7);
    }
}
