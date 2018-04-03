/***************************************************
 * Serialization Demo
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pizza.Pizza;

public class Main {

	public static void main(String[] args) {
		Pizza myPizza = new Pizza(12, "thin");
		String pizzaFile = "pizza.dat";
		writePizza(myPizza, pizzaFile);
		
		Pizza newPizza = readPizza(pizzaFile);
		System.out.println("Serialized Pizza: size = " + newPizza.getSize() + " crust = " + newPizza.getCrust());
		
	}
	/***
	 * Write a Pizza object to a file
	 * @param pizza The Pizza object
	 * @param fileName The target file
	 * @return True on success, false otherwise
	 */
	public static boolean writePizza(Pizza pizza, String fileName) {
		boolean status = true;
		ObjectOutputStream oStream = null;
		try {
			// Needs to be wrapped in try/catch
			oStream = new ObjectOutputStream(new FileOutputStream(fileName));
			oStream.writeObject(pizza);		// Writes to the root directory of the Eclipse project			
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		} finally {
			try {oStream.close();} catch (Exception ex) {} // Eat the exception. Is this a good idea?
		}
		return status;
	}
	/***
	 * Read a Pizza object from a file
	 * @param fileName The file containing the Pizza object
	 * @return The Pizza that was read from the file, or null.
	 */
	static Pizza readPizza(String fileName) {
		ObjectInputStream iStream = null;
		Pizza pizza = null;
		try {
			// Needs to be wrapped in try/catch
			iStream = new ObjectInputStream(new FileInputStream(fileName));
			pizza = (Pizza)iStream.readObject();		// Note the type cast			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {iStream.close();} catch (Exception ex) {} // Eat the exception. Is this a good idea?			
		}
		return pizza;
	}
}
