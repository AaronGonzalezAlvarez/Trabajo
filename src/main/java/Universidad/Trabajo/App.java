package Universidad.Trabajo;

import dao.AsignaturaService;
import hibernate.Asignatura;
import hibernate.CursoEscolar;
import hibernate.Departamento;
import hibernate.Grado;
import hibernate.Persona;
import hibernate.Profesor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	var sf=Hibernateconexion.getSessionFactory();
    	
//    	var persona = sf.openSession().get(Persona.class, "1");
//    	System.out.println(persona);
    	
    	
//    	var profesor = sf.openSession().get(Profesor.class, "3");
//    	System.out.println(profesor);
    	
//    	var departamento = sf.openSession().get(Departamento.class, "2");
//    	System.out.println(departamento);
    	
//    	var asignatura = sf.openSession().get(Asignatura.class, "2");
//    	System.out.println(asignatura);
    	
//    	var grado = sf.openSession().get(Grado.class, "7");
//    	System.out.println(grado);
    	
//    	var cursoEscolar = sf.openSession().get(CursoEscolar.class, "1");
//    	System.out.println(cursoEscolar);
    	
    	AsignaturaService asignaturaServicio = new AsignaturaService();
    	Asignatura a = new Asignatura(300,"Prueba 33", 4, "TipoPrueba",2,1);
    	
    	asignaturaServicio.addAsignatura(4, a,3);
    }
}
