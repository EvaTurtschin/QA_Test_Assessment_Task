# Battery-Throttle Interaction Testing Plan

This document describes test scenarios for verifying the interaction between the battery and throttle logic in `BatteryController.java`. The focus is on validating correct system behavior, edge cases, and failure states.

---

## 1. Normal Scenarios

| Input (Throttle, km/h) | Expected Battery State | Expected Power (W) |
|------------------------|------------------------|--------------------|
| 0                      | OFF                    | 0                  |
| 50                     | ON                     | 200                |
| 250                    | ON                     | 1000               |

See `README.md` for instructions on running these tests.

---

## 2. Boundary Values

| Scenario                      | Input Value | Expected Behavior                              |
|-------------------------------|-------------|------------------------------------------------|
| Minimum throttle              | 0           | OFF, 0W                                        |
| Maximum throttle              | 250         | ON, 1000W                                      |
| Below minimum (negative)      | -20         | Clamped to 0, OFF, 0W                          |
| Above maximum                 | 300         | Clamped to 250, ON, 1000W                      |

See `README.md` for execution steps.

---

## 3. Invalid Input Handling

| Input Example | Expected Behavior                             |
|---------------|-----------------------------------------------|
| `"abc"`       | Print error message: "Invalid input..."       |
| `""` (empty)  | Print error message                           |
| `" "` (space) | Print error message                           |
| `"N"` or `"n"`| Program exits gracefully                      |

See `README.md` for execution steps.

---

## 4. Failure States to Consider

Potential scenarios to think about for future testing, even if not fully modeled in the current code:

- Lost or unreadable throttle signal → should default to `0 km/h`.
- Corrupted battery power values (negative numbers) → should be rejected/reset.
- System stability with repeated inputs at high frequency.
- Overflow or unexpected large values → currently clamped.

---

This plan is focused only on defining **what** to test.  
For setup and usage instructions, see `README.md`.
