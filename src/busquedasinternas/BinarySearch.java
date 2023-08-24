import java.util.Arrays;

public class BinarySearch extends SearchMethod {

    public BinarySearch() {
        inputElementsManually();
        Arrays.sort(arr);  // Ordena el arreglo para la búsqueda binaria
    }

    @Override
    public void performSearch() {
        char repeatSearch;
        do {
            showArray();
            System.out.println("Ingresa el elemento a buscar:");
            int key = scanner.nextInt();

            int result = binarySearch(key);
            if (result != -1) {
                System.out.println("Elemento " + key + " encontrado en el índice " + result);
            } else {
                System.out.println("Elemento " + key + " no encontrado en el arreglo.");
            }

            System.out.println("¿Deseas realizar otra búsqueda con el mismo arreglo? (S para sí, N para no)");
            repeatSearch = scanner.next().charAt(0);
        } while (Character.toUpperCase(repeatSearch) == 'S');
    }

    private int binarySearch(int key) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    @Override
    public void showArray() {
        System.out.println("Arreglo (ordenado):");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
}
