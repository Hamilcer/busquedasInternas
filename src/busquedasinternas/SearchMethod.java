
import java.util.Scanner;

public abstract class SearchMethod {

    protected int[] arr;
    protected int size;
    protected int numberOfElements;
    protected Scanner scanner = new Scanner(System.in);

    public void inputElementsManually() {
        System.out.println("Ingresa el tamaño del arreglo:");
        size = scanner.nextInt();
        arr = new int[size];
        System.out.println("¿Cuántos elementos deseas ingresar?");
        numberOfElements = scanner.nextInt();
        inputElements(numberOfElements);
    }

    public void inputElements(int numberOfElements) {
        System.out.println("Ingresa los elementos:");

        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Elemento " + (i + 1) + ":");
            int input = scanner.nextInt();

            while (input < 1000 || input > 9999) {
                System.out.println("Por favor, ingresa un número de 4 cifras:");
                input = scanner.nextInt();
            }

            insertElement(input, i);  // Usa el método insertElement
        }
    }

    protected void insertElement(int value, int pos) {
        arr[pos] = value;  // Inserta de manera secuencial
    }

    protected int handleCollision(int index, int key) {
        System.out.println("Colisión detectada en índice " + index + ". Ingresa un nuevo número:");
        int newInput = scanner.nextInt();
        while (newInput < 1000 || newInput > 9999) {
            System.out.println("Por favor, ingresa un número de 4 cifras:");
            newInput = scanner.nextInt();
        }
        return newInput;
    }

    protected int hashFunction(int key) {
        return key;
    }

    public abstract void performSearch();

    public abstract void showArray();
}
