
import java.util.Scanner;

public class Mainapp {
    public static void main(String[] args) {
        
        
        DatosDAO da = new DatosDAO();
        Scanner leer = new Scanner(System.in);
        
        
        
        int sw = 0;
        int opcion;
        String nombres;
        String apellidos;
        String fecha;
        String correo_ins;
        String correo_per;
        long num_fijo;
        long num_cel;
        String programa;
        
        
        
        do{
            System.out.println("INSTITUTO LA FLORESTA\n"
                    + "Seleccione tarea a realizar:\n"
                    + "1. Ingresar estudiante\n"
                    + "2. Buscar estudiante\n"
                    + "3. Modificar estudiante\n"
                    + "4. Eliminar estudiante\n"
                    + "5. Ver directorio de estudiantes\n"
                    + "6. Salir\n"
                    + "Opción:\n");
            opcion = leer.nextInt();
            leer.nextLine();
            
            
            
            if(sw == 0){
                da.comprobarFile();
                sw = 1;
            }
            
            
            
            switch(opcion){
                
                
                case 1:
                    System.out.println("Ingresar estudiante\n"
                            + "Ingresar nombres:\n");
                    nombres = leer.nextLine();
                    System.out.println("Ingresar apellidos:\n");
                    apellidos = leer.nextLine();
                    System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
                    fecha = leer.nextLine();
                    System.out.println("Ingresar correo institucional:\n");
                    correo_ins = leer.nextLine();
                    System.out.println("Ingresar correo personal:\n");
                    correo_per = leer.nextLine();
                    System.out.println("Ingresar número de celular:\n");
                    num_cel = leer.nextLong();
                    System.out.println("Ingresar número fijo:\n");
                    num_fijo = leer.nextLong();
                    leer.nextLine();
                    System.out.println("Ingresar programa:\n");
                    programa = leer.nextLine();
                    da.ingresarEstudiante(nombres, apellidos, fecha, correo_ins, correo_per, num_fijo, num_cel, programa);
                    break;
                    
                    
                case 2:
                    System.out.println("Buscar estudiante\n"
                            + "Ingresar correo institucional:\n");
                    correo_ins = leer.nextLine();
                    da.buscarEstudiante(correo_ins);
                    break;
                    
                    
                case 3:
                    System.out.println("Modificar estudiante\n"
                            + "Ingresar correo institucional:\n");
                    correo_ins = leer.nextLine();
                    System.out.println("Ingresar correo personal:\n");
                    correo_per = leer.nextLine();
                    System.out.println("Ingresar número de celular:\n");
                    num_cel = leer.nextLong();
                    System.out.println("Ingresar número fijo:");
                    num_fijo = leer.nextLong();
                    leer.nextLine();
                    System.out.println("Ingresar programa:");
                    programa = leer.nextLine();
                    da.modificarEstudiante(correo_ins, correo_per, num_fijo, num_cel, programa);
                    break;
                    
                    
                case 4:
                    System.out.println("Eliminar estudiante\n"
                            + "Ingresar correo institucional:\n");
                    correo_ins = leer.nextLine();
                    da.eliminarEstudiante(correo_ins);
                    break;
                case 5:
                    
                    
                    System.out.println("El directorio de los estudiantes:\n");
                    da.listaEstudiantes();
                    break;
                    
                    
                case 6:
                    da.escribirFile();
                    System.out.println("Hasta pronto");
                    break;
                    
                    
                default:
                    System.out.println("Error: opción no valida");
            }
            
            
        }while(opcion!=6);
    }
}