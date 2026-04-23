# HardcodedCalculator — JavaFX
A desktop calculator that refuses to compute anything directly. Instead, it writes a brand-new
Java source file for your expression, compiles it, runs it as a subprocess, and reads the
result back from a text file. Why? Because it can.

## Features
- Addition, subtraction, multiplication, division
- Decimal input support
- Full clear (AC) and display clear
- Dynamically generates, compiles, and executes a unique Java class per calculation
- Spawns two threads per calculation to capture stdout and stderr from the child process
- Fails if it can't hardcode the answer: *"I couldn't hardcode myself to do this :("*

## Tech Stack
- **Language:** Java
- **UI:** JavaFX (FXML + Controller)
- **Build:** Maven
- **Compilation:** Runtime `javac` via `Runtime.getRuntime().exec()`
- **IPC:** Text file (`result.txt`)

## How It Works
```
User presses =
    ↓ 
CalcMain generates HardcodedCalc.java with operands baked in
    ↓ 
javac compiles the file into bytecode
    ↓ 
java executes the class as a subprocess
    ↓
Result written into result.txt
    ↓
CalculatorController reads file and displays answer
```

## Setup
1. Clone the repository
2. Ensure Java 17+ and JavaFX SDK are installed
3. Open in IntelliJ IDEA or your preferred IDE with Maven support
4. Run via Maven:
```
mvn javafx:run
```

## Status
Complete and functional. Every button works. Every calculation spawns a compiler.
No regrets.

---
MIT License — see LICENSE for details
