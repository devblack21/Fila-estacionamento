package model;

import java.util.LinkedList;
import java.util.List;

public class Fila {

	private List<Car> carros = new LinkedList<Car>();

	public boolean vazia() {
		return this.carros.size() == 0;
	}

	public void insere(Car objeto) {
		this.carros.add(objeto);
	}

	public Car remove(int i) {
		return this.carros.remove(i);	
	}
	
	public boolean contains(Car car) {
		return this.carros.contains(car);
	}
	
	public Integer indexOfObject(Car car) {
		Integer index = null;
		if(contains(car)) {
			
			index = carros.indexOf(car);
			
		}
		
		return index;
	}
	
	public Car getObject(int index) {
		
		return this.carros.get(index);
	}

	public int tamanho() {
		return this.carros.size();
	}
	
	 public boolean estaCheia() {
	        return 10 == carros.size();
	    }
}