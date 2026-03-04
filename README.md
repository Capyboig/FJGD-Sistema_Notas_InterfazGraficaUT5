# 📝 Sistema de Gestión de Notas por Usuario

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Console](https://img.shields.io/badge/Consola-Terminal-4D4D4D?style=for-the-badge&logo=windows-terminal&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)

Aplicación de consola en Java orientada a entornos empresariales que permite el registro, autenticación y gestión integral de notas personales. El proyecto destaca por su enfoque en la **seguridad criptográfica**, la **escalabilidad** y una arquitectura de software robusta.

## ✨ Características Principales

### 🛡️ Seguridad y Usuarios
- **Registro Seguro:** Validación de credenciales y **encriptación de contraseñas mediante SHA-256**, garantizando que la información sensible nunca se almacene en texto plano.
- **Autenticación Robusta:** Inicio de sesión mediante comparación de hashes criptográficos.
- **Sanitización Automática:** Generación de directorios seguros adaptando el email del usuario (eliminación de caracteres especiales como `@` y `.`).

### 📝 Gestión de Notas (CRUD)
- **Operaciones Completas:** Crear, listar, visualizar en detalle y eliminar notas de forma intuitiva.
- **Persistencia Avanzada:** Uso de `java.nio.file` combinado con bloques **try-with-resources** para una gestión eficiente y segura de los flujos de archivos (evitando fugas de memoria).
- **Aislamiento de Datos:** Cada usuario dispone de su propio entorno de persistencia privado.

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura de **N-Capas** basada en el patrón MVC (Modelo-Vista-Controlador), asegurando el desacoplamiento y la facilidad de mantenimiento:



[Image of layered software architecture diagram]


- **`model`**: Contiene las entidades de datos puras (POJOs) como `Usuario` y `Nota`.
- **`repository`**: Capa de persistencia encargada de la lectura y escritura física en ficheros `.txt`.
- **`service`**: Contiene la lógica de negocio, validaciones y algoritmos de encriptación.
- **`controller`**: Actúa como intermediario, coordinando el flujo de datos entre la vista y los servicios.
- **`view`**: Interfaz de usuario por consola con menús persistentes basados en bucles `do-while`.
- **`exceptions`**: Definición de excepciones personalizadas para un manejo de errores granular (ej. `UsuarioYaExistenteException`, `NotaNoExistenteException`).

---

## 📂 Estructura del Código Fuente

```text
src/
 ├── app/               # Punto de entrada de la aplicación (Main)
 ├── controller/        # Controladores de usuario y notas
 ├── exceptions/        # Excepciones personalizadas del sistema
 ├── model/             # Clases de datos (Usuario, Nota)
 ├── repository/        # Gestión de archivos y persistencia
 ├── service/           # Lógica de seguridad (SHA-256) y validaciones
 └── view/              # Interfaces de consola y menús de usuario
