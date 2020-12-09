package wrappers;

import java.util.Objects;

public class Park {
	
	private int id;
	private String address;
	private String type;
	private int status;
	private double lat;
	private double lon;
	private final double earthRay = 6372.795477598;
	
	public Park(int id, String address, String type, int status, double lat, double lon) {
		this.id = id;
		this.address = address;
		this.type = type;
		this.status = status;
		this.lat = lat;
		this.lon = lon;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Park)) {
			return false;
		}
		Park other = (Park) o;
		return id == other.getId() && type.equals(other.getType()) && address.equals(other.getAddress()) && status == other.getStatus() && Math.abs(lat-other.getLat()) < 0.00000001 && Math.abs(lon-other.getLon()) < 0.00000001;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, type, address, status, lat, lon);
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public Double distanceFrom(Park other) {
		double radLatA = Math.PI * getLat() / 180;
  		double radLonA = Math.PI * getLon() / 180;
  		double radLatB = Math.PI * other.getLat() / 180;
  		double radLonB = Math.PI * other.getLon() / 180;
  		double phi = Math.abs(radLonA - radLonB);
  		double p = Math.acos((Math.sin(radLatA) * Math.sin(radLatB)) + (Math.cos(radLatA) * Math.cos(radLatB) * Math.cos(phi)));
  		return p*earthRay;
	}
	

	
	
}
