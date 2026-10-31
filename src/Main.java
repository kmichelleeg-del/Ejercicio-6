import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Dashboard dashboard = new Dashboard();
                dashboard.init();

                JFrame ventana = new JFrame("Dashboard");
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.setLayout(new BorderLayout());

                JLabel titulo = new JLabel(
                        "Mis widgets", SwingConstants.CENTER
                );

                JPanel contenedor = new JPanel(
                        new GridLayout(0, 2, 10, 10)
                );

                int posicion = 0;

                while (posicion < dashboard.getWidgets().size()) {
                    Renderizable actual =
                            dashboard.getWidgets().get(posicion);

                    contenedor.add(actual.obtenerVista());

                    posicion = posicion + 1;
                }

                JScrollPane desplazamiento =
                        new JScrollPane(contenedor);

                ventana.add(titulo, BorderLayout.NORTH);
                ventana.add(desplazamiento, BorderLayout.CENTER);

                ventana.setSize(1100, 720);
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });
    }
}