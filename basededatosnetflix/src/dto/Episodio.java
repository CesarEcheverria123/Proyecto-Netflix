package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Episodio{

	private int episodioId;
	private String titulo;
	private String descripcion;
	private String youtubeVideoId;
	private int temporadaId;
	private int orden;

	public Episodio(){
		;
	}

	public void setEpisodioId(int episodioId){
		this.episodioId = episodioId;
	}

	public int getEpisodioId(){
		return this.episodioId;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public String getTitulo(){
		return this.titulo;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

	public void setYoutubeVideoId(String youtubeVideoId){
		this.youtubeVideoId = youtubeVideoId;
	}

	public String getYoutubeVideoId(){
		return this.youtubeVideoId;
	}

	public void setTemporadaId(int temporadaId){
		this.temporadaId = temporadaId;
	}

	public int getTemporadaId(){
		return this.temporadaId;
	}

	public void setOrden(int orden){
		this.orden = orden;
	}

	public int getOrden(){
		return this.orden;
	}

}

