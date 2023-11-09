package Servidor1;
import BaseDatos.Arco;
import BaseDatos.BaseRemota;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ServidorRemoto extends UnicastRemoteObject implements BaseRemota {
    private ArrayList<Arco> ListaArcos;
    
    public ServidorRemoto() throws RemoteException{
        ListaArcos = new ArrayList<Arco>();
        iniciar();
    }
    
     // Iniciar el arrayList<ListaArcos> y lo rellena con diferentes objetos Arco
     
    public void iniciar(){
        ListaArcos.add(new Arco(4, "Romance Dawn", true, "East Blue",1));
        ListaArcos.add(new Arco(4, "Orange Town", true, "East Blue", 2));
        ListaArcos.add(new Arco(9, "Ciudad Jarabe", true, "East Blue", 3));
        ListaArcos.add(new Arco(11, "Baratie", true, "East Blue", 4));
        ListaArcos.add(new Arco(13, "Arlong Park", true, "East Blue", 5));
        ListaArcos.add(new Arco(9, "Loguetown", true, "East Blue", 6));
        ListaArcos.add(new Arco(7, "Millenary Dragon", false, "East Blue", 7));
        ListaArcos.add(new Arco(2, "Reverse Mountain", true, "Arabasta", 8));
        ListaArcos.add(new Arco(4, "Whiskey Peak", true, "Arabasta", 9));
        ListaArcos.add(new Arco(2, "Coby y Helmeppo", true, "Arabasta", 10));
        ListaArcos.add(new Arco(8, "Little Garden", true, "Arabasta", 11));
        ListaArcos.add(new Arco(14, "Isla de Drum", true, "Arabasta", 12));
        ListaArcos.add(new Arco(38, "Arabasta", true, "Arabasta", 13));
        ListaArcos.add(new Arco(5, "Post-Arabasta", false, "Arabasta", 14));
        ListaArcos.add(new Arco(3, "Isla de los Cordeos", false, "Skypea", 15));
        ListaArcos.add(new Arco(5, "Niebla Arcoiris", false, "Skypea", 16));
        ListaArcos.add(new Arco(8, "Jaya", true, "Skypea", 17));
        ListaArcos.add(new Arco(42, "Skypea", true, "Skypea", 18));
        ListaArcos.add(new Arco(10, "G-8", false, "Skypea", 19));
        ListaArcos.add(new Arco(13, "Long Ring Long Land", false, "Water 7", 20));
        ListaArcos.add(new Arco(5, "Dream of the Ocean", false, "Water 7", 21));
        ListaArcos.add(new Arco(2, "Foxy Return", false, "Water 7", 22));
        ListaArcos.add(new Arco(39, "Water 7", true, "Water 7", 23));
        ListaArcos.add(new Arco(47, "Ennies Lobbies", true, "Water 7", 24));
        ListaArcos.add(new Arco(13, "Post-Ennies Lobbies", true, "Water 7", 25));
        ListaArcos.add(new Arco(11, "Adorable Earth", false, "Thriller Bark", 26));
        ListaArcos.add(new Arco(45, "Thriller Bark", true, "Thriller Bark", 27));
        ListaArcos.add(new Arco(3, "Isla Spa", false, "Thriller Bark", 28));
        ListaArcos.add(new Arco(23, "Archipiélago Sabaody", true, "MarineFord", 29));
        ListaArcos.add(new Arco(4, "Impel Down", true, "MarineFord", 30));
        ListaArcos.add(new Arco(4, "Blue Small-East", false, "MarineFord", 31));
        ListaArcos.add(new Arco(27, "Impel Down-Continuacion", true, "MarineFord", 32));
        ListaArcos.add(new Arco(33, "MarineFord", true, "MarineFord", 33));
        ListaArcos.add(new Arco(27, "Post-MarineFord", true, "MarineFord", 34));     
    }
  
   
    /*
    El método presentarSaga se emplea para obtener los arcos que pertenezcan a
    una saga seleccionada por el usuario. Para hacerlo recorrerá el Arraylist
    comprobando si el parámetro “Nombre”, coincide con el atributo “Saga” de los
    objetos “Arco” que se almacenan en el ArrayList; cuando encuentre una
    coincidencia ira almacenando el valor de su atributo “Titulo” en un array de tipo
    String; cuando llegue al final del ArrayList, devolverá los valores almacenados
    */
    
    @Override
    public String[] presentarSaga (String Nombre) throws java.rmi.RemoteException{
        Nombre = null;
        int b = 0;
        String[]  arcosSaga = new String[b];
        for (int i = 0; i < ListaArcos.size(); i++) {
            Arco objeto = ListaArcos.get(i);
            if (objeto.getSaga().equals(Nombre)) {
                arcosSaga[b] = objeto.getTitulo();
                b++;
            }
        }
        return arcosSaga;
    }
    
    /*
    minCapitulos, el método busca que arcos tienen más capítulos que una cantidad
    determinada dentro de una saga concreta. El método se encarga de buscar que
    arcos tienen más capítulos de los indicados dentro de una saga concreta. Para
    ello, recorrerá el Arraylist comprobando si el parámetro “nombreSaga”, coincide
    con el atributo “Saga” de los objetos “Arco” que se almacenan en el ArrayList.
    Una vez lo encuentre comprobará el parámetro “capitulos” y lo comparará con
    el atributo “nCapitulos”. Si el parámetro es mayor al atributo; se almacenará el
    valor del parámetro “titulo” en un array de strings; que devolverá cuando se
    termine de recorrer el arraylist.
    */
    
    @Override
    public String[] minCapitulos (String nombreSaga, int capitulos) throws java.rmi.RemoteException{
        int b = 0;
        String[]  arcosSaga = new String[b];
        for (int i = 0; i < ListaArcos.size(); i++) {
            Arco objeto = ListaArcos.get(i);
            if (objeto.getSaga().equals(nombreSaga) && objeto.getnCapitulos()>= capitulos) {
                arcosSaga[b] = objeto.getTitulo();
                b++;
            }
        }
        return arcosSaga;
    }
    
    /*
    infoArco, este método, devolverá la información completa de un arco. Recorrerá
    el arraylist buscando una coincidencia entre el parámetro “nombreArco” y el
    atributo Titulo de los objetos “Arco”, almacenados en el ArrayList. Al encontrarlo
    devolverá un arrayList que contiene el objeto.
    */
    @Override
    public ArrayList<Arco> infoArco (String nombreArco) throws java.rmi.RemoteException{
        ArrayList<Arco> miArco = new ArrayList<>();;
        for (int i = 0; i < ListaArcos.size(); i++) {
            Arco objeto = ListaArcos.get(i);
            if (objeto.getTitulo().equals(nombreArco)) {
                miArco.add(objeto);
            }
        }
        return miArco;
    }
    
    /*
    puestoArco, el método devuelve el nombre del arco en una posición de un listado
    cronológico. El método recorre el ArrayList y comprueba el parámetro “nOrden”
    y lo compara con el atributo “Orden”. Cuando encuentre un arco cuyo atributo
    orden coincida con el parámetro, devolverá el valor de su atributo “Titulo”.
    */
    @Override
    public String[] puestoArco (int nOrden) throws java.rmi.RemoteException{
        String[]  ArcoEnX = null;
        for (int i = 0; i < ListaArcos.size(); i++) {
            Arco objeto = ListaArcos.get(i);
            if (nOrden == objeto.getOrden()) {
                ArcoEnX[0]= objeto.getTitulo();
            }
        }
        return ArcoEnX; 
    }
}
