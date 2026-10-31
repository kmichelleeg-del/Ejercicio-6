import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class DashboardView extends JFrame {
    private JPanel contenedor;
    private JTextField busqueda;
    private JButton botonListar;
    private JButton botonBuscar;
    private JButton botonOrdenar;

    public DashboardView() {
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel barra = new JPanel();

        JLabel titulo = new JLabel("Mis widgets");
        JLabel indicacion = new JLabel("ID o nombre:");
        busqueda = new JTextField(15);

        botonListar = new JButton("Listar todos");
        botonBuscar = new JButton("Buscar");
        botonOrdenar = new JButton("Ordenar por memoria");

        barra.add(titulo);
        barra.add(indicacion);
        barra.add(busqueda);
        barra.add(botonBuscar);
        barra.add(botonListar);
        barra.add(botonOrdenar);

        contenedor = new JPanel(new GridLayout(0, 2, 10, 10));

        JScrollPane desplazamiento =
                new JScrollPane(contenedor);

        add(barra, BorderLayout.NORTH);
        add(desplazamiento, BorderLayout.CENTER);

        setSize(1200, 720);
        setLocationRelativeTo(null);
    }

    public String getBusqueda() {
        return busqueda.getText();
    }

    public JButton getBotonListar() {
        return botonListar;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public JButton getBotonOrdenar() {
        return botonOrdenar;
    }

    public void mostrarWidgets(ArrayList<Renderizable> widgets) {
        contenedor.removeAll();

        int posicion = 0;

        while (posicion < widgets.size()) {
            Renderizable actual = widgets.get(posicion);

            contenedor.add(actual.obtenerVista());

            posicion = posicion + 1;
        }

        contenedor.revalidate();
        contenedor.repaint();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}