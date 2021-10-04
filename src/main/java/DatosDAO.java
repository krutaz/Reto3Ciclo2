
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DatosDAO {
    
    File flEstu = new File("datos_estudiantes.dat");
    
    
    
    ArrayList<Datos> alumnos;
    
    
    
    public DatosDAO(){
        alumnos = new ArrayList<Datos>();
    }
    
    
    
    public void comprobarFile(){
        try{
            if(!flEstu.exists()){
                flEstu.createNewFile();
            }else{
                this.leerFile();
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    
    public void leerFile(){
        try{
            ObjectInputStream leerFile = new ObjectInputStream(new FileInputStream("datos_estudiantes.dat"));
            alumnos =(ArrayList<Datos>) leerFile.readObject();
            leerFile.close();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    
    public void escribirFile(){
        try{
            ObjectOutputStream escribirFile = new ObjectOutputStream(new FileOutputStream("datos_estudiantes.dat"));
            escribirFile.writeObject(alumnos);
            escribirFile.close();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    
    public void ingresarEstudiante(String nombres, String apellidos, String fecha, String correo_ins, String correo_per, long num_fijo, long num_cel, String programa){
        try{
            Datos d = new Datos();
            d.setNombres(nombres);
            d.setApellidos(apellidos);
            d.setFecha(fecha);
            d.setCorreo_ins(correo_ins);
            d.setCorreo_per(correo_per);
            d.setNum_cel(num_cel);
            d.setNum_fijo(num_fijo);
            d.setPrograma(programa);
            alumnos.add(d);
            System.out.println("Se agregó el estudiante\n");
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    
    public void buscarEstudiante(String correo_ins){
        Iterator<Datos> it = alumnos.iterator();
        while(it.hasNext()){
            Datos da = it.next();
            if(da.getCorreo_ins().equals(correo_ins)){
                System.out.println("Información del estudiante\n"
                        + "Nombres: " + da.getNombres() + "\n"
                        + "Apellidos: " + da.getApellidos() + "\n"
                        + "Fecha nacimiento: " + da.getFecha() + "\n"
                        + "Correo institucional: " + da.getCorreo_ins() + "\n"
                        + "Correo personal: " + da.getCorreo_per() + "\n"
                        + "Número de teléfono celular: " + da.getNum_cel() + "\n"
                        + "Número de teléfono fijo: " + da.getNum_fijo() + "\n"
                        + "Programa académico: " + da.getPrograma() + "\n");
            }
        }
    }
    
    
    
    public void modificarEstudiante(String correo_ins, String correo_per, long num_fijo, long num_cel, String programa){
        try{
            Iterator<Datos> it = alumnos.iterator();
            while(it.hasNext()){
                Datos da = it.next();
                if(da.getCorreo_ins().equals(correo_ins)){
                    da.setCorreo_per(correo_per);
                    da.setNum_cel(num_cel);
                    da.setNum_fijo(num_fijo);
                    da.setPrograma(programa);
                    System.out.println("Se modificó el estudiante\n");
                }
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    
    public void eliminarEstudiante(String correo_ins){
        Iterator<Datos> it = alumnos.iterator();
        while(it.hasNext()){
            Datos da = it.next();
            if(da.getCorreo_ins().equals(correo_ins)){
                it.remove();
                System.out.println("Se eliminó el estudiante\n");
            }
        }    
    }
    
    
    
    public void listaEstudiantes(){
        for(Datos da:alumnos){
            System.out.println("Nombres: " + da.getNombres() + "\n"
                    + "Apellidos: " + da.getApellidos() + "\n"
                    + "Fecha nacimiento: " + da.getFecha() + "\n"
                    + "Correo institucional: " + da.getCorreo_ins() + "\n"
                    + "Correo personal: " + da.getCorreo_per() + "\n"
                    + "Número de teléfono celular: " + da.getNum_cel() + "\n"
                    + "Número de teléfono fijo: " + da.getNum_fijo() + "\n"
                    + "Programa académico: " + da.getPrograma() + "\n");
        }
    }
}