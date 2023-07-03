
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
		static void remove(ArrayList<Camera> cam, int key) {
				for(int i=0;i<cam.size();i++) {
					if(cam.get(i).id == key) {
						if(cam.get(i).status.equals("Available")) {
						cam.remove(cam.get(i));
						System.out.println("CAMERA SUCCESFULLY REMOVED FROM LIST.");
						break;
						}else {
							System.out.println("CAMERA IS ALREADY RENTED");
							break;
							}
					}else if(cam.get(i).id!=key) {
						System.out.println("NO CAMERA WITH ID = "+key);
						break;
					}
				}
		
			}
		
			//Display Cameras
			static void display(ArrayList<Camera> cam) {  
					for(Camera c:cam) {
						System.out.println(c.id+" "+c.brand+" "+c.model+" "+c.price+" "+c.status);
				}
				
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
				}catch(InputMismatchException e ) {
					System.out.println(" INPUT CORRECT VALUES");
				}
				
				
		}
		
		//rent camera
		public static void rentCam(ArrayList<Camera> cam, int key) {
			for(int i=0;i<cam.size();i++) {
				if(cam.get(i).id == key && cam.get(i).status.equals("Available")&& Wallet.getBal()>=cam.get(i).price) {
					cam.get(i).status ="Rented";
					Wallet.setBal(Wallet.getBal()- cam.get(i).price);
					System.out.println("YOUR TRANSACTION FOR CAMERA :"+cam.get(i).brand+" "+cam.get(i).model+" WITH RENT "+cam.get(i).price+" HAS SUCCESFULLY COMPLETED");
					break;
				}else if(cam.get(i).status.equals("Rented")) {
					System.out.println("CAMERA IS ALREADY RENTED");
					break;
				}else if(Wallet.getBal()<=cam.get(i).price) {
					System.out.println("TRANSACTION FAILED DUE TO INSSUCFICENT WALLET BALANCE .PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET");
					break;
				}else if(cam.get(i).id != key) {
					System.out.println("NO CAMERA WITH ID = "+key);
				}
			}
			
		}

}
