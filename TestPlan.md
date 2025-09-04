# Battery-Throttle Interaction Testing Plan

This document describes test scenarios for verifying the interaction between the battery and throttle logic in [BatteryController.java](BatteryController.java). The focus is on validating correct system behavior, edge cases, and failure states.

---

## 1. Normal Scenarios

| Input (Throttle, km/h) | Expected Battery State | Expected Power (W) |
|------------------------|------------------------|--------------------|
| 0                      | OFF                    | 0                  |
| 50                     | ON                     | 200                |
| 250                    | ON                     | 1000               |

See `README.md` for execution steps.

---

## 2. Boundary Values
It is a safety-critical system, so I'd choose the triple-boundary value check for it.

| Scenario                      | Input Value | Expected Behavior                              |
|-------------------------------|-------------|------------------------------------------------|
| Just below Minimum throttle   | -1          | Clamped to 0, OFF, 0W                          |
| Minimum throttle              | 0           | OFF, 0W                                        |
| Just above Minimum throttle   | 1           | ON, 4W                                         |
| Just below Maximum throttle   | 249         | ON, 996W                                       |
| Maximum throttle              | 250         | ON, 1000W                                      |
| Just above Maximum            | 251         | Clamped to 250, ON, 1000W                      |

See `README.md` for execution steps.

---

## 3. Invalid Input Handling

| Input Example             | Expected Behavior                             |
|---------------------------|-----------------------------------------------|
| `"abc"`                   | Print error message: "Invalid input..."       |
| `""` (empty)              | Print error message                           |
| `" "` (space)             | Print error message                           |
| (unexpected large values) | Print error message                           |
| `"-0"`                    | Read as 0, OFF, 0W                            |
| `"N"` or `"n"`            | **Exit case**: Program exits gracefully       |

See `README.md` for execution steps.

---

## 4. Failure States to Consider

Potential scenarios to think about for future testing, even if not fully modeled in the current code:

- Saturation/clamp behavior clearly defined.
- Lost or unreadable throttle signal → should default to `0 km/h`.
- Corrupted battery power values (negative numbers) → should be rejected/reset.
- System stability with repeated inputs at high frequency.
- Large or extreme numbers outside expected range → should be handled gracefully.
- Battery not switching state instantly with throttle change.
- Sudden power spikes or drops with small throttle changes.
- Implimentation Considerations, as Input/output types (int vs float)
- Rounding rules for integer-only interfaces.
- How system handles simultaneous or repeated inputs.

---

This plan is focused only on defining **what** to test.  
For setup and usage instructions, see `README.md`.
