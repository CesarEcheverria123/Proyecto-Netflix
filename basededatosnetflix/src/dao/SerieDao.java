package dao;

import dto.Serie;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class SerieDao {

	public abstract int insert(Serie obj) throws Exception;

	public abstract void update(Serie obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Serie> getList();

	public abstract Serie get(int id);

}

