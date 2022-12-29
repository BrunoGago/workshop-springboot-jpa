package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//Resgistra a classe como um componente do Spring (possíbilida a injeção por dependência com @Autowired)
//@Component
//Nesse caso, como a classe é de serviço, podemos usar uma anotação específica:
@Service
public class CategoryService {
	
	//injeção de dependência da classe CategoryRepository
	@Autowired
	private CategoryRepository repository;
	
	//Operação na camada de serviço para encontrar os dados de Category, repassando a chamada para repository
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	//Método utilizado para retornar category por ID, retornando um obj OPTIONAL (tipo Category)
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		//retorna o obj do tipo category, dentro do optional
		return obj.get();
	}
}