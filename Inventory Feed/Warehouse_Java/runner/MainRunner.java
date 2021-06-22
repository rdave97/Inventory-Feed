package runner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import controllers.DBController;
import models.Product;

public class MainRunner {

	public static void main(String[] args) {
		
		TimerTask task = new MainTask();
		Timer timer = new Timer();
		
		
		timer.schedule(task, 100, 5000);
		
	}

}

class MainTask extends TimerTask{
	public void run() {
		try {
			String line;
			int lineNumber = 1;
			int reachedProductID = -1, reachedQuantity = -1;
			List<Product> productsList = new ArrayList<Product>();
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/rudra/Downloads/test.csv"));
			while((line = br.readLine()) !=null) {
				String[] values = line.split(",");
				if(lineNumber == 1) {
					for (int i = 0; i < values.length; i++) {
						if(values[i].equalsIgnoreCase("product") || values[i].equalsIgnoreCase("productid")) {
							reachedProductID = i;
						} else if(values[i].equalsIgnoreCase("quantity")) {
							reachedQuantity = i;
						}
					}
					lineNumber++;
				}
				else if(reachedProductID == -1 || reachedQuantity == -1) {
					System.out.println("No suitable column found for product ID or product quantity");
					break;
				}
				else {
					System.out.println("Product ID -> "+values[reachedProductID]);
					System.out.println("Quantity -> "+values[reachedQuantity]);
					productsList.add(new Product(values[reachedProductID], Integer.parseInt(values[reachedQuantity])));
					
				}
			}
			br.close();
			boolean result = new DBController().addData(productsList);
			if(result) {
				System.out.println("Insertion successful");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
