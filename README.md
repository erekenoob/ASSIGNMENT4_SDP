# Smart Workspace Automation — Facade Design Pattern

##  Table of Contents
1. [Overview](#-1-overview)
2. [Design Pattern Context](#-2-design-pattern-context)
3. [Project Architecture & Structure](#️-3-project-architecture--structure)
4. [Component Responsibilities](#-4-component-responsibilities)
5. [Clean Code & Design Principles](#-5-clean-code--design-principles)
6. [Error Handling Mechanism](#️-6-error-handling-mechanism)

---

##  1. Overview
This project is developed as part of **Assignment #4** for the course **ShP-2216 – Software Design Patterns (OP 6B06102)**. It implements the **Facade Structural Design Pattern** applied to an automated smart office / smart workspace scenario (`Smart Workspace`).

Modern automated workspaces involve multiple complex, heterogeneous subsystems—such as motorized curtains, multi-zone lighting systems, streaming media players, height-adjustable ergonomic desks, developer workstations, and IoT coffee machines. Coordinating all these devices manually creates high coupling and boilerplate code. The **`SmartWorkspaceFacade`** solves this by providing a unified, high-level interface (`startWorkSession()` and `endWorkSession()`) to orchestrate the entire environment seamlessly.

---

##  2. Design Pattern Context
Following the principles of the Gang of Four (GoF) and educational materials (*Head First Design Patterns*), the **Facade Pattern** is used here to:
* **Simplify Complexity:** Hide intricate multi-step initialization sequences and hardware interactions behind clear, task-oriented methods.
* **Reduce Coupling:** Decouple the client code from the inner workings and dependencies of individual subsystem classes.
* **Preserve Full Access:** Keep subsystem classes completely public and independent so that advanced clients can interact with them directly if granular control is required.

---

##  3. Project Architecture & Structure

The project is structured into clear packages to separate concerns and comply with clean code standards:

```text
SmartWorkspaceProject/
├── src/
│   ├── Main.java                          // Client (Test drive / Entry point)
│   ├── facade/
│   │   └── SmartWorkspaceFacade.java      // Main Facade coordinating subsystems
│   ├── subsystem/
│   │   ├── SmartCurtains.java             // Subsystem: Curtains control
│   │   ├── LightingSystem.java            // Subsystem: Main & ambient lights
│   │   ├── SpotifyPlayer.java             // Subsystem: Music streaming & playlists
│   │   ├── ErgonomicDesk.java             // Subsystem: Motorized height adjustment
│   │   ├── WorkstationPC.java             // Subsystem: Power and profile loader
│   │   └── CoffeeMachine.java             // Subsystem: Resource validation & batch-brew
│   └── exception/
│       └── SubsystemException.java        // Custom exception for error handling
└── README.md
```

---

##  4. Component Responsibilities

* **Client (`Main.java`)**: 
  Instantiates the individual subsystem components, injects them into the Facade via constructor composition, and interacts **solely** through the Facade's high-level methods.
* **Facade (`SmartWorkspaceFacade.java`)**: 
  Acts as a concierge, knowing precisely which methods to invoke across the subsystem in what order to achieve a desired state (`startWorkSession` or `endWorkSession`).
* **Subsystem Classes (`subsystem/`)**: 
  A collection of 6 autonomous, non-trivial classes (`SmartCurtains`, `LightingSystem`, `SpotifyPlayer`, `ErgonomicDesk`, `WorkstationPC`, `CoffeeMachine`). They operate independently and remain entirely unaware of the Facade's existence.

---

## 5. Clean Code & Design Principles

The codebase adheres strictly to core Clean Code guidelines:
* **Meaningful & Intention-Revealing Names:** Methods and classes use descriptive terminology (e.g., `startWorkSession()`, `enableAmbientLight()`, `brewBatch()`) making comments redundant.
* **Single Responsibility Principle (SRP):** The Facade's sole responsibility is *coordination*. Low-level execution logic (such as adjusting motors or checking water levels) resides exclusively inside the respective subsystem devices.
* **No Leaking of Subsystem Details:** The public API of the Facade exposes high-level business actions rather than forcing the client to handle internal hardware parameters or raw configurations.
* **Small, Focused Methods:** Complex routines are cleanly structured into logical sequences to maintain a single level of abstraction.

---

## 6. Error Handling Mechanism
To ensure robust performance and satisfy error-handling criteria:
* A custom runtime exception (`SubsystemException`) is integrated into resource-dependent subsystems (e.g., the `CoffeeMachine` verifies water and coffee bean levels before starting).
* If a subsystem fails or lacks resources, it throws a descriptive `SubsystemException`, which is caught and handled gracefully by the Facade block without crashing the entire application thread.

---

