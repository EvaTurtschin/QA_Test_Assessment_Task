# Arsipa QA Test Task

This repository contains a **technical test assignment** for QA Engineer candidate Evgeniya Turtschina at Arsipa.  
The [task](/TaskDescription.md) is to code up a basic function that replicates the interaction of the battery and the throttle and to describe how I would approach testing the interaction between this two components.

---

## Project Structure

| File                     | Description |
|--------------------------|-------------|
| [BatteryController.java](/BatteryController.java) | Main program. Reads throttle input, calculates battery power and state. |
| [TEST_PLAN.md](/TestPlan.md)           | Detailed test plan with normal, boundary, and failure scenarios. |
| [README.md](/README.md)              | Project overview, setup instructions, and usage guide. |

---

## Requirements

- **Java Development Kit (JDK)**: Version 17 or later  
- **VS Code** (optional): With [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) installed

---

## How to Run

### Option 1: Run in VS Code
1. Install VS Code and the Java Extension Pack.  
2. Open the project folder (`Arsipa_QA_Test_Task`) in VS Code.  
3. Open (`BatteryController.java`).  
4. Click **Run** (▶️) in the top right corner of the editor.  
5. Follow the console prompts to enter throttle values.  
   - Enter a number (**0–250**) to simulate throttle.  
   - Enter **N** to exit the program.

---

### Option 2: Run from Terminal
1. Make sure `javac` and `java` are available in your PATH:
   ```bash
   javac -version
   java -version

2. Compile the program:
   ```bash
   javac BatteryController.java


3. Run the compiled program:
   ```bash
   java BatteryController


4. Enter throttle values in the console:

- Numbers between **0–250** → battery power calculated

- Out-of-range values → clamped to safe limits

- Enter **N** to quit

### Example Session
   ```bash
   Enter throttle value (km/h) or type N to quit: 50 
   Battery state: ON ; Battery power: 200 W
   ```
   ```bash
   Enter throttle value (km/h) or type N to quit: 300 
   Note: throttle input was out of range, clamped to 250
   Battery state: ON ; Battery power: 1000 W
   ```
   ```bash
   Enter throttle value (km/h) or type N to quit: _t
   Invalid input. Enter a number or N to quit.
   Enter throttle value (km/h) or type N to quit:
   ```
   ```bash
   Enter throttle value (km/h) or type N to quit: N
   Exiting...
   ```

### Testing

See [TEST_PLAN.md](/TestPlan.md) for:

- [Normal scenarios](/TestPlan.md/#1-normal-scenarios)

- [Boundary cases](/TestPlan.md/#2-boundary-values)

- [Invalid input handling](/TestPlan.md/#3-invalid-input-handling)

- [Potential failure states](/TestPlan.md/#4-failure-states-to-consider)
