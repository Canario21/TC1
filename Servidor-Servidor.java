package Servidor1;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
        public static void main(String[] args) {
            try {
                   Registry registry = LocateRegistry.createRegistry(1099);
                   ServidorRemoto miServidor = new ServidorRemoto();
                   registry.rebind("Servidor", miServidor);
                   System.out.println("Servidor online");                   
               }catch(Exception ex){
                   System.out.println("Error Servidor: "+ ex.toString());
               }
           }
    }
