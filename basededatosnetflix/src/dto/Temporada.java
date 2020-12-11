package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Temporada{

	private int temporadaId;
	private int serieId;
	private String nombreTemporada;
	private int orden;

	public Temporada(){
		;
	}

	public void setTemporadaId(int temporadaId){
		this.temporadaId = temporadaId;
	}

	public int getTemporadaId(){
		return this.temporadaId;
	}

	public void setSerieId(int serieId){
		this.serieId = serieId;
	}

	public int getSerieId(){
		return this.serieId;
	}

	public void setNombreTemporada(String nombreTemporada){
		this.nombreTemporada = nombreTemporada;
	}

	public String getNombreTemporada(){
		return this.nombreTemporada;
	}

	public void setOrden(int orden){
		this.orden = orden;
	}

	public int getOrden(){
		return this.orden;
	}

}

