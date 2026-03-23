package com.ejemplo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Etiqueta: "Soy un componente que responde a la web"
public class HolaController {

    @GetMapping("/saludo") // Etiqueta: "Si entran a /saludo, ejecuta esto"
    public String decirHola() {
        return "¡Hola! Has creado esto sin asistentes, como un pro.";
    }
}