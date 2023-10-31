package Main;

import java.util.Date;

public class Car {
	private Integer id;
	private String brand;
	private String model;
	private String plate;
	private Date dateOfProduction;
	private Float price;
	private String typeOfFuel;

	public Car() {
	};

	public Car(Integer id, String brand, String model, String plate, Date dateOfProduction, Float price,
			String typeOfFuel) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.plate = plate;
		this.dateOfProduction = dateOfProduction;
		this.price = price;
		this.typeOfFuel = typeOfFuel;
	}

	@Override
	public String toString() {
//		String s = "Dettagli macchina" + "\nMarca: " + getBrand() + "\nModello: " + getModel()
//				+ "\nData di produzione: " + getDateOfProduction() + "\nPrezzo: " + getPrice()
//				+ "\nTipo di Carburante: " + getTypeOfFuel();
		String s = getId() + ", " + getBrand() + ", " + getModel() + ", " + getPlate() + ", " + getDateOfProduction()
				+ ", " + getPrice() + ", " + getTypeOfFuel();

		return s;
	}

	public Integer getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDateOfProduction() {
		return dateOfProduction;
	}

	public void setDateOfProduction(Date dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getTypeOfFuel() {
		return typeOfFuel;
	}

	public void setTypeOfFuel(String typeOfFuel) {
		this.typeOfFuel = typeOfFuel;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

}
