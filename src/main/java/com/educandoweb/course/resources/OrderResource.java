package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

/*Para criação do Rest Controller da aplicação, devemos ter as duas anotações abaixo e setar o valor que 
 * que será passado para o site em value
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	//injeção de dependência com OrderService da camada Services, sendo possível acessar seus métodos;
	@Autowired
	private OrderService service;
	
	//criação do end-point para acessar Order - criado um GENERICS
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//criação de um end-point de requisição do tipo GET, utilizando o ID como pesquisa na URL
	//A anotação @PathVariable é utilizada para que o método receba o argumento do tipo URL que será passado
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}