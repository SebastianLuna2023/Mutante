package mutante;

import java.util.Scanner;


public class Mutante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dna = new String[6];
        System.out.println("Bienvenido al programa detector de mutantes.");
        
        for (int i = 0; i < 6; i++) {
            while (true) {
                System.out.println("Ingrese la secuencia de ADN para la fila número " +  (i+1) + ": ");
                System.out.println("(Recuerde que debe ingresar exactamente 6 letras que solo pueden ser: A, T, C o G)");
                String sequence = sc.nextLine().toUpperCase();
                if (sequence.length() == 6){
                    int validLetters = 0;
                    for (int j = 0; j < 6; j++){
                        char letter = sequence.charAt(j);
                        if (letter == 'A' || letter == 'T' || letter == 'C' || letter == 'G') {
                            validLetters++;
                        }
                    }
                    if (validLetters == 6) {
                        System.out.println("La secuencia ingresada es válida. Agregando a la fila número " + (i+1) + ".");
                        dna[i] = sequence;
                        break;
                    } else {
                        System.out.println("La secuencia ingresada contiene caracteres no válidos. Por favor, inténtelo de nuevo.");
                    }
                } else {
                    System.out.println("La secuencia no tiene 6 caracteres. Por favor, inténtelo de nuevo.");
                }
            }
        }
        System.out.println("Se han encontrado mutantes: " + isMutant(dna));
    }

    static boolean isMutant(String[] dna){
        int sequenceCount = 0;
        char[][] dna2D = new char[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dna2D[i][j] = dna[i].charAt(j);
            }
        }
        
        for (char[] row : dna2D) {
            for (char letter : row) {
                System.out.print(letter + "\t");
            }
            System.out.println("");   
        }
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <  3; j++) {
                if (dna2D[i][j] == dna2D[i][j + 1] && dna2D[i][j] == dna2D[i][j + 2] && dna2D[i][j] == dna2D[i][j + 3]) {
                    sequenceCount++;
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if (dna2D[i][j] == dna2D[i + 1][j] && dna2D[i][j] == dna2D[i + 2][j] && dna2D[i][j] == dna2D[i + 3][j]) {
                    sequenceCount++;
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dna2D[i][j] == dna2D[i + 1][j + 1] && dna2D[i][j] == dna2D[i + 2][j + 2] && dna2D[i][j] == dna2D[i + 3][j + 3]) {
                    sequenceCount++;
                }
            }
        }
        
        return sequenceCount >= 2;
    }   
}