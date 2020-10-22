package controller;

import java.util.Scanner;
import model.Car;
import model.Fila;

public class Estacionamento {

	private final Scanner scan;
	private final Fila p1;
	private final Fila esperaFila;

	

	public Estacionamento() {
		this.scan = new Scanner(System.in);
		this.p1 = new Fila();
		this.esperaFila = new Fila();

	}

	public static void main(String[] args) {
		Estacionamento e = new Estacionamento();
		while (e.mover()) {
		}

		//System.out.println("Total de vezes que o topo foi removido: " + e.remocoesSofridas);
	}

	private boolean mover() {
		System.out.println("Informe a movimentação do carro: ");
		char mov = scan.nextLine().charAt(0);
		switch (mov) {
		case 'C':
			adicionar();
			return true;
		case 'P':
			retirar();
			return true;
		case 'X':
			return false;
		default:
			System.out.println("Desculpe, não entendi isso.");
			return true;
		}
	}

	private void adicionar() {
		if (p1.estaCheia()) {
			System.out.println("Estacionamento cheio!");
			System.out.println("Por favor, informe a placa: ");
			String placa = scan.nextLine();
			Car carro = new Car();
			carro.setPlaca(placa);
			esperaFila.insere(carro);
			System.out.println(placa + " foi inserido na fila de espera.");
		} else {
			System.out.println("Por favor, informe a placa: ");
			String placa = scan.nextLine();
			Car carro = new Car();
			carro.setPlaca(placa);
			p1.insere(carro);
			System.out.println(placa + " foi inserido.");
		}
	}

	private void retirar() {

		System.out.println("Informe a placa do carro a ser retirado: ");

		Car car = new Car();
		String placa = scan.nextLine();
		car.setPlaca(placa);

		if (p1.contains(car)) {

			int posicao = p1.indexOfObject(car);

			if (posicao <= this.p1.tamanho() && !this.p1.vazia()) {

				for (int i = posicao; i < p1.tamanho(); i++) {

					p1.getObject((i)).addManobra();
				}

				Car carroRemovido = p1.remove(posicao);
				System.out.println("O carro removido foi o " + carroRemovido.getPlaca() + " com "
						+ carroRemovido.getManobras() + " Manobras");

				if (!this.esperaFila.vazia()) {

					this.p1.insere(this.esperaFila.remove(this.esperaFila.tamanho() - 1));
					

				}

			}

		}

		else 
			
			if (esperaFila.contains(car)) {
				
				int posicao = esperaFila.indexOfObject(car);
				
				Car carroRemovido = esperaFila.remove(posicao);
				System.out.println("O carro removido foi o " + carroRemovido.getPlaca() + " na fila de espera");
				
			}else {

			System.out.println("Não podemos retirar o carro " + placa + " pois não tem nenhum carro no estacionamento.");
			return;

		}

	}

	@Override
	public String toString() {
		return p1.toString();
	}

	public boolean estaCheia() {
		return p1.estaCheia();
	}
}