import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements Subject {

    private int totalPlazas;
    private int plazasOcupadas;
    private List<Observer> observers;

    public ParkingManager(int totalPlazas) {
        this.totalPlazas = totalPlazas;
        this.plazasOcupadas = 0;
        this.observers = new ArrayList<>();
    }

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
        int plazasLibres = totalPlazas - plazasOcupadas;
        for (Observer o : observers) {
            o.update(plazasLibres);
        }
    }

    public void registrarEntrada() {
        if (plazasOcupadas < totalPlazas) {
            plazasOcupadas++;
            System.out.println("Vehículo ha entrado.");
            notifyObservers();
        } else {
            System.out.println("Parking completo. No se puede entrar.");
        }
    }

    public void registrarSalida() {
        if (plazasOcupadas > 0) {
            plazasOcupadas--;
            System.out.println("Vehículo ha salido.");
            notifyObservers();
        } else {
            System.out.println("Parking vacío. No se puede salir.");
        }
    }
}