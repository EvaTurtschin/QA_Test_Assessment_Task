import java.util.Scanner;

public class BatteryController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter throttle value (km/h) or type N to quit: ");
            String input = scanner.nextLine().trim(); 
            // read the entire line, trim spaces, and handle empty input (like pressing Enter)

            //Exit conditions
            if (input.equalsIgnoreCase("N")) {
                System.out.println("Exiting...");
                break;
            }

            // Parse input as number
            int throttleSignal;
            try {
                throttleSignal = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number or N to quit.");
                continue;
            }

            // Calculate battery state and power
            int batteryPower = throttleBatteryInteraction(throttleSignal);
            String batteryState = batteryState(batteryPower);

            // Warn if input was out of range and clamped
            if (throttleSignal < 0 || throttleSignal > 250) {
                System.out.println("Note: throttle input was out of range, clamped to " 
                                   + (throttleSignal < 0 ? 0 : 250));
            }

            // Print results
            System.out.println("Battery state: " + batteryState + " ; Battery power: " + batteryPower + " W");

            // Empty line for visual separation of iterations
            System.out.println();
        }
        scanner.close();
    }

// The task doesn’t specify behavior for out-of-range throttle values.
// Using real-world logic: such systems usually clamp inputs to safe limits.
    public static int throttleBatteryInteraction(int throttleSignal) {
        if (throttleSignal < 0) {          //limit values to [0;250] range
            throttleSignal = 0;
        } else if (throttleSignal > 250) {
            throttleSignal = 250;
        }
        return throttleSignal * 4;         // Calculate power (4 W per km/h)
    }

    public static String batteryState(int batteryPower) {
        return (batteryPower == 0) ? "OFF" : "ON";
    }
}
