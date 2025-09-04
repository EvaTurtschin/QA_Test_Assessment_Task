# Task Description #

## Task 1: Testing Functionality ##

Assume you work at a plant manufacturing electric cars and that you oversee the production lines for batteries and throttles. While the primary function of a battery is to hold a charge that powers each car, it is also responsible for translating a driver's signals from the throttle into the speed of the car. For the sake of this exercise, let's focus on this interaction between the battery and throttle. Your job is to make sure that batteries and throttles are being manufactured in a way that allows them to function properly and safely and to thoroughly test their interactions before sending them down the line.

Let's first identify our assumptions and the specifications of each component (simplified from real life):

Each car has two batteries. The following assumptions apply:

* The first is always ON as long as the car is running which keeps all critical functions engaged.
* The second is specifically allocated to translating signals from the throttle into the car's speed.
* The second battery is our battery of interest for this exercise -- the first can be more or less ignored.
* We can also ignore the concept of reverse for this exercise and only focus on forward movement.

The second battery has the following specifications:

* OFF = default state when throttle is AT-REST and the car is idling at 0 km/h
* ON = state when throttle is ENGAGED (i.e. >0) translating into some positive speed
* MIN POWER (0 watts) = the lowest amount of power that can be allocated to propelling the car
* MAX POWER (1,000 watts) = the highest amount of power that can be allocated to propelling the car

The throttle has the following specifications:

* AT-REST = default state when the throttle is not ENGAGED and the car is idling at 0 km/h
* ENGAGED = state when the throttle is signaling the car to move forward at some positive speed
* MIN LEVEL (0 km/h) = the lowest level on the throttle translating to no forward movement
* MAX LEVEL (250 km/h) = the highest level on the throttle translating to maximum speed of forward movement

Now, let's consider the interaction between the battery and the throttle:

* When the throttle is AT-REST at its MIN LEVEL (0 km/h), the battery should be receiving no signal, OFF, and generating MIN POWER (0 watts).
* When the throttle is ENGAGED at its MAX LEVEL (250 km/h), the battery should be receiving a signal, ON, and generating MAX POWER (1,000 watts).
* When the throttle is ENGAGED at any level between its MIN and MAX, the battery should receiving a signal, ON, and generating a corresponding level of power between its MIN and MAX.
* Example: The throttle is ENGAGED at 50 km/h, the battery is receiving a signal, ON, and generating 200 watts of power.

Your challenge is to code up (in your language of choice or even psuedocode) a basic function that replicates the interaction of the battery and the throttle with the level of the throttle as an input and the power level of the battery as an output. Once complete, describe in comments below your function how you would approach testing the interaction between the two components. Consider as many fail states for the two components and their interaction as possible and enumerate them. For those fail states that can be modeled with your function, also provide test cases in the comments as well with any necessary instructions for how to execute them (e.g. The throttle cannot send negative values to the battery; throttle = -20 --> battery = -80 is invalid; to test: print(battery(-20))). 

## Task 2: Bug Reports ##

Now, assume you are testing the batteries and throttles described above and encounter a bug where every time you set the throttle to a level ending in 3 (e.g. 3, 13, 23, 53, 103, etc.), the amount of power returned by the battery is 30 watts. This is obviously problematic, since moving from a throttle level of, say, 50 km/h to 55 km/h should translate to a steady increase in power from the battery and smooth acceleration, but instead it results in a temporary drop in power and speed, causing the car to "buck".

Your challenge is to file a Bug Report describing the behavior, your associated testing, and any details you think are sufficient for other testers and engineers to understand the problem and to inform subsequent investigation and, hopefully, resolution of this dangerous defect.

## Task Submission ##

Please create a directory containing all files you created for this challenge, the report containing the bug reports and an .md file with instructions how to setup your project and run the tests. You can either create a *private* repo and add us as contributors or send us your solution as .zip.