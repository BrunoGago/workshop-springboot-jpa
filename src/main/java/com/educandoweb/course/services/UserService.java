package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

//import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

//Resgistra a classe como um componente do Spring (possíbilida a injeção por dependência com @Autowired)
//@Component
//Nesse caso, como a classe é de serviço, podemos usar uma anotação específica:
@Service
public class UserService {
	
	//injeção de dependência da classe UserRepository
	@Autowired
	private UserRepository repository;
	
	//Operação na camada de serviço para encontrar os dados de User, repassando a chamada para repository
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//Método utilizado para retornar user por ID, retornando um obj OPTIONAL (tipo User)
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//retorna o obj do tipo user, dentro do optional, bem como trata a exceção no caso de o ID não existir
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Operação básica para salvar um obj da classe User no BD
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Tratei o erro da mesma forma como no findById
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			//monitoramento do obj pelo JPA (não busca no BD, sendo mais eficiente)
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}