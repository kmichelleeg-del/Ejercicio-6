import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class TaskWidget implements Renderizable, Interactivo {
    private String id;
    private String nombre;
    private int memoria;
    private String[] tareas;
    private boolean[] completadas;

    public TaskWidget(String id, String nombre, int memoria,
                      String[] tareas) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.tareas = tareas;
        this.completadas = new boolean[tareas.length];
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
        String resultado = "";
        int posicion = 0;

        while (posicion < tareas.length) {
            if (posicion > 0) {
                resultado = resultado + " | ";
            }

            if (completadas[posicion] == true) {
                resultado = resultado + "[X] " + tareas[posicion];
            } else {
                resultado = resultado + "[ ] " + tareas[posicion];
            }

            posicion = posicion + 1;
        }

        return resultado;
    }

    public String interactuar() {
        int posicion = 0;

        while (posicion < tareas.length) {
            if (completadas[posicion] == false) {
                completadas[posicion] = true;
                return "Tarea completada: " + tareas[posicion];
            }

            posicion = posicion + 1;
        }

        return "Todas las tareas están completadas.";
    }

    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel texto = new JLabel(renderizar());
        JLabel mensaje = new JLabel(" ");
        JButton boton = new JButton("Completar tarea");

        panel.setBorder(BorderFactory.createTitledBorder(nombre));

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                mensaje.setText(interactuar());
                texto.setText(renderizar());
            }
        });

        panel.add(texto);
        panel.add(boton);
        panel.add(mensaje);

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
