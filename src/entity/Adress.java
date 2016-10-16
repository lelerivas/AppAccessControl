package entity;

public class Adress {
	private Integer adresscod;
	private String street;
	private String neighborhood;
	private String city;
	
	public Adress() {
		// TODO Auto-generated constructor stub
	}

	public Adress(Integer adresscod, String street, String neighborhood, String city) {
		super();
		this.adresscod = adresscod;
		this.street = street;
		this.neighborhood = neighborhood;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adress [adresscod=" + adresscod + ", street=" + street + ", neighborhood=" + neighborhood + ", city="
				+ city + "]";
	}

	public Integer getAdresscod() {
		return adresscod;
	}

	public void setAdresscod(Integer adresscod) {
		this.adresscod = adresscod;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
