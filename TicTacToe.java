//codigo feito com pesquisas em vídeo e chatgpt. 

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        char simboloAtual = 'X';
        boolean jogoAtivo = true;

        iniciarTabuleiro(tabuleiro);

        while (jogoAtivo) {
            desenhaTabuleiro(tabuleiro);

            if (verificaVitoria(tabuleiro) != ' ') {
                System.out.printf("Jogador %c venceu!%n", verificaVitoria(tabuleiro));
                break;
            }

            if (verificaEmpate(tabuleiro)) {
                System.out.println("Empate!");
                break;
            }

            int[] posicao = jogar(scan, simboloAtual);

            if (tabuleiro[posicao[0]][posicao[1]] == ' ') {
                tabuleiro[posicao[0]][posicao[1]] = simboloAtual;
                simboloAtual = (simboloAtual == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Posição ocupada! Tente novamente.");
            }
        }

        desenhaTabuleiro(tabuleiro);
        System.out.println("Fim do jogo.");
        scan.close();
    }

    public static void iniciarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void desenhaTabuleiro(char[][] tabuleiro) {
        System.out.println("    0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j]);
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) System.out.println("   --+---+--");
        }
    }

    public static int[] jogar(Scanner scan, char simboloAtual) {
        int[] posicao = new int[2];
        System.out.printf("Jogador %c, informe a linha (0-2): ", simboloAtual);
        posicao[0] = scan.nextInt();
        System.out.printf("Jogador %c, informe a coluna (0-2): ", simboloAtual);
        posicao[1] = scan.nextInt();
        return posicao;
    }

    public static char verificaVitoria(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != ' ' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0];
            }
            if (tabuleiro[0][i] != ' ' && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i];
            }
        }
        if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0];
        }
        if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2];
        }
        return ' ';
    }

    public static boolean verificaEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
