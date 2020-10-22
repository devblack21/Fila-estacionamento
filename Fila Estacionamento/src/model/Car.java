package model;

public class Car {
	
	private String placa;
	private int manobras;
	
	public Car() {
		
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	public String getPlaca() {
		return placa;
	}
	
	public int getManobras() {
		return manobras;
	}
	
	public void addManobra() {
		
		this.manobras++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

}