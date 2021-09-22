package bg.infosys.interns.mregister.core.dao;

import org.springframework.stereotype.Repository;

import bg.infosys.common.db.dao.GenericDAOImpl;
import bg.infosys.interns.mregister.core.entity.Movie;

@Repository
public class MovieDAO extends GenericDAOImpl<Movie, Long> {

}
