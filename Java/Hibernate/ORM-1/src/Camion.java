

public class Camion extends Vehiculo {

	private Integer idVehiculo;
	
	private Float tara;
	private Float mma;
	
	public Float getTara() {
		return tara;
	}
	public void setTara(Float tara) {
		this.tara = tara;
	}
	public Float getMma() {
		return mma;
	}
	public void setMma(Float mma) {
		this.mma = mma;
	}
	@Override
	public Integer getNumeroPlazas() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	
	
}
