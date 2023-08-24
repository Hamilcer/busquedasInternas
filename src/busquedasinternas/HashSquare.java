public class HashSquare extends SearchMethod {
    
    public HashSquare() {
        inputElementsManually();
    }

    private int extractMiddleDigits(int num) {
        String numStr = String.valueOf(num);
        int middleIndex = (numStr.length() - 2) / 2; // Índice del primer dígito central
        String middleDigits = numStr.substring(middleIndex, middleIndex + 2);
        return Integer.parseInt(middleDigits);
    }

    @Override
    protected void insertElement(int value, int pos) {
        int originalHash = hashFunction(value);
        int hashedIndex = originalHash;
        int i = 1;

        while (arr[hashedIndex] != 0) {  // Si ya hay un valor en la posición (colisión)
            System.out.println("Colisión detectada en índice " + hashedIndex + " para el valor " + value + ". Valor hash: " + originalHash);
            value = handleCollision(hashedIndex, value);
            hashedIndex = hashFunction(value);
        }

        arr[hashedIndex] = value;
    }

    @Override
    protected int hashFunction(int key) {
        int squared = key * key; // Elevamos al cuadrado
        int middleDigits = extractMiddleDigits(squared); // Obtenemos dígitos centrales
        int hashedValue = (middleDigits + 1) % size; // Sumamos 1 y aplicamos módulo
        System.out.println("Valor hash para " + key + ": " + hashedValue);
        return hashedValue;
    }

    @Override
    public void performSearch() {
        char repeatSearch;
        do {
            showArray();
            System.out.println("Ingresa el elemento a buscar:");
            int key = scanner.nextInt();

            int hashedIndex = hashFunction(key);
            int i = 1;
            while (hashedIndex < size && arr[hashedIndex] != key && arr[hashedIndex] != 0) {
                hashedIndex = (hashFunction(key) + i * i) % size;  // Aplicamos hashing cuadrado
                i++;
            }

            if (hashedIndex < size && arr[hashedIndex] == key) {
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
