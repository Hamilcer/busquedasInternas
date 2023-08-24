
public class SequentialSearch extends SearchMethod {

    public SequentialSearch() {
        inputElementsManually();
    }

    @Override
    public void performSearch() {
        char repeatSearch;
        do {
            showArray();
            System.out.println("Ingresa el elemento a buscar:");
            int key = scanner.nextInt();

            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (arr[i] == key) {
                    System.out.println("Elemento " + key + " encontrado en el índice " + i);
                    found = true;
                    break;
                }
            }

            if (!found) {
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
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

}
