
package BaseDatos;
import java.io.Serializable;

public class Arco implements Serializable {
 private int nCapitulos;
 private String Titulo;
 private boolean Relleno;
 private String Saga;
 private int Orden;

 public Arco(int nCapitulos, String Titulo, boolean Relleno, String Saga, int Orden) {
    this.nCapitulos = nCapitulos;
    this.Titulo = Titulo;
    this.Relleno = Relleno;
    this.Saga = Saga;
    this.Orden = Orden;
 }

    public int getnCapitulos() {
        return nCapitulos;
    }
    
    public String getTitulo() {
        return Titulo;
    }
    
    public boolean isRelleno() {
        return Relleno;
    }

    public String getSaga() {
        return Saga;
    }

    public int getOrden() {
        return Orden;
    }
}
