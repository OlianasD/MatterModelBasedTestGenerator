package wrappers;

import java.sql.SQLException;

import annots.ModelName;
import utils.PostgresDBDriver;

@ModelName("Server")
public class Server {
	public int nCar;
	public int maxCar;
	public int nMoto;
	public int maxMoto;
	public int nHandicap;
	public int maxHandicap;
	
	public Server(int numCar, int maxCar, int numMoto, int maxMoto, int numHandicap, int maxHandicap) {
		this.nCar = numCar;
		this.maxCar = maxCar;
		this.nMoto = numMoto;
		this.maxMoto = maxMoto;
		this.nHandicap = numHandicap;
		this.maxHandicap = maxHandicap;
	}
	
	@ModelName("newVehicle")
	public void newVehicle(String type) {
		if(type.equals("car")) {
			nCar++;
		}
		else if(type.equals("moto")) {
			nMoto++;
		}
		else if(type.equals("handicap")) {
			nHandicap++;
		}
	}
	
	@ModelName("vehicleLeaves")
	public void vehicleLeaves(String type) {
		if(type.equals("car")) {
			nCar--;
		}
		else if(type.equals("moto")) {
			nMoto--;
		}
		else if(type.equals("handicap")) {
			nHandicap--;
		}
	}
	
	@ModelName("setAllFree")
	public boolean setAllFree()  {
		try {
			new PostgresDBDriver().runUpdateQuery("UPDATE smartparking.parks SET status = 0");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
