package com.example.ejemplomongo.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ejemplomongo.model.entities.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer> {//aca va la entidad y la llave o id de la entidad el tipo de dato

}
