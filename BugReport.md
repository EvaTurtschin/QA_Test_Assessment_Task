## BUG-REPORT-001
## Battery power drops to 30W on specific throttle levels ending in 3

### Environment:
- System info — battery firmware version, throttle model
- Test environment - test conditions (simulator or real car)

### Preconditions:

- Vehicle powered on.
- Second battery responsible for translating throttle signals.
- Throttle operational in range 0–250 km/h.

### Steps to Reproduce:

1. Start the car (from 0 km/h).
2. Set throttle to levels ending in 3 (13, 23, 33, 103, ... 243) → observe battery power.

### Expected Result:

- Battery power increases proportionally with throttle level, providing smooth acceleration.
- Example: 240 km/h → 960 W, 245 km/h → 980 W.

### Actual Result:

- Battery outputs 30 W whenever throttle level ends with 3, causing temporary drop in power and “buck” of the vehicle.
- Example: throttle at 240 km/h → 960 W, 241 → 964 W, 242 → 968 W, 243 → 30 W, 244 → 976 W, 245 → 980 W.

### Severity / Priority:

High / Critical: dangerous for vehicle operation.

### Additional Notes:

- Issue reproducible consistently at all throttle levels ending in 3.
- May indicate calculation or rounding bug in battery-throttle signal processing.

### Attachments

1. Chart / graph — a graph of battery power vs. throttle level, where the drop to 30 W is clearly visible.
2. Log files / step-by-step power values — a table or CSV showing throttle levels and the corresponding battery power.

Example:

| Throttle (km/h) |	Battery Power (W) |
|-----------------|-------------------|
| 240             |	960               |
| 241	          | 964               |
| 242	          | 968               |
| 243	          | `**30**`          |
| 244	          | 976               |
| 245	          | 980               |