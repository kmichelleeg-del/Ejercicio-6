import java.awt.event.*;
import java.util.ArrayList;

public class DashboardController {
    private Dashboard modelo;
    private DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getBotonListar().addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evento) {
                        listar();
                    }
                }
        );

        vista.getBotonBuscar().addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evento) {
                        buscar();
                    }
                }
        );

        vista.getBotonOrdenar().addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evento) {
                        ordenar();
                    }
                }
        );
    }

    public void iniciar() {
        modelo.init();
        listar();
        vista.setVisible(true);
    }

    private void listar() {
        vista.mostrarWidgets(modelo.getWidgets());
    }

    private void buscar() {
        String consulta = vista.getBusqueda();

        ArrayList<Renderizable> encontrados =
                modelo.buscar(consulta);

        vista.mostrarWidgets(encontrados);

        if (encontrados.isEmpty() == true) {
            vista.mostrarMensaje("No se encontraron widgets.");
        }
    }

    private void ordenar() {
        modelo.ordenarPorMemoria();
        listar();
    }
}