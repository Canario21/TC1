
package BaseDatos;
    import java.rmi.Remote;
    import java.rmi.RemoteException;
    import java.util.ArrayList;

public interface BaseRemota extends Remote{
    public String[] presentarSaga (String Nombre) throws RemoteException;
    public String[] minCapitulos (String nombreSaga, int capitulos) throws RemoteException;
    public ArrayList<Arco> infoArco (String nombreArco) throws RemoteException;
    public String[] puestoArco (int nOrden) throws RemoteException;

}
