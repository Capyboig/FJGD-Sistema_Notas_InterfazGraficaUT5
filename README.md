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
