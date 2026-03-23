# 🐶 Perretes API - Dog Trainer & Walker Management

Plataforma integral para servicios de adiestramiento y paseos caninos. Una API REST robusta construida con **Java** y **Spring Boot**, diseñada para gestionar servicios de cuidado canino de forma eficiente. Este proyecto implementa una arquitectura basada en microcomponentes y utiliza **Maven** para la gestión de dependencias y el ciclo de vida del software.

## 🚀 Características

- **Gestión Integral de Perros**: CRUD completo para manejar la base de datos de mascotas.
- **Base de Datos en Memoria**: Utiliza **H2 Database** para un desarrollo rápido y pruebas sin configuración externa.
- **Arquitectura de Capas**: Sigue el patrón Controlador-Servicio-Repositorio para una mejor mantenibilidad.
- **Persistencia con JPA/Hibernate**: Gestión automática de la base de datos mediante entidades Java.

## 🛠️ Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Maven** (Gestor de dependencias)
- **H2 Database** (Base de datos en memoria para desarrollo)

## 🏁 Cómo empezar

### Requisitos previos

- Tener instalado **Java JDK 17** o superior.
- Git instalado para clonar el repositorio.

### Instalación y ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/jarkonen/perretes.git
   cd perretes
   ```

2. Ejecuta la aplicación usando el Maven Wrapper incluido:
   ```bash
   ./mvnw spring-boot:run
   ```

La API estará disponible en: `http://localhost:8080/perros`

## 📡 Endpoints de la API

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/perros` | Obtiene la lista de todos los perros. |
| `GET` | `/perros/{id}` | Obtiene los detalles de un perro específico por su ID. |
| `POST` | `/perros` | Registra un nuevo perro en el sistema. |
| `PUT` | `/perros/{id}` | Actualiza la información de un perro existente. |
| `DELETE` | `/perros/{id}` | Elimina un perro del sistema. |

### Ejemplo de JSON para POST/PUT:

```json
{
  "nombre": "Rex",
  "raza": "Pastor Alemán",
  "edad": 3
}
```

---
Desarrollado con ❤️ como proyecto de aprendizaje y portfolio.
