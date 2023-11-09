package Cliente1;

import BaseDatos.Arco;
import BaseDatos.BaseRemota;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    
    public static void main(String[] args){
        try {
            Registry registro = LocateRegistry.getRegistry("localhost",1099);
            BaseRemota ir = (BaseRemota)registro.lookup("BaseRemota");
            
//            String a = "rmi://localhost:1099/ServidorRemoto";
//            BaseRemota ir = (BaseRemota)registry.lookup("BaseRemota");
            
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Indique qué operación desea realizar:");
            System.out.println("1. Presentar Saga");
            System.out.println("2. Mínimo de Capítulos en una Saga");
            System.out.println("3. Información del Arco");
            System.out.println("4. Posición del Arco en el tiempo");
            System.out.println("5. Salir");
            
            String op = scanner.nextLine();
            int operacion = Integer.parseInt(op);
            
            switch (operacion) {
                case 1:
                    System.out.println("Introduzca el nombre de la Saga: ");
                    String Nombre = scanner.nextLine();
                    String[] resultado = ir.presentarSaga(Nombre);//resultado es el array de titulos 
                    if(resultado != null ){
                        System.out.println("Los arcos de la saga son: ");
                        for (int i = 0; i < resultado.length; i++) {
                            String arco1 = resultado[i];
                         System.out.println(arco1 + " ");
                         i++;
                        }
                    }
                    if(resultado == null ){
                        System.out.println("No se han encontrado arcos de dicha saga "); 
                    }
                     else {
                    }
                break;
                    
                case 2:
                    System.out.println("Introduzca el nombre de la Saga y el minimo de capitulos deseados: ");
                    String nombreSaga = scanner.nextLine();
                    int capitulos = scanner.nextInt();
                    String[] resultado2 = ir.minCapitulos(nombreSaga, capitulos); //resultado es el array de titulos con mas tantos capitulos
                    if(resultado2 == null){
                        System.out.println("No se han encontrado arcos que cumplan las condiciones "); 
                    } 
                    else if(resultado2 != null ){
                        System.out.println("Los arcos de la saga son: ");
                        for (int i = 0; i < resultado2.length; i++) {
                            String arco1 = resultado2[i];
                         System.out.println(arco1 + " ");
                         i++;
                        }
                    }
                break;
                
                case 3:
                    System.out.println("Introduzca el nombre del Arco a presentar: ");
                    String nombreArco = scanner.nextLine();
                    ArrayList<Arco> arcoP;
                    arcoP = new ArrayList<Arco>();
                    arcoP = ir.infoArco(nombreArco); //resultado es el objeto arco
                    Arco arcoI = arcoP.get(0);
                    if(arcoI == null ){
                        System.out.println("No se ha encontrado el Arco "); 
                    } 
                    else if(arcoI != null ){
                        System.out.println("El arco se titula " + arcoI.getTitulo() +" , cuanta con un total de " + arcoI.getnCapitulos() + " capitulos, pertenece a la saga de " + arcoI.getSaga() + " , fue el " +arcoI.getOrden() + "º en ser emitido y ademas es considerado ");
                        if(arcoI.isRelleno() == true) {
                            System.out.println("canonico dentro del grupo de arcos.");
                        }
                        else if(arcoI.isRelleno() == false){
                            System.out.println(" no canonico dentro del grupo de arcos.");
                        }
                            break;
                        } else {
                        }
                case 4:
                    System.out.println("Introduzca la posición: ");
                    int nOrden = scanner.nextInt();
                    String[] resultado3 = ir.puestoArco(nOrden); //resultado es el array de titulos con mas tantos capitulos
                    if(resultado3 == null ){
                        System.out.println("No se han encontrado arcos que cumplan las condiciones"); 
                    } 
                    else if(resultado3 != null ){
                        String arcoPosicion = resultado3[0];
                        System.out.println("El arco en la posición " + nOrden + " es " + arcoPosicion);
                    }
                break;
                
                case 5:
                        System.out.println("Saliendo del menú.");
                        System.out.print(" \n");
                        break;

                    default:
                        System.out.println("Opción no válida. Elija una opción válida.");
                        System.out.print(" \n");
                        break;
            }
        } catch (Exception ex){System.out.println(ex.toString());}
    }
}