package shop.parkkibeom.api.common.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public abstract class AbstractService<T> {

	public abstract Long count();

	public abstract Boolean existsById(long id);

	public abstract Page<T> findAll(Pageable pageable);

	public abstract Optional<T> findById(long id);

	public abstract Optional<T> getOne(long id);

	public abstract Long save(T t);

	public abstract Long delete(T t);

	/*
	public abstract long count();
	
	public abstract boolean existsById(long id);
	
	public abstract List<T> findAll();
	
	public abstract Optional<T> findOne(Example<T> example);
	
	public abstract void deleteById(long id);
	
	public abstract Optional<T> findById(long id);
	
	public abstract T save(T entity);
	
	public abstract T getOne(long id);
	 */
	
}
