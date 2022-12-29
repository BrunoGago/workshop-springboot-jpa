package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//Resgistra a classe como um componente do Spring (possíbilida a injeção por dependência com @Autowired)
//@Component
//Nesse caso, como a classe é de serviço, podemos usar uma anotação específica:
@Service
public class OrderService {
	
	//injeção de dependência da classe OrderRepository
	@Autowired
	private OrderRepository repository;
	
	//Operação na camada de serviço para encontrar os dados de Order, repassando a chamada para repository
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	//Método utilizado para retornar user por ID, retornando um obj OPTIONAL (tipo Order)
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		//retorna o obj do tipo user, dentro do optional
		return obj.get();
	}
}