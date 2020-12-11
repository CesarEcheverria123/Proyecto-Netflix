package dao;

import dal.Conexion;
import dto.Episodio;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class EpisodioDaoMySQL extends EpisodioDao {

	@Override
	public int insert(Episodio obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			int id = 0;
			StringBuilder query = new StringBuilder("INSERT INTO episodio VALUES (titulo, descripcion, youtubeVideoId, temporadaId, orden) values (");
			query.append("'" + obj.getTitulo() + "'," );
			query.append("'" + obj.getDescripcion() + "'," );
			query.append("'" + obj.getYoutubeVideoId() + "'," );
			query.append("'" + obj.getTemporadaId() + "'," );
			query.append(obj.getOrden());
			query.append(")");
			id = objConexion.ejecutarInsert(query.toString());
			if(id == 0)
				throw new Exception("El registro no pudo ser insertado");
			objConexion.desconectar();
			return id;
	}
	@Override
	public void update(Episodio obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			StringBuilder query = new StringBuilder("UPDATE episodio SET ");
			query.append("titulo = '" + obj.getTitulo() + "',");
			query.append("descripcion = '" + obj.getDescripcion() + "',");
			query.append("youtubeVideoId = '" + obj.getYoutubeVideoId() + "',");
			query.append("temporadaId = " + obj.getTemporadaId() + ",");
			query.append("orden = " + obj.getOrden() + " ");
			query.append("WHERE episodioId = " + obj.getEpisodioId() );
			int upd = objConexion.ejecutarSimple(query.toString());
			if(upd == 0)
				throw new Exception("El registro no pudo ser actualizado");

			objConexion.desconectar();
	}
	@Override
	public void delete(int id){
		Conexion objConexion = Conexion.getOrCreate();
		StringBuffer query = new StringBuffer("DELETE FROM episodio ");
		query.append("WHERE episodioId = " + id);
		objConexion.ejecutarSimple(query.toString());
		objConexion.desconectar();
	}

	@Override
	public Episodio get(int id){
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM episodio WHERE episodioId = " + id;
			ResultSet objResultSet = objConexion.ejecutar(query);
			if(objResultSet.next()){
				Episodio obj = new Episodio();
				int _episodioId = objResultSet.getInt("episodioId");
				obj.setEpisodioId(_episodioId);
				
				String _titulo = objResultSet.getString("titulo");
				obj.setTitulo(_titulo);
				
				String _descripcion = objResultSet.getString("descripcion");
				obj.setDescripcion(_descripcion);
				
				String _youtubeVideoId = objResultSet.getString("youtubeVideoId");
				obj.setYoutubeVideoId(_youtubeVideoId);
				
				int _temporadaId = objResultSet.getInt("temporadaId");
				obj.setTemporadaId(_temporadaId);
				
				int _orden = objResultSet.getInt("orden");
				obj.setOrden(_orden);
				
				return obj;
			}
		}catch(Exception ex){
			;
		}
		return null;
	}

	@Override
	public ArrayList<Episodio> getList(){
		ArrayList<Episodio>  registros = new ArrayList<Episodio>();
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM episodio";
			ResultSet objResultSet = objConexion.ejecutar(query);
			while(objResultSet.next()){
				Episodio obj = new Episodio();
				int _episodioId = objResultSet.getInt("episodioId");
				obj.setEpisodioId(_episodioId);
				
				String _titulo = objResultSet.getString("titulo");
				obj.setTitulo(_titulo);
				
				String _descripcion = objResultSet.getString("descripcion");
				obj.setDescripcion(_descripcion);
				
				String _youtubeVideoId = objResultSet.getString("youtubeVideoId");
				obj.setYoutubeVideoId(_youtubeVideoId);
				
				int _temporadaId = objResultSet.getInt("temporadaId");
				obj.setTemporadaId(_temporadaId);
				
				int _orden = objResultSet.getInt("orden");
				obj.setOrden(_orden);
				
				registros.add(obj);
			}
		}catch(Exception ex){
			;
		}
		return registros;
	}

}

