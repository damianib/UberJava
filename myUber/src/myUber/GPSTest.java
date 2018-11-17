package myUber;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GPSTest {

	@Test
	void testDistance() {
		
		GPS A = new GPS(0, 0);
		GPS B = new GPS(0, 1);
		GPS C = new GPS(1, 0);
		assertTrue((GPS.distance(A, B)==1));
		assertTrue((GPS.distance(A, C)==1));
		
	}

	@Test
	void testTrajetPool() {
		
		GPS position = new GPS(0, 0);
		ArrayList<GPS> pickup = new ArrayList<GPS>();
		ArrayList<GPS> dropout = new ArrayList<GPS>();
		ArrayList<GPS> trajet = new ArrayList<GPS>();
		
		pickup.add(new GPS(1, 2));
		pickup.add(new GPS(-1, 3));
		dropout.add(new GPS(-2, 4));
		dropout.add(new GPS(1, 3));
		
		trajet.add(new GPS(1, 2));
		trajet.add(new GPS(-1, 3));
		trajet.add(new GPS(-2, 4));
		trajet.add(new GPS(1, 3));
		
		assertEquals(trajet, GPS.trajetPool(pickup, dropout, position));
	}

}
