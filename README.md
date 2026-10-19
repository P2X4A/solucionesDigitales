# Digital Publishing System - solucionesDigitales

## Description

Management system for a digital publisher that handles books, magazines and research articles. Each publication type has its own entity, DTO and **DAO** implementation with file persistence (binary inventory and text sales file), and the interface runs on the console with **MVC** separation.

Academic project developed for the **Java programming** courses - Systems Engineering, Universidad El Bosque.

## Author

- Sergio Alejandro Parra Rivera

## Technologies

- Java 21 (compiled with `maven-compiler-plugin`)
- Maven 3.8+ with `exec-maven-plugin` to run the application
- **MVC** architecture (`controller`, `model`, `view`)
- **DAO** and **DTO** patterns with a `DataMapper`, one DAO per publication type
- Inheritance from the base class `PublicacionTienda`
- File persistence (`inventarioLibros.bin`, `ventaLibro.txt`)

## Requirements

| Requirement | Version | How to check |
| --- | --- | --- |
| JDK | 21 or higher | `javac -version` |
| Maven | 3.8 or higher | `mvn -v` |
| Git | Any recent version | `git --version` |

## Installation

Follow these steps exactly so the application runs on the first try.

### 1. Clone the repository

```bash
git clone https://github.com/P2X4A/solucionesDigitales.git
```

### 2. Enter the project folder

```bash
cd solucionesDigitales
```

> On Windows, if your path contains spaces, always quote it, for example: `cd "C:\Users\Example\Documents\solucionesDigitales"`.

### 3. Verify your environment

```bash
javac -version
mvn -v
```

Expected: JDK 21 (or higher) and Maven 3.8 (or higher). If any command fails, install or update that tool before continuing.

### 4. Compile the project

```bash
mvn clean compile
```

What success looks like:

- The console ends with `BUILD SUCCESS`.
- A `target/classes/` folder is created with the compiled classes.

## Running the application

```bash
mvn exec:java
```

The menu is displayed in the terminal: manage the catalog of books, magazines and research articles, and register sales. Sample data files are included in the repository.

Troubleshooting:

- `ClassNotFoundException` or missing main class: compile first with `mvn clean compile`.
- `UnsupportedClassVersionError`: your JDK is older than 21; install JDK 21 or higher and check it with `javac -version`.

## Main features

- **Publication types:** `Libro`, `Revista` and `ArticuloInvestigacion` extend the shared base `PublicacionTienda`.
- **Catalog management:** register and consult the publications of the digital store from `SistemaSolucionDigital`.
- **One DAO per entity:** `LibroDAOImpl`, `RevistaDAOImpl` and `ArticuloInvestigacionDAOImpl` each persist their own type behind the `IDAO` interface.
- **DTO and DataMapper:** each entity has its DTO (`LibroDTO`, `RevistaDTO`, `ArticuloInvestigacionDTO`) and a `DataMapper` converts between domain and record.
- **Persistence files:** the inventory is stored in `inventarioLibros.bin` and sales in `ventaLibro.txt`.

## Project structure

```text
solucionesDigitales/
├── pom.xml
├── README.md
├── LICENSE
├── inventarioLibros.bin                   # Binary inventory sample data
├── ventaLibro.txt                         # Sales sample data
└── src/
    └── co/edu/unbosque/
        ├── controller/
        │   ├── AplMain.java               # Entry point (main class)
        │   └── Controlador.java           # Application controller (MVC)
        ├── model/
        │   ├── PublicacionTienda.java     # Base publication class
        │   ├── Libro.java                 # Book entity
        │   ├── Revista.java               # Magazine entity
        │   ├── ArticuloInvestigacion.java # Research article entity
        │   ├── SistemaSolucionDigital.java # Store model
        │   └── persistence/
        │       ├── IDAO.java              # Data access interface
        │       ├── LibroDAOImpl.java
        │       ├── RevistaDAOImpl.java
        │       ├── ArticuloInvestigacionDAOImpl.java
        │       ├── *DTO.java              # Records per entity
        │       ├── DataMapper.java        # Domain object <-> DTO mapping
        │       └── FileHandler.java       # File reading and writing
        └── view/
            └── Consola.java               # Console interface
```
