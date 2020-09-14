Race Cars

PART I
Construct a calling class and a Car class as follows:
Car Class:
Properties:  Make (String), Year(int), Color(String), Speed (int)
Methods:  
•	All getter, setter methods
•	Accelerate ( increase speed :  15MPH if year < 2010,  30 MPH >= 2010)
•	Brake ( lower speed :   5MPH if year < 2010,  10 MPH >= 2010, speed always >=0)
•	Stop (speed = 0)

Calling Class
Create an array of 10 cars. Give them random colors and makes from a set of choices you create. Select a random year for a car, but when done, half the cars should have a year >=2010.  Initial Speed for all cars is zero.
Do the following 100 times
•	Pick a random car
•	Randomly select Brake, Accelerate or Stop method (equal probabilities)
•	Invoke the selected method chosen for the car chosen
After the loop, print out all the car number, year, make, color and final speed.

Part II
Simulate a race.  Each car starts at zero. Make a loop where the body of the loop does the three bullet points above. However, in this part, each iteration of the loop represents one minute of time. During the loop, randomly pick a car and randomly change its speed (Break Accelerate, Stop). After each iteration of the loop, calculate the distance travelled by each car that has a speed >0. Keep track of each car’s total distance. When a car reaches 100 miles, it is the winner. Keep the race going until all cars finish. Note the car in second place, third place, etc. Keep track of the average place of each car. Print out each car its year, and the average place it finished in the race.
Run 100 races,  and store the place result for each car for analysis.
Analysis:  Do more modern cars that go faster tend to do better in the race?
