package store;

import java.util.ArrayList;

	
	public class Item {
		
		String name;
		double manufactureCost;
		double retailPrice;
		String reorderPoint;
		int reorderAmount;
		double temperature;
		
		public Item(String name, double manufactureCost, int retailPrice, 
				String reorderPoint, int reorderAmount) {
			this.name = name;
			this.manufactureCost = manufactureCost;
			this.retailPrice = retailPrice;
			this.reorderPoint = reorderPoint;
			this.reorderAmount = reorderAmount;
		}

		public static void increasePrice(String string, int i) {
			// TODO Auto-generated method stub
		}

		public static int findItemCost() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void changeReorderAmount(String string, int i) {
			// TODO Auto-generated method stub
			
		}

		public static int findItemReorderAmount() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void changeReorderPoint(String string, String string2) {
			// TODO Auto-generated method stub
			
		}

		public static int findItemManufactureCost() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void increaseCost(String string, int i) {
			// TODO Auto-generated method stub
			
		}
	
	}



