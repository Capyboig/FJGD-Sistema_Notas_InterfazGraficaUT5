<<<<<<< HEAD
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
=======
# 📝 Gestor de Notas con Usuarios (Swing + Persistencia)

### UT5.2 · Actividad de Evaluación - Interfaces Gráficas de Usuario

Este proyecto consiste en una aplicación de escritorio desarrollada en **Java Swing** para la gestión organizada de notas personales. La aplicación implementa un sistema multiusuario con persistencia de datos y seguridad mediante hashing de contraseñas.

---

## 🚀 Características del Proyecto

### Nivel 1: Gestión de Notas (Mínimos)
* **CRUD Completo**: Crear, ver, editar y eliminar notas de forma intuitiva.
* **Gestión de Selección**: Carga automática de la nota seleccionada en el panel de edición.
* **Filtros**: Buscador integrado para localizar notas por título.
* **Seguridad de Usuario**: Sistema de advertencia previo al borrado total de notas.
* **Logs Visuales**: Mensajes de estado en tiempo real sobre las acciones realizadas.

### Nivel 2: Usuarios, Persistencia y Seguridad
* **Gestión de Sesiones**: Sistema de Registro e Inicio de sesión.
* **Seguridad**: Almacenamiento de contraseñas mediante **Hashing** (sin texto plano).
* **Persistencia Real**: Cada usuario mantiene sus propias notas guardadas en ficheros locales que se recuperan al iniciar sesión.
* **Flujo de Navegación**: Opción de cerrar sesión para volver a la pantalla de bienvenida.

### Mejoras de Calidad (UX Avanzada)
* 🔍 **Buscador Live**: Filtrado en tiempo real mientras el usuario escribe.
* 💾 **Guardado Automático**: Sincronización con el disco tras cada edición/creación.
* 📤 **Exportación**: Funcionalidad para exportar todas las notas a un archivo externo.
* ✨ **UX Cuidada**: Botones con estados habilitados/deshabilitados según contexto y mensajes de confirmación claros.

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje**: Java 17+
* **Interfaz**: Java Swing & AWT.
* **Persistencia**: Gestión de ficheros (E/S de Java).
* **Seguridad**: Algoritmo de cifrado/hashing para credenciales.
* **Control de Versiones**: Git & GitHub.

---

## 📂 Estructura del Programa

Siguiendo el principio de **responsabilidad única**, el proyecto se organiza en los siguientes paquetes:

* `model`: Clases POJO (Nota, Usuario).
* `view`: Formularios y componentes Swing (Pantallas de Login, Registro, Gestor).
* `controller`: Lógica de control y gestión de eventos.
* `persistence`: Manejo de lectura/escritura en ficheros.
* `utils`: Utilidades de seguridad (Hash) y validaciones de datos.

---

## 💻 Instalación y Uso

1.  **Clonar el repositorio**:
    ```bash
    git clone [https://github.com/tu-usuario/tu-repositorio.git](https://github.com/tu-usuario/tu-repositorio.git)
    ```
2.  **Compilación**: Importar el proyecto como un proyecto Java estándar en tu IDE (IntelliJ, Eclipse o NetBeans).
3.  **Ejecución**: Ejecutar la clase `Main` (que lanza la pantalla de Login).

---

## 📸 Capturas de Pantalla

> [!TIP]
> *Inserta aquí tus capturas una vez termines el diseño.*

| Login y Registro | Panel de Notas |
| :--- | :--- |
| ![Login](https://via.placeholder.com/300x200?text=Captura+Login) | ![Gestor](https://via.placeholder.com/300x200?text=Captura+Gestor) |

---

## 👤 Autor
* **Estudiante**: [Tu Nombre y Apellido]
* **Módulo**: Desarrollo de Interfaces
* **Curso**: 2025/2026
>>>>>>> 26a06f09639b811c3d1fe2dcf362c89c59767ed8
