package br.com.grafos;

import java.util.Scanner;

public class Teste {
	
	public static void main(String[] args) {
		/* INSERINDO TAMANHO DA MATRIZ */
		int tamanho;
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira o tamanho desejado da matriz: ");
		tamanho = sc.nextInt();
		
		/* INSTACIANDO MATRIZ E CHAMANDO METODOS DA CLASSE */
		Matriz matriz = new Matriz(tamanho);
		matriz.zerar();
		//matriz.imprimi(); CASO DESEJA MOSTRAR SITUAÇÃO DA MATRIZ PARA CONFIRMAR SE ESTÁ ZERADA
		
		/* PASSANDO VALOR DA MATRIZ AUXILIAR PARA MATRIZ ORIGINAL */
		int[][] matrizAuxiliar = inserindoValor(tamanho, matriz, sc);		
		matriz.copia(matrizAuxiliar);
		matriz.imprimi();
		
		matriz.warshall();
		matriz.imprimiMatrizAcancabilidade();
	}
	
	
	/* METODO PARA INSERIR VALOR NA MATRIZ USANDO UMA MATRIZ AUXILIAR */
	public static int[][] inserindoValor (int tamanho, Matriz matriz, Scanner sc) {
		int[][] matrizAuxiliar = matriz.getMatriz();
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				System.out.print("Insira o valor na matriz na posição [" + (i+1)  + "," + (j+1) + "] :" );
				int aux = sc.nextInt();
				if(aux >= 0 && aux <= 1) {
					matrizAuxiliar[i][j] = aux;
				} else {
					System.out.println("Valor não corresponde a 0 ou 1");
					j = (j-1);
				}
				
			}
		}
		return matrizAuxiliar;
	}	
}
