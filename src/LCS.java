public class LCS {

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int[][] LongesCommonSunsequence(String A, String B) {
        int aLength = A.length();
        int bLength = B.length();

        int matrix[][] = new int[aLength+1][bLength+1];

        for (int i = 1; i < aLength+1; i++) {
            for (int j = 1; j < bLength+1; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }
                else {
                    matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        //to show LCS matrix
        for (int i = 0; i < aLength+1; i++) {
            for (int j = 0; j < bLength+1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static String showLCS(String A, String B, int[][] matrix, int i, int j) {

        if (matrix[i][j] == 0) return "";

        else if (A.charAt(i-1) == B.charAt(j-1)) {
            return showLCS(A, B, matrix, i-1, j-1) + A.charAt(i-1);
        }
        else if (matrix[i][j] == matrix[i-1][j]) {
            return showLCS(A, B, matrix, i-1, j);
        }
        else {
            return showLCS(A, B, matrix, i, j-1);
        }
    }

    public static void main(String[] args) {
        String A = "XYXXZXYZXY";
        String B = "ZXZYYZXXYYXXZ";

        int[][] lcsMatrix = LongesCommonSunsequence(A, B);
        String output = showLCS(A, B, lcsMatrix, A.length(), B.length());
        System.out.println(output);
    }

}
