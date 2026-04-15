# First practices with Java

> [!NOTE]
> This repository contains my first Java practice projects (started in 2022). It is organized as small, topic-based exercises for learning fundamentals.

> [!IMPORTANT]
> The purpose of this repo is educational: keep a personal learning record and help beginners with simple reference examples.

## What you will find here

This workspace groups independent mini-projects covering:
- Java basics (`Scanner`, operators, strings, primitive types)
- Object-oriented programming (classes, relationships, enums, inheritance)
- Data structures (queues and linked lists)
- Console applications and simple menus
- Intro functional programming practice in Java

## Project map

- `01 myfirstprogram-java/`
  - First package structure practice.
  - Current file: `CalculadoraEdad.java` (base class scaffold).

- `02 HelloWorld/`
  - Fundamental Java exercises.
  - Includes classes like `HolaMundo`, `ConversionDeTipos`, `OperadoresLogicos`, `SistemasNumericosEntradaScanner`, and string-focused examples.

- `03 exercisms-Java/`
  - Small algorithmic experiments.
  - Current `Main.java` asks for rectangle base/height and calculates area.

- `04 calculadora-notas-java/`
  - Basic semester grade calculator.
  - Uses `main.java` + `notasUPSE.java` for weighted grade calculations and final result.

- `05 empleados-java/`
  - Simple employee model.
  - Includes `Trabajador`, `Empleado`, and `consultor` with a demo in `Main.java`.

- `edd-colas-java/`
  - Queue implementation with custom node structure.
  - Interactive console menu in `main.java` (`Push`, `Pop`, list queue).

- `edd-listasEnlazadas-java/`
  - Linked list practice with students.
  - `Main.java` provides a CRUD-style menu over linked nodes.

- `poo-automovil-java/`
  - OOP car domain example.
  - Classes: `Automovil`, `Motor`, `Estanque`, `Rueda`, `Persona`, enums (`Color`, `TipoMotor`, `TipoAutomovil`) and several runnable demos (`EjemploAutomovil*`).

- `poo-InDriverDemo-java/`
  - Console simulation of a transport app flow.
  - Features registration, payment options, trip request, and rating.

- `PF-ProgramacionFuncional/`
  - Functional programming practice in Java.
  - Includes examples such as `P1`, `P2`, `AnalisisDePureza`, `ConfiguracionInmutable`, and `InventarioProducto`.

## Quick start

### Requirements
- JDK 8+ (recommended: JDK 17)
- IntelliJ IDEA (recommended) or command line `javac`/`java`

### Run from IntelliJ IDEA
1. Open the root folder: `java-firstPractices`.
2. Select any subproject/module.
3. Open a class with `main` and run it.

### Run from terminal (example)
Use one folder at a time. Example with `02 HelloWorld/src`:

```powershell
Set-Location "C:\Users\jonat\IdeaProjects\java-firstPractices\02 HelloWorld\src"
javac HolaMundo.java
java HolaMundo
```

## Suggested learning path
1. `02 HelloWorld`
2. `03 exercisms-Java`
3. `04 calculadora-notas-java`
4. `05 empleados-java`
5. `poo-automovil-java`
6. `edd-colas-java` and `edd-listasEnlazadas-java`
7. `PF-ProgramacionFuncional`

---
If you are starting with Java, this repository is intended to be read and executed step by step, project by project.
