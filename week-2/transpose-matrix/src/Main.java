public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 4}, {5, 6, 4}};

        // Transpose the matrix
        int[][] transpose = new int[3][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        System.out.println("The transpose is: ");
            for (int[] i : transpose) {
                for (int j : i) {
                    System.out.print(j + "    ");
            }
            System.out.println();
        }

    }
}