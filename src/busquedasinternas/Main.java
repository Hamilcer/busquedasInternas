import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Elige el método de búsqueda:");
            System.out.println("1. Búsqueda secuencial");
            System.out.println("2. Búsqueda binaria");
            System.out.println("3. Hash modulo");
            System.out.println("4. Hash cuadrado");
            System.out.println("5. Hash truncamiento");
            System.out.println("6. Hash plegamiento");
            System.out.println("7. Salir");
            int choice = scanner.nextInt();

            SearchMethod searchMethod = null;
            switch (choice) {
                case 1:
                    searchMethod = new SequentialSearch();
                    break;
                case 2:
                    searchMethod = new BinarySearch();
                    break;
                case 3:
                    searchMethod = new HashModulo();
                    break;
                case 4:
                    searchMethod = new HashSquare();
                    break;
                case 5:
                    searchMethod = new HashTruncate();
                    break;
                case 6:
                    searchMethod = new HashFold();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            if (searchMethod != null) {
                searchMethod.performSearch();
            }
        }
    }
}
