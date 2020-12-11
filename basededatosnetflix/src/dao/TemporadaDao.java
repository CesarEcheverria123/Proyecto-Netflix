package dao;

import dto.Temporada;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class TemporadaDao {

	public abstract int insert(Temporada obj) throws Exception;

	public abstract void update(Temporada obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Temporada> getList();

	public abstract Temporada get(int id);

}

