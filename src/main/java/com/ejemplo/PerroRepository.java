package com.ejemplo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // "Soy el trabajador de almacén encargado de la tabla Perro"
public interface PerroRepository extends JpaRepository<Perro, Long> {
    
    // JpaRepository ya incluye todos los comandos genéricos por defecto:
    // .findAll() (devuelve la lista entera como un SELECT *)
    // .save(perro) (hace un INSERT o UPDATE en la DB automáticamente)
    // .findById(id) (hace un SELECT * FROM perro WHERE id = ?)
    
    // Si usas Spring Data JPA, ¡no hace falta escribir SQL a mano para cosas tan básicas!
}
