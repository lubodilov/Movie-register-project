package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
//import bg.infosys.interns.mregister.core.entity.Country;
//import bg.infosys.interns.mregister.core.entity.Company;
//import bg.infosys.interns.mregister.core.entity.Genre;
import bg.infosys.interns.mregister.core.entity.Movie;
import bg.infosys.interns.mregister.ws.dto.MovieDTO;

@Component
public class MovieMapper implements IModelMapper<MovieDTO, Movie> { 
	private final CountryMapper countryMapper;
	private final CompanyMapper companyMapper;
	private final GenreMapper genreMapper;

	public MovieMapper(CountryMapper countryMapper, CompanyMapper companyMapper, GenreMapper genreMapper) {
		this.countryMapper=countryMapper;
		this.companyMapper=companyMapper;
		this.genreMapper=genreMapper;
	}
	
	@Override
	public MovieDTO toDto(Movie entity) {
		if (entity == null) return null;
		
		MovieDTO dto = new MovieDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDirector(entity.getDirector());
		dto.setReleaseDate(entity.getReleaseDate());
		dto.setBoxOffice(entity.getBoxOffice());
		dto.setBudget(entity.getBudget());
		dto.setCountry(countryMapper.toDto(entity.getCountry()));
		dto.setCompany(companyMapper.toDto(entity.getCompany()));
		dto.setGenre(genreMapper.toDto(entity.getGenre()));
		return dto;
	}
	

	@Override
	public Movie toEntity(MovieDTO dto) {
		if (dto == null) return null;
		
		Movie entity = new Movie ();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDirector(dto.getDirector());
		entity.setReleaseDate(dto.getReleaseDate());
		entity.setBoxOffice(dto.getBoxOffice());
		entity.setBudget(dto.getBudget());
		entity.setCountry(countryMapper.toEntity(dto.getCountry()));
		entity.setCompany(companyMapper.toEntity(dto.getCompany()));
		entity.setGenre(genreMapper.toEntity(dto.getGenre()));
		return entity;
	}
	
	@Override
	public Movie toEntity(MovieDTO dto, Movie entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDirector(dto.getDirector());
		entity.setReleaseDate(dto.getReleaseDate());
		entity.setBoxOffice(dto.getBoxOffice());
		entity.setBudget(dto.getBudget());
		//entity.setCountry(countryMapper.toEntity(dto.getCountry(), countryEntity));
		//entity.setCompany(companyMapper.toEntity(dto.getCompany(), companyEntity));
		//entity.setGenre(genreMapper.toEntity(dto.getGenre(), genreEntity));
		return entity;
	}

}
