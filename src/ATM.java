import java.util.Scanner;

public class ATM {
    private Calculator calculator = new Calculator();
    private Main main = new Main();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Bienvenido a JavaBank ATM.");
            System.out.println("Seleccione una operación:");
            System.out.println("1. Realizar una transacción");
            System.out.println("2. Usar la calculadora");
            System.out.println("0. Salir");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    main.mainMenu();
                    break;
                case 2:
                    calculator.start();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Selección no válida.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
