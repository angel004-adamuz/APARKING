import java.util.Scanner;

public class Main implements Observer {
    private static ParkingManager parking;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        parking = new ParkingManager(10); // Establecemos que hay 10 plazas en el aparcamiento

        // Nos suscribimos para recibir notificaciones
        Main main = new Main();
        parking.addObserver(main);

        int opcion;
        do {
            System.out.println("\n--- Menú del Parking ---");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Mostrar plazas libres");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    parking.registrarEntrada();
                    break;
                case 2:
                    parking.registrarSalida();
                    break;
                case 3:
                    // Mostrar las plazas libres
                    System.out.println("Plazas libres: " + parking.getPlazasLibres());
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Implementación del método update() de la interfaz Observer
    @Override
    public void update(int plazasLibres) {
        System.out.println("El aparcamiento ha sido actualizado. Quedan " + plazasLibres + " plazas libres.");
    }
}
