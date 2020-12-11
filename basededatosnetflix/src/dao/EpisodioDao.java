package dao;

import dto.Episodio;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class EpisodioDao {

	public abstract int insert(Episodio obj) throws Exception;

	public abstract void update(Episodio obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Episodio> getList();

	public abstract Episodio get(int id);

}

