package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class FactoryDaoMySQL extends FactoryDao{

	private FactoryDaoMySQL(){
		;
	}

	public static FactoryDao getFactoryInstance(){
		if(instancia==null)
			instancia = new FactoryDaoMySQL();
		return instancia;
	}

	@Override
	public EpisodioDao getNewEpisodioDao(){
		return new EpisodioDaoMySQL();
	}

	@Override
	public SerieDao getNewSerieDao(){
		return new SerieDaoMySQL();
	}

	@Override
	public TemporadaDao getNewTemporadaDao(){
		return new TemporadaDaoMySQL();
	}

	@Override
	public UsuarioDao getNewUsuarioDao(){
		return new UsuarioDaoMySQL();
	}

}

