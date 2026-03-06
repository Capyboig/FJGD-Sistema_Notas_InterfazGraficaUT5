# 📝 Gestor de Notas con Usuarios (Java Swing)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Interfaz_Gráfica-Swing-blue?style=for-the-badge&logo=java&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)

Aplicación de escritorio desarrollada en **Java Swing** para la gestión organizada de notas personales. El proyecto destaca por su enfoque en la **seguridad criptográfica**, la **persistencia de datos** y una arquitectura robusta basada en el patrón MVC.

---

## ✨ Características Principales

### 🛡️ Seguridad y Usuarios
- **Registro Seguro:** Validación de credenciales y **encriptación de contraseñas mediante SHA-256**, garantizando que la información sensible nunca se almacene en texto plano.
- **Autenticación Robusta:** Inicio de sesión mediante comparación de hashes criptográficos.
- **Gestión de Sesiones:** Flujo completo de navegación entre pantallas de Login, Registro y el Panel Principal.

### 📝 Gestión de Notas (CRUD)
- **Operaciones Completas:** Crear, editar, visualizar y eliminar notas de forma intuitiva a través de la interfaz gráfica.
- **Persistencia Real:** Uso de `java.nio.file` para que cada usuario mantenga sus propias notas guardadas en ficheros locales que se recuperan al iniciar sesión.
- **Buscador Live:** Filtrado en tiempo real de notas por título mientras el usuario escribe.

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura de **N-Capas** (MVC), asegurando el desacoplamiento y la facilidad de mantenimiento:



[Image of MVC software architecture diagram]


- **`model`**: Contiene las entidades de datos (POJOs) como `Usuario` y `Nota`.
- **`view`**: Formularios y componentes Swing (Pantallas de Login, Registro y Gestor).
- **`controller`**: Lógica de control y gestión de eventos que comunica la vista con la persistencia.
- **`persistence` / `repository`**: Capa encargada de la lectura y escritura física en ficheros.
- **`utils`**: Utilidades de seguridad (Hashing SHA-256) y validaciones de datos.

---

## 📂 Estructura del Código Fuente

```text
src/
 ├── controller/    # Controladores que gestionan los eventos de la GUI
 ├── model/         # Clases de datos (Usuario, Nota)
 ├── persistence/   # Gestión de archivos y persistencia (.txt / .dat)
 ├── utils/         # Lógica de seguridad (SHA-256) y validaciones
 └── view/          # Interfaces gráficas (JFrame, JPanel, Diálogos)
