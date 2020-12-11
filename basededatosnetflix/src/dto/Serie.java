package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Serie{

	private int serieId;
	private String nombreSerie;
	private String descripcion;

	public Serie(){
		;
	}

	public void setSerieId(int serieId){
		this.serieId = serieId;
	}

	public int getSerieId(){
		return this.serieId;
	}

	public void setNombreSerie(String nombreSerie){
		this.nombreSerie = nombreSerie;
	}

	public String getNombreSerie(){
		return this.nombreSerie;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

}

