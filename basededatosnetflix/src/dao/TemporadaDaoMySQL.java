package dao;

import dal.Conexion;
import dto.Temporada;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class TemporadaDaoMySQL extends TemporadaDao {

	@Override
	public int insert(Temporada obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			int id = 0;
			StringBuilder query = new StringBuilder("INSERT INTO temporada (serieId, nombreTemporada, orden) VALUES  (");
			query.append(obj.getSerieId() + "," );
			query.append("'" + obj.getNombreTemporada() + "'," );
			query.append( obj.getOrden());
			query.append(")");
			id = objConexion.ejecutarInsert(query.toString());
			if(id == 0)
				throw new Exception("El registro no pudo ser insertado");
			objConexion.desconectar();
			return id;
	}
	@Override
	public void update(Temporada obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			StringBuilder query = new StringBuilder("UPDATE temporada SET ");
			query.append("serieId = " + obj.getSerieId() + ",");
			query.append("nombreTemporada = '" + obj.getNombreTemporada() + "',");
			query.append("orden = " + obj.getOrden() + " ");
			query.append("WHERE temporadaId = " + obj.getTemporadaId());
			int upd = objConexion.ejecutarSimple(query.toString());
			if(upd == 0)
				throw new Exception("El registro no pudo ser actualizado");

			objConexion.desconectar();
	}
	@Override
	public void delete(int id){
		Conexion objConexion = Conexion.getOrCreate();
		StringBuffer query = new StringBuffer("DELETE FROM temporada ");
		query.append("WHERE temporadaId = " + id);
		objConexion.ejecutarSimple(query.toString());
		objConexion.desconectar();
	}

	@Override
	public Temporada get(int id){
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM temporada WHERE temporadaId = " + id;
			ResultSet objResultSet = objConexion.ejecutar(query);
			if(objResultSet.next()){
				Temporada obj = new Temporada();
				int _temporadaId = objResultSet.getInt("temporadaId");
				obj.setTemporadaId(_temporadaId);
				
				int _serieId = objResultSet.getInt("serieId");
				obj.setSerieId(_serieId);
				
				String _nombreTemporada = objResultSet.getString("nombreTemporada");
				obj.setNombreTemporada(_nombreTemporada);
				
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
	public ArrayList<Temporada> getList(){
		ArrayList<Temporada>  registros = new ArrayList<Temporada>();
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM temporada";
			ResultSet objResultSet = objConexion.ejecutar(query);
			while(objResultSet.next()){
				Temporada obj = new Temporada();
				int _temporadaId = objResultSet.getInt("temporadaId");
				obj.setTemporadaId(_temporadaId);
				
				int _serieId = objResultSet.getInt("serieId");
				obj.setSerieId(_serieId);
				
				String _nombreTemporada = objResultSet.getString("nombreTemporada");
				obj.setNombreTemporada(_nombreTemporada);
				
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

