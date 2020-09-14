package br.com.grafos;

public class Matriz {

	private int tamanho;
	private int[][] matriz;
	private int[][] matrizAlcancabilidade;

	public Matriz(int tamanho) {
		this.tamanho = tamanho;
		this.matriz = new int[tamanho][tamanho];
		this.matrizAlcancabilidade = new int [tamanho][tamanho];
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public void zerar() {
		for (int i = 0; i < this.tamanho; i++) {
			for (int j = 0; j < this.tamanho; j++) {
				this.matriz[i][j] = 0;
				this.matrizAlcancabilidade[i][j] = 0;
			}
		}
	}

	public void imprimi() {
		System.out.println();
		System.out.println("MATRIZ DE ADJACENCIA");
		int div = this.tamanho/2;
		for (int i = 0; i < this.tamanho; i++) {
			if(i == div) {
				System.out.print("M =");
				System.out.print("  [");
			} else {
				System.out.print("     [");
			}
			for (int j = 0; j < this.tamanho; j++) {
				if (j == (this.tamanho - 1)) {
					System.out.println(this.matriz[i][j] + "]");
				} else {
					System.out.print(this.matriz[i][j] + " ");
				}
			}
		}
	}

	public void copia(int[][] matrizAuxiliar) {
		for (int i = 0; i < this.tamanho; i++) {
			for (int j = 0; j < this.tamanho; j++) {
				this.matriz[i][j] = matrizAuxiliar[i][j];
				this.matrizAlcancabilidade[i][j] = matrizAuxiliar[i][j];
			}
		}
	}
	
	public void warshall() {
		for(int k = 0; k < this.tamanho ; k ++) {
			for (int i = 0 ; i < this.tamanho ; i ++) {
				for (int j = 0 ; j < this.tamanho ; j ++ ) {
					int aux = 0;
					aux = verificaE(this.matrizAlcancabilidade[i][k], this.matrizAlcancabilidade[k][j]);
					this.matrizAlcancabilidade[i][j] = verificaOU(this.matrizAlcancabilidade[i][j], aux);
				}
			}
		}
	}
	
	public int verificaE(int num1, int num2) {
		if(num1 == 1 && num2 == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int verificaOU(int num1, int num2) {
		if(num1 == 0 && num2 == 0) {
			return 0;
		} else {
			return 1;
		}

	}
	
	public void imprimiMatrizAcancabilidade() {
		for(int i = 0 ; i < 1 ; i++) {
			System.out.println();
		}
		System.out.println("MATRIZ DE ALCANÇABILIDADE");
		int div = this.tamanho/2;
		for (int i = 0; i < this.tamanho; i++) {
			if(i == div) {
				System.out.print("R =");
				System.out.print("  [");
			} else {
				System.out.print("     [");
			}
			for (int j = 0; j < this.tamanho; j++) {
				if (j == (this.tamanho - 1)) {
					System.out.println(this.matrizAlcancabilidade[i][j] + "]");
				} else {
					System.out.print(this.matrizAlcancabilidade[i][j] + " ");
				}
			}
		}
	}
}
