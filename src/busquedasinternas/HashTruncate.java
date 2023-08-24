public class HashTruncate extends SearchMethod {
    private int position1, position2;

    public HashTruncate() {
        System.out.println("Para el método de hash por truncamiento:");
        System.out.println("Ingresa la primera posición (0 para el primer dígito, 1 para el segundo, y así sucesivamente):");
        position1 = scanner.nextInt();

        System.out.println("Ingresa la segunda posición:");
        position2 = scanner.nextInt();

        inputElementsManually();
    }

    private int truncateHash(int num) {
        String numStr = String.valueOf(num);

        char digit1 = numStr.charAt(position1);
        char digit2 = numStr.charAt(position2);

        String truncated = "" + digit1 + digit2;

        return Integer.parseInt(truncated) + 1;
    }

    @Override
    protected void insertElement(int value, int pos) {
        int originalHash = hashFunction(value);
        int hashedIndex = originalHash;

        while (arr[hashedIndex] != 0) {  // Si ya hay un valor en la posición (colisión)
            System.out.println("Colisión detectada en índice " + hashedIndex + " para el valor " + value + ". Valor hash: " + originalHash);
            value = handleCollision(hashedIndex, value);
            hashedIndex = hashFunction(value);
        }

        arr[hashedIndex] = value;
    }

    @Override
    protected int hashFunction(int key) {
        int hashedValue = truncateHash(key) % size;
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
