import javax.swing.JComponent;

public interface Renderizable extends Comparable<Renderizable> {
    String getId();
    String getNombre();
    int getMemoria();
    String renderizar();
    JComponent obtenerVista();
}
