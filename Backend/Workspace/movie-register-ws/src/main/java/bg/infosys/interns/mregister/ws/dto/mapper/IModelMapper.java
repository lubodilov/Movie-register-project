package bg.infosys.interns.mregister.ws.dto.mapper;

public interface IModelMapper<T, U> {
	T toDto(U entity);
	U toEntity(T dto);
	U toEntity(T dto, U entity);
}
