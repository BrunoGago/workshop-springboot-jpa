package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

//Nessa classe até poderíamos definir o @Repository para permitir injeção de dependência
//Porém, como a interface já extende a Jparepository, ela automaticamente herda essa anotação
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}