package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//Resgistra a classe como um componente do Spring (possíbilida a injeção por dependência com @Autowired)
//@Component
//Nesse caso, como a classe é de serviço, podemos usar uma anotação específica:
@Service
public class ProductService {
	
	//injeção de dependência da classe ProductRepository
	@Autowired
	private ProductRepository repository;
	
	//Operação na camada de serviço para encontrar os dados de Product, repassando a chamada para repository
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	//Método utilizado para retornar product por ID, retornando um obj OPTIONAL (tipo Product)
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		//retorna o obj do tipo product, dentro do optional
		return obj.get();
	}
}