package com.ejemplo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Le dice a Spring: "Soy un guardia que atiende peticiones web (HTTP)"
public class PerroController {

    // Ahora usamos la INYECCIÓN DE DEPENDENCIAS
    // El controlador ya no "guarda" los perros internamente.
    private final PerroService perroService;

    // Cuando arranca la app, Spring crea automáticamente el PerroService
    // y se lo pasa (inyecta) a este Controlador a través del constructor.
    public PerroController(PerroService perroService) {
        this.perroService = perroService;
    }

    // El Endpoint real para LEER perros
    @GetMapping("/perros")
    public List<Perro> obtenerTodosLosPerros() {
        // En lugar de hacer la lógica de negocio aquí, le delegamos el trabajo al Servicio
        return perroService.obtenerTodosLosPerros();
    }

    // NUEVO ENDPOINT: Para CREAR (Guardar) perros nuevos en la Base de Datos
    // Las peticiones POST son como los sobres cerrados: llevan el JSON dentro de su "Cuerpo" (Body)
    @PostMapping("/perros")
    public Perro añadirPerroNuevo(@RequestBody Perro nuevoPerro) {
        // La etiqueta @RequestBody hace MAGIA INVERSA: coge el JSON de internet,
        // busca los "Setters" (setNombre, setEdad) y lo transforma en un Perro de Java para tu código.
        
        return perroService.guardarPerro(nuevoPerro);
    }

    // NUEVO ENDPOINT: Para leer UN SOLO perro (por su número de ID en la URL)
    @GetMapping("/perros/{id}")
    public Perro obtenerPerroPorId(@PathVariable("id") Long id) {
        // @PathVariable le dice a Spring: "Coge el número que venga en la URL {id} y dáselo a esta función"
        return perroService.obtenerPerroPorId(id);
    }

    // NUEVO ENDPOINT: Para EDITAR un perro existente
    @PutMapping("/perros/{id}")
    public Perro actualizarPerro(@PathVariable("id") Long id, @RequestBody Perro perroActualizado) {
        return perroService.actualizarPerro(id, perroActualizado);
    }

    // NUEVO ENDPOINT: Para BORRAR un perro
    @DeleteMapping("/perros/{id}")
    public void borrarPerro(@PathVariable("id") Long id) {
        perroService.borrarPerro(id);
    }
}
