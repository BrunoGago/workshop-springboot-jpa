package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

/*Para criação do Rest Controller da aplicação, devemos ter as duas anotações abaixo e setar o valor que 
 * que será passado para o site em value
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//criação do end-point para acessar User - criado um GENERICS
	@GetMapping
	public ResponseEntity<User> findAll(){
		//Instanciamos a classe User e setamos alguns dados
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
		/*Criamos um metodo Rest que utiliza o ResponseEntity.ok para verificar se a classe está certa 
		*e um body para retornar seu conteúdo
		*/
		return ResponseEntity.ok().body(u);
	}
}
