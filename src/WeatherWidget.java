import javax.swing.*;
import java.awt.event.*;

public class WeatherWidget implements Renderizable, Interactivo {
    private String id;
    private String nombre;
    private int memoria;
    private String ciudad;
    private double temperaturaCelsius;
    private boolean mostrarCelsius;

    public WeatherWidget(String id, String nombre, int memoria,
                         String ciudad, double temperaturaCelsius) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.ciudad = ciudad;
        this.temperaturaCelsius = temperaturaCelsius;
        this.mostrarCelsius = true;
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
        if (mostrarCelsius == true) {
            return ciudad + ": " + temperaturaCelsius + " °C";
        } else {
            double fahrenheit = temperaturaCelsius * 9.0 / 5.0 + 32;
            return ciudad + ": " + fahrenheit + " °F";
        }
    }

    public String interactuar() {
        if (mostrarCelsius == true) {
            mostrarCelsius = false;
        } else {
            mostrarCelsius = true;
        }

        return renderizar();
    }

    public JComponent obtenerVista() {
        JPanel panel = new JPanel();
        JLabel texto = new JLabel(renderizar());
        JButton boton = new JButton("Cambiar unidad");

        panel.setBorder(BorderFactory.createTitledBorder(nombre));

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                interactuar();
                texto.setText(renderizar());
            }
        });

        panel.add(texto);
        panel.add(boton);

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