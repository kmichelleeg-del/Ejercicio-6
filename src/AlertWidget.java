import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class AlertWidget implements Renderizable, Interactivo {
    private String id;
    private String nombre;
    private int memoria;
    private String mensaje;
    private String prioridad;
    private boolean leida;

    public AlertWidget(String id, String nombre, int memoria,
                       String mensaje, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leida = false;
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
        String estado;

        if (leida == true) {
            estado = "Leída";
        } else {
            estado = "Pendiente";
        }

        return mensaje + " | Prioridad: " + prioridad
                + " | Estado: " + estado;
    }

    public String interactuar() {
        if (leida == true) {
            return "La alerta ya estaba leída.";
        } else {
            leida = true;
            return "La alerta se marcó como leída.";
        }
    }

    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel texto = new JLabel(renderizar());
        JLabel resultado = new JLabel(" ");
        JButton boton = new JButton("Marcar como leída");

        panel.setBorder(BorderFactory.createTitledBorder(nombre));

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                resultado.setText(interactuar());
                texto.setText(renderizar());
            }
        });

        panel.add(texto);
        panel.add(boton);
        panel.add(resultado);

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