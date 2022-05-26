
public class City implements Comparable<City>{

	private String cityName;
	private double decimalLatitude;
	private double decimalLongitude;
	
	public City(String name) {
		this(name,0,0);
	}
	
	public City(String name, double lat, double lon) {
		cityName = name;
		decimalLatitude = lat;
		decimalLongitude = lon;
	}
	
	public void setName(String name) {
		cityName = name;
	}
	
	public void setLat(double lat) {
		decimalLatitude = lat;
	}
	
	public void setLon(double lon) {
		decimalLongitude = lon;
	}
	
	public String getName() {
		return cityName;
	}
	
	public double getLat() {
		return decimalLatitude;
	}
	
	public double getLon() {
		return decimalLongitude;
	}
	
	public String toString() {
		return cityName + " (" +decimalLatitude+", "+ decimalLongitude+")"; 
	}

	@Override
	public int compareTo(City o) {
		return cityName.compareTo(o.cityName);
	}
	
	public boolean equals(City o) {
		return cityName.equals(o.cityName);
	}
}
