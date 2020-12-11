package dao;

import dal.Conexion;
import dto.Serie;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class SerieDaoMySQL extends SerieDao {

	@Override
	public int insert(Serie obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			int id = 0;
			StringBuilder query = new StringBuilder("INSERT INTO serie VALUES (nombreSerie, descripcion) values (");
			query.append("'" + obj.getNombreSerie() + "'," );
			query.append("'" + obj.getDescripcion() + "' " );
			query.append(")");
			id = objConexion.ejecutarInsert(query.toString());
			if(id == 0)
				throw new Exception("El registro no pudo ser insertado");
			objConexion.desconectar();
			return id;
	}
	@Override
	public void update(Serie obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			StringBuilder query = new StringBuilder("UPDATE serie SET ");
			query.append("nombreSerie = '" + obj.getNombreSerie() + "',");
			query.append("descripcion = '" + obj.getDescripcion() + "' ");
			query.append("WHERE serieId = " + obj.getSerieId() );
			int upd = objConexion.ejecutarSimple(query.toString());
			if(upd == 0)
				throw new Exception("El registro no pudo ser actualizado");

			objConexion.desconectar();
	}
	@Override
	public void delete(int id){
		Conexion objConexion = Conexion.getOrCreate();
		StringBuffer query = new StringBuffer("DELETE FROM serie ");
		query.append("WHERE serieId = " + id);
		objConexion.ejecutarSimple(query.toString());
		objConexion.desconectar();
	}

	@Override
	public Serie get(int id){
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM serie WHERE serieId = " + id;
			ResultSet objResultSet = objConexion.ejecutar(query);
			if(objResultSet.next()){
				Serie obj = new Serie();
				int _serieId = objResultSet.getInt("serieId");
				obj.setSerieId(_serieId);
				
				String _nombreSerie = objResultSet.getString("nombreSerie");
				obj.setNombreSerie(_nombreSerie);
				
				String _descripcion = objResultSet.getString("descripcion");
				obj.setDescripcion(_descripcion);
				
				return obj;
			}
		}catch(Exception ex){
			;
		}
		return null;
	}

	@Override
	public ArrayList<Serie> getList(){
		ArrayList<Serie>  registros = new ArrayList<Serie>();
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM serie";
			ResultSet objResultSet = objConexion.ejecutar(query);
			while(objResultSet.next()){
				Serie obj = new Serie();
				int _serieId = objResultSet.getInt("serieId");
				obj.setSerieId(_serieId);
				
				String _nombreSerie = objResultSet.getString("nombreSerie");
				obj.setNombreSerie(_nombreSerie);
				
				String _descripcion = objResultSet.getString("descripcion");
				obj.setDescripcion(_descripcion);
				
				registros.add(obj);
			}
		}catch(Exception ex){
			;
		}
		return registros;
	}

}

