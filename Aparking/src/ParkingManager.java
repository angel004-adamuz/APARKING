import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements Subject {
    private int plazasTotales;
    private int plazasLibres;
    private List<Observer> observers;

    public ParkingManager(int plazasTotales) {
        this.plazasTotales = plazasTotales;
        this.plazasLibres = plazasTotales; // Al principio todas las plazas están libres
        this.observers = new ArrayList<>();
    }

    public void registrarEntrada() {
        if (plazasLibres > 0) {
            plazasLibres--;
            System.out.println("Entrada registrada. Quedan " + plazasLibres + " plazas libres.");
            notifyObservers();
        } else {
            System.out.println("No hay plazas libres para registrar la entrada.");
        }
    }

    public void registrarSalida() {
        if (plazasLibres < plazasTotales) {
            plazasLibres++;
            System.out.println("Salida registrada. Quedan " + plazasLibres + " plazas libres.");
            notifyObservers();
        } else {
            System.out.println("No hay vehículos en el aparcamiento.");
        }
    }

    // Métodos de la interfaz Subject
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(plazasLibres);
        }
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }
}
