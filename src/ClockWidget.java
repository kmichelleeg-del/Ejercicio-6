import javax.swing.*;
import java.time.LocalTime;
import java.awt.event.*;

public class ClockWidget implements Renderizable {
    private String id;
    private String nombre;
    private int memoria;

    public ClockWidget(String id, String nombre, int memoria) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMemoria() {
        return memoria;
    }

    public String renderizar() {
        LocalTime hora = LocalTime.now();

        return hora.getHour() + ":"
                + hora.getMinute() + ":" + hora.getSecond();
    }

    public JComponent obtenerVista() {
        JPanel panel = new JPanel();
        JLabel texto = new JLabel(renderizar());

        panel.setBorder(BorderFactory.createTitledBorder(nombre));
        panel.add(texto);

        Timer temporizador = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                texto.setText(renderizar());
            }
        });

        temporizador.start();

        return panel;
    }

    public int compareTo(Renderizable otro) {
        if (getMemoria() < otro.getMemoria()) {
            return -1;
        } else if (getMemoria() > otro.getMemoria()) {
            return 1;
        } else {
            return 0;
        }
    }
}