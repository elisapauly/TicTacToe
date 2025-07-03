//codigo feito a partir da logica que o professor passou.

import java.util.Scanner;

public class JogoDaVelha {

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        limparTela();
        System.out.println();
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(" " + tabuleiro[linha][coluna]);
                if (coluna < 2) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (linha < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar a tela");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] matriz = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char jogador = 'X'; // começa com X

        System.out.println("### JOGO DA VELHA ###");

        // Máximo de 9 jogadas
        for (int rodada = 0; rodada < 9; rodada++) {
            imprimirTabuleiro(matriz);
            System.out.println("Vez do jogador '" + jogador + "'");

            int linha, coluna;

            while (true) {
                System.out.print("Escolha a linha (0, 1 ou 2): ");
                linha = sc.nextInt();

                System.out.print("Escolha a coluna (0, 1 ou 2): ");
                coluna = sc.nextInt();

                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
                    if (matriz[linha][coluna] == ' ') {
                        break;
                    } else {
                        System.out.println("Posição ocupada. Escolha outra.");
                    }
                } else {
                    System.out.println("Posição inválida! Tente de novo.");
                }
            }

            matriz[linha][coluna] = jogador;

            // Troca jogador
            jogador = (jogador == 'X') ? 'O' : 'X';
        }

        imprimirTabuleiro(matriz);
        System.out.println("Fim do jogo!");
    }
}
