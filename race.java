import java.util.Random;

// Part 1
// car class
class Car {
	// constructor
	public Car(String make, int year, String color, int speed) {
		this.make = make;
		this.year = year;
		this.color = color;
		this.speed = speed;
	}

	// getter
	public String getMake() {
		return this.make;
	}
	public int getYear() {
		return this.year;
	}
	public String getColor() {
		return this.color;
	}
	public int getSpeed() {
		return this.speed;
	}
	
	// setter
	public void setMake(String make) {
		this.make = make;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// accelerate method
	public void Accelerate() {
		if (this.year < 2010) {
			this.speed = this.speed + 15;
		} else {
			this.speed = this.speed + 30;
		}
	}
	
	// brake method
	public void Brake() {
		if (this.year < 2010) {
			this.speed -= 5;
		} else {
			this.speed -= 10;
		}
		if (this.speed < 0) {
			this.speed = 0;
		}
	}
	
	// stop method
	public void Stop() {
		this.speed = 0;
	}

	private String make;
	private int year;
	private String color;
	private int speed;
}

// calling class
public class race {
	//make cars
	public static Car[] makeCars() {
		// Make an array with space for 10 cars
		Car[] cars = new Car[10];

		// Make arrays for content of makes and colors
		String[] MAKES = { "BMW", "Ford", "Mazda" };
		String[] COLORS = { "Black", "White", "Grey" };
		Random r = new Random();

		for (int i = 0; i < 10; i++) {
			int year;
			// cars #1-5 are made after 2010
			if (i < 5) {
				year = r.nextInt(11) + 2010; // 2010-2020
			}
			// cars #6-10 are made before 2010
			else {
				year = r.nextInt(10) + 2000; // 2000-2009
			}
			// randomly select makes and colors from content arrays
			int makeIndex = r.nextInt(3);
			int colorIndex = r.nextInt(3);
			cars[i] = new Car(MAKES[makeIndex], year, COLORS[colorIndex], 0);
		}
		return cars;
	}
	
	public static void main(String[] args) {
		System.out.println("Part 1");
		Car[] madeCars = makeCars();
		
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			// pick a random car
			int carIndex = r.nextInt(10);
			Car car = madeCars[carIndex];
			// randomly select brake, accelerate, or stop methods
			int methodIndex= r.nextInt(3);
			if (methodIndex == 0) {
				car.Brake();
			}
			else if (methodIndex == 1) {
				car.Accelerate();
			}
			else if (methodIndex == 2) {
				car.Stop();
			}
		}
		for (int i = 0; i < 10; i++) {
			Car car = madeCars[i];
			System.out.println("The car number is: " + (i+1));
			System.out.println("The year is: " + car.getYear());
			System.out.println("The make is: " + car.getMake());
			System.out.println("The color is: " + car.getColor());
			System.out.println("The final speed is: " + car.getSpeed());
			System.out.println();
		}
		System.out.println("- - - - - - - - - - - - - - -");
		
		// Part 2
		// call car race
		System.out.println("Part 2");
		runRaces();
	}
	
	//car race
	public static int[] Race(Car[] raceCars){
		for (int i = 0; i < 10; i++) {
			raceCars[i].Stop();
		}
		Random r = new Random();
		boolean allFinish = false;
		float[] distances = new float[10];
		int[] places = new int[10];
		int placeCounter = 0;
		while (!allFinish) {
			//randomly pick a car from 10 car array
			int carIndex = r.nextInt(10);
			Car raceCar = raceCars[carIndex];
			//randomly select brake, accelerate, or stop for the picked car
			int methodIndex = r.nextInt(3);
			if (methodIndex == 0) {
				raceCar.Brake();
			}
			else if (methodIndex == 1) {
				raceCar.Accelerate();
			}
			else if (methodIndex == 2) {
				raceCar.Stop();
			}
			//calculate distances of each car
			for (int i = 0; i < 10; i++) {
				if (places[i] > 0) {
					continue;
				}
				distances[i] += raceCars[i].getSpeed() * (1/60f);
				if (distances[i] >= 100) {
					placeCounter += 1;
					places[i] = placeCounter;
					
				}
				if (placeCounter == 10) {
					allFinish = true;
				}
			}
		}
		return places;
	}
	public static void runRaces() {
		int[] totalPlaces = new int[10];
		float over2010Total = 0;
		float over2010Average = 0;
		float under2010Total = 0;
		float under2010Average = 0;
		float[] averagePlaces = new float[10];
		Car[] raceCars = makeCars();
		for (int i = 0; i < 100; i++) {
			int[] places = Race(raceCars);
			for (int j = 0; j < 10; j++) {
				totalPlaces[j] += places[j];
			}
		}
		for(int i = 0; i < 10; i++) {
			averagePlaces[i] = totalPlaces[i] / 100f;
			System.out.println("Car #" + (i+1));
			System.out.println("Year: " + raceCars[i].getYear());
			System.out.println("Average place: " + averagePlaces[i]);
			System.out.println();
		}
		for (int i = 0; i < 10; i++) {
			if (raceCars[i].getYear() >= 2010) {
				over2010Total += averagePlaces[i];
				over2010Average = over2010Total / 5f;
			}
			else {
				under2010Total += averagePlaces[i];
				under2010Average = under2010Total / 5f;
			}
		}
		System.out.println("the average place of cars with years after 2010 is: "+ over2010Average);
		System.out.println("the average place of cars with years before 2010 is: "+ under2010Average);
		System.out.println("More modern cars tend to do better in the race.");
	}
}