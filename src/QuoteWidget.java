import javax.swing.*;

public class QuoteWidget implements Renderizable {
    private String id;
    private String nombre;
    private int memoria;
    private String frase;

    public QuoteWidget(String id, String nombre,
                       int memoria, String frase) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.frase = frase;
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
        return frase;
    }

    public JComponent obtenerVista() {
        JPanel panel = new JPanel();
        JLabel texto = new JLabel(renderizar());

        panel.setBorder(BorderFactory.createTitledBorder(nombre));
        panel.add(texto);

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