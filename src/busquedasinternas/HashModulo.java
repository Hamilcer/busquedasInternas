
public class HashModulo extends SearchMethod {

    private int moduloRange;

    public HashModulo() {
        System.out.println("Ingresa el rango para la función hash modulo:");
        moduloRange = scanner.nextInt();

        inputElementsManually();
    }

    @Override
    protected void insertElement(int value, int pos) {
        int hashedIndex = hashFunction(value);
        System.out.println("Hash para " + value + ": " + hashedIndex);  // Muestra el hash
        while (arr[hashedIndex] != 0) {  // Si ya hay un valor en la posición (colisión)
            value = handleCollision(hashedIndex, value);
            hashedIndex = hashFunction(value);
        }
        arr[hashedIndex] = value;
    }

    @Override
    protected int hashFunction(int key) {
        return (key % moduloRange) + 1;
    }

    @Override
    public void performSearch() {
        char repeatSearch;
        do {
            showArray();
            System.out.println("Ingresa el elemento a buscar:");
            int key = scanner.nextInt();

            int hashedIndex = hashFunction(key);
            if (hashedIndex >= size) {
                System.out.println("Índice fuera de rango. El rango proporcionado no es adecuado para el tamaño del arreglo.");
            } else if (arr[hashedIndex] == key) {
                System.out.println("Elemento " + key + " encontrado en el índice " + hashedIndex);
            } else {
                System.out.println("Elemento " + key + " no encontrado en el arreglo.");
            }

            System.out.println("¿Deseas realizar otra búsqueda con el mismo arreglo? (S para sí, N para no)");
            repeatSearch = scanner.next().charAt(0);
        } while (Character.toUpperCase(repeatSearch) == 'S');
    }

    @Override
    public void showArray() {
        System.out.println("Arreglo:");
        for (int num : arr) {
            if (num == 0) {
                System.out.print("- ");
            } else {
                System.out.print(num + " ");
            }
        }
        System.out.println("\n");
    }
}
