import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {
    private ArrayList<Renderizable> widgets;

    public Dashboard() {
        widgets = new ArrayList<Renderizable>();
    }

    public void init() {
        widgets.clear();

        widgets.add(new WeatherWidget(
                "W1", "Clima Guatemala", 120, "Guatemala", 24));

        widgets.add(new WeatherWidget(
                "W2", "Clima Antigua", 110, "Antigua", 22));

        String[] tareas1 = {"Estudiar", "Entregar ejercicio"};
        String[] tareas2 = {"Leer", "Ordenar cuarto"};

        widgets.add(new TaskWidget(
                "T1", "Universidad", 200, tareas1));

        widgets.add(new TaskWidget(
                "T2", "Personal", 150, tareas2));

        widgets.add(new AlertWidget(
                "A1", "Entrega", 80, "Entregar ejercicio", "Alta"));

        widgets.add(new AlertWidget(
                "A2", "Parcial", 70, "Parcial mañana", "Media"));

        widgets.add(new ClockWidget(
                "C1", "Reloj principal", 60));

        widgets.add(new ClockWidget(
                "C2", "Reloj secundario", 60));

        widgets.add(new QuoteWidget(
                "Q1", "Frase del día", 30, "Cada paso cuenta."));

        widgets.add(new QuoteWidget(
                "Q2", "Frase de estudio", 35, "Seguí aprendiendo."));
    }

    public ArrayList<Renderizable> getWidgets() {
        return widgets;
    }

    public String interactuar(String id) {
        int posicion = 0;

        while (posicion < widgets.size()) {
            Renderizable actual = widgets.get(posicion);

            if (actual.getId().equals(id)) {
                if (actual instanceof Interactivo) {
                    Interactivo interactivo = (Interactivo) actual;
                    return interactivo.interactuar();
                } else {
                    return "Este widget solo muestra información.";
                }
            }

            posicion = posicion + 1;
        }

        return "No se encontró el widget.";
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }

    public ArrayList<Renderizable> buscar(String consulta) {
    ArrayList<Renderizable> encontrados =
            new ArrayList<Renderizable>();

    String texto = consulta.trim().toLowerCase();
    int posicion = 0;

    while (posicion < widgets.size()) {
        Renderizable actual = widgets.get(posicion);

        boolean coincideId =
                actual.getId().equalsIgnoreCase(texto);

        boolean coincideNombre =
                actual.getNombre().toLowerCase().contains(texto);

        if (coincideId == true || coincideNombre == true) {
            encontrados.add(actual);
        }

        posicion = posicion + 1;
    }

    return encontrados;
}
}