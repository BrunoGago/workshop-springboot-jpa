package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

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
		//retorna o obj do tipo user, dentro do optional
		return obj.get();
	}
}