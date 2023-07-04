
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Camera {
		int id;
		String model,status,brand;
		float price;
		Camera(int id,String brand,String model,float price){
			this.brand=brand;
			this.model=model;
			this.price=price;
			this.id=id;
			status = "Available";
		}
		
		
		
		//Delete Cameras
		static boolean remove(ArrayList<Camera> cam, int key) {
				for(int i=0;i<cam.size();i++) {
					if(cam.get(i).id == key) {
						if(cam.get(i).status.equals("Available")) {
						cam.remove(cam.get(i));
						return true;
						}else {
							System.out.println("CAMERA IS ALREADY RENTED");
							return false;
							}
					}
				}
				System.out.println("NO CAMERA WITH ID = "+key);
				return false;
				
		
			}
		
			//Display Cameras
			static void display(ArrayList<Camera> cam) {
				System.out.println("=======================================================================");
				System.out.println("   CAMERA_ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
				System.out.println("=======================================================================");
					for(Camera c:cam) {
						System.out.println("  \t"+c.id+"\t"+c.brand+"\t"+c.model+"\t"+c.price+"\t      "+c.status);
				}
				System.out.println("=======================================================================");
				
			}
			
			//Display Available cameras
			static void displayAvailable(ArrayList<Camera> cam) {
				System.out.println("=======================================================================");
				System.out.println("   CAMERA_ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
				System.out.println("=======================================================================");
					for(Camera c:cam) {
						if(c.status.equals("Available")) {
								System.out.println("  \t"+c.id+"\t"+c.brand+"\t"+c.model+"\t"+c.price+"\t      "+c.status);
						}
				}
				System.out.println("=======================================================================");
				
			}
			
			
		//Add Cameras
		static void add(ArrayList<Camera> cam,int id) {
				Scanner sc = new Scanner(System.in);
				String brand,model;
				float price;
				try {
				System.out.println("ENTER THE CAMERA BRAND - ");
				brand=sc.nextLine();
				System.out.println("ENTER THE CAMERA MODEL - ");
				model=sc.nextLine();
				System.out.println("ENTER THE PER DAY PRICE (INR) - ");
				price=sc.nextFloat();
				cam.add(new Camera(id,brand,model,price));
				System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST");
				}catch(InputMismatchException e ) {
					System.out.println(" INPUT CORRECT VALUES");
				}
				
				
		}
		
		//rent camera
		
		public static void rentCam(ArrayList<Camera> cam, int key) {
			int found = 0;
			for(int i=0;i<cam.size();i++) {
				
					if(cam.get(i).id==key) {
						if(cam.get(i).status.equals("Available")) {
							if(Wallet.getBal()>=cam.get(i).price) {
								cam.get(i).status ="Rented";
								Wallet.setBal(Wallet.getBal()- cam.get(i).price);
								System.out.println("YOUR TRANSACTION FOR CAMERA :"+cam.get(i).brand+" "+cam.get(i).model+" WITH RENT "+cam.get(i).price+" HAS SUCCESFULLY COMPLETED");
								found = 1;
								break;
							}else {
								System.out.println("TRANSACTION FAILED DUE TO INSSUCFICENT WALLET BALANCE .PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET");
								found = 1;
								break;
							}
						}else {
							System.out.println("CAMERA ALREADY RENTED");
							found = 1;
							break;
						}
					}
			}	
			if(found ==0) {
				System.out.println("NO CAMERA WITH ID = "+key);
			}
			
		}

}
