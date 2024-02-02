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
    	

    	
    	//ejercicio4
//    	Asignatura a = new Asignatura("Prueba 33", 4, "TipoPrueba",2,1);
//    	service.addAsignatura(4, a,5);
    	
    	//ejercicio5
    	service.updateTelefonoProfesor(3, "999999999");
    	
    	//ejercicio7
    	service.deleteGrado(7);
    }
}
