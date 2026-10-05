package com.example.agrojava;

import java.util.Scanner;

public class Agrojava {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcao;

        double chuva[] = new double[7];
        double somaChuva = 0;
        double mediaChuva;
        double maiorChuva = 0;
        int diaMaiorChuva = 0;

        double umidade[][] = new double[4][4];
        boolean dadosCadastrados = false;

        do {

            System.out.println("===== AGROJAVA =====");
            System.out.println("1) Cadastrar Dados");
            System.out.println("2) Exibir Mapa do Campo");
            System.out.println("3) Relatório de Alertas de Irrigação");
            System.out.println("4) Sair");
            System.out.println("Escolha uma opção:");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:

                    somaChuva = 0;
                    maiorChuva = 0;
                    diaMaiorChuva = 0;

                    for (int i = 0; i < 7; i++) {

                        System.out.println("Informe a quantidade de chuva do dia " + (i + 1) + ":");
                        chuva[i] = entrada.nextDouble();

                        somaChuva = somaChuva + chuva[i];

                        if (chuva[i] > maiorChuva) {
                            maiorChuva = chuva[i];
                            diaMaiorChuva = i + 1;
                        }
                    }

                    mediaChuva = somaChuva / 7;

                    System.out.println("Média semanal de chuva: " + mediaChuva);
                    System.out.println("Dia com maior quantidade de chuva: " + diaMaiorChuva);
                    System.out.println("Maior quantidade de chuva: " + maiorChuva);

                    break;

                case 2:

                    System.out.println("===== MAPA DE UMIDADE DO SOLO =====");

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            System.out.println("Informe a umidade do talhão [" + (i + 1) + "][" + (j + 1) + "]:");
                            umidade[i][j] = entrada.nextDouble();
                        }
                    }

                    dadosCadastrados = true;

                    System.out.println("Mapa de umidade:");

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            System.out.print(umidade[i][j] + "%\t");
                        }

                        System.out.println();
                    }

                    System.out.println("Talhões que precisam de irrigação:");

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            if (umidade[i][j] < 30) {
                                System.out.println("Talhão [" + (i + 1) + "][" + (j + 1) + "] precisa de irrigação.");
                            }
                        }
                    }

                    break;

                case 3:

                    System.out.println("===== RELATÓRIO DE ALERTAS DE IRRIGAÇÃO =====");

                    if (dadosCadastrados) {

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 4; j++) {

                                if (umidade[i][j] < 30) {
                                    System.out.println("Talhão [" + (i + 1) + "][" + (j + 1) + "] precisa de irrigação. Umidade: " + umidade[i][j] + "%");
                                }
                            }
                        }

                    } else {

                        System.out.println("Nenhum dado de umidade foi cadastrado.");
                    }

                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        entrada.close();
    }
}