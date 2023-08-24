public class HashFold extends SearchMethod {
    private int numOfDigits;
    private int groupSize;

    public HashFold() {
        System.out.println("Para el método de hash por plegamiento:");
        System.out.println("Ingresa el número de cifras de cada elemento:");
        numOfDigits = scanner.nextInt();

        System.out.println("Ingresa cuántos números agrupar:");
        groupSize = scanner.nextInt();

        inputElementsManually();
    }

    private int foldHash(int num) {
        String numStr = String.format("%0" + numOfDigits + "d", num);
        int sum = 0;

        for (int i = 0; i < numOfDigits; i += groupSize) {
            int end = Math.min(i + groupSize, numOfDigits);
            String group = numStr.substring(i, end);
            sum += Integer.parseInt(group);
        }

        String sumStr = String.valueOf(sum);
        int len = sumStr.length();

        String lastGroupDigits;
        if (len > groupSize) {
            lastGroupDigits = sumStr.substring(len - groupSize, len);
        } else {
            lastGroupDigits = sumStr;
        }

        int result = Integer.parseInt(lastGroupDigits) + 1;
        return result;
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
        int hashedValue = foldHash(key) % size;
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

    @Override
    public void inputElements(int numberOfElements) {
        System.out.println("Ingresa los elementos:");

        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Elemento " + (i + 1) + ":");
            int input = scanner.nextInt();

            while (String.valueOf(input).length() != numOfDigits) {
                System.out.println("Por favor, ingresa un número con " + numOfDigits + " cifras:");
                input = scanner.nextInt();
            }

            insertElement(input, i);
        }
    }
}
