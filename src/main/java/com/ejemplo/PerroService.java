package com.ejemplo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Sigue siendo el experto en lógica de negocio
public class PerroService {

    // 1. Inyectamos a nuestro "Trabajador de almacén" (la Base de Datos)
    private final PerroRepository perroRepository;

    public PerroService(PerroRepository perroRepository) {
        this.perroRepository = perroRepository;
    }

    // 2. @PostConstruct le dice a Spring: "Ejecuta esto justo después de crear el Servicio"
    @PostConstruct
    public void inicializarBaseDeDatos() {
        // Si la tabla Perro de la BD está vacía, metemos 3 perros de prueba
        if (perroRepository.count() == 0) {
            
            // Fíjate que le pasamos 'null' al ID, porque ahora es la 
            // Base de Datos la que se encarga de inventar el número (1, 2, 3...)
            perroRepository.save(new Perro(null, "Rex", "Pastor Alemán", 3));
            perroRepository.save(new Perro(null, "Laika", "Husky Siberiano", 5));
            perroRepository.save(new Perro(null, "Toby", "Golden Retriever", 1));
        }
    }

    // 3. Obtener los perros ahora es pedirle al trabajador que mire en la tabla
    public List<Perro> obtenerTodosLosPerros() {
        // MAGIA: findAll() equivale internamente a ejecutar: SELECT * FROM perro;
        return perroRepository.findAll();
    }

    // 4. NUEVA LÓGICA: Pedimos al trabajador de almacén que guarde un perro nuevo
    public Perro guardarPerro(Perro nuevoPerro) {
        // El repositorio guarda el nuevo perro y le inventa un ID si no lo tiene.
        // Después, te devuelve el perro ya guardado con su número de ID nuevo asignado.
        return perroRepository.save(nuevoPerro);
    }

    // 5. NUEVA LÓGICA: Buscar un perro específico por su ID
    public Perro obtenerPerroPorId(Long id) {
        // findById nos da un "Optional" (puede que el perro no exista).
        // .orElse(null) dice: "si no lo encuentras, devuélveme un nulo".
        return perroRepository.findById(id).orElse(null);
    }

    // 6. NUEVA LÓGICA: Borrar un perro por su ID
    public void borrarPerro(Long id) {
        perroRepository.deleteById(id);
    }

    // 7. NUEVA LÓGICA: Actualizar los datos de un perro que ya existe
    public Perro actualizarPerro(Long id, Perro datosNuevos) {
        // Primero buscamos si el perro existe de verdad
        Perro perroExistente = obtenerPerroPorId(id);

        if (perroExistente != null) {
            // "Pisamos" los datos viejos con los nuevos que nos han enviado
            perroExistente.setNombre(datosNuevos.getNombre());
            perroExistente.setRaza(datosNuevos.getRaza());
            perroExistente.setEdad(datosNuevos.getEdad());

            // Guardamos los cambios en la base de datos
            return perroRepository.save(perroExistente);
        }
        
        return null; // Si no existía, no actualizamos nada
    }
}
