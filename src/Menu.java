import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
		public static void main(String[] args) {
			Login.login();
		}
	
	public static void welcomePage(String uname) {
		System.out.println("+---------------------------------------+");
		System.out.println("|  WELCOME TO CAMERA RENTAL APP "+uname.toUpperCase()+" |");
		System.out.println("+---------------------------------------+");
		ArrayList<Camera> cam = new ArrayList<Camera>();
		cam.add(new Camera(1, "Nikon", "DSLR12", 200));
		cam.add(new Camera(2, "Samsung", "SM123", 200));
		cam.add(new Camera(3, "SONY", "DSLR-5", 2100));
		cam.add(new Camera(4, "Canon", "5000", 25000));
		int id=cam.size()+1;

		CamMenu(cam,id);
	}
//Main Menu
	static void CamMenu(ArrayList<Camera> cam, int id){
		
		int op = 0,key;
		Scanner sc = new Scanner(System.in);
	
		do {
			try {
			System.out.println("1. MY CAMERA \n2. RENT A CAMERA \n3. VIEW ALL CAMERAS \n4. MY WALLET \n5. EXIT");
			
			op = sc.nextInt();
			switch(op){
						case 1: menu(cam,id);
								break;
						case 2: Camera.display(cam);
								System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT - ");
								key=sc.nextInt();
								Camera.rentCam(cam,key);
								break;
						case 3: Camera.display(cam);
								break;
						case 4: walletfn();
								break;
						case 5: System.exit(0);
								break;
						default: System.out.println("ENTER CORRECT INPUT");
								break;
			}
			}catch (InputMismatchException e) {
				System.out.println("ENTER CORRECT INPUT");
				sc.nextLine();
			}
		}while(true);
		}

		
		
	

	//MyCamera SubMenu
		private static void menu(ArrayList<Camera> cam,int id)throws InputMismatchException {
			int opt,key;
			Scanner sc = new Scanner(System.in);
			

			do { 
				try {
				System.out.println("1. ADD \n2. REMOVE \n3. VIEW MY CAMERAS \n4. GOT TO PREVIOUS MENU");
				opt = sc.nextInt();
				switch(opt){
							case 1: Camera.add(cam,id);
									id++;
									break;
							case 2: Camera.display(cam);
									System.out.println("ENTER CAMERA ID TO REMOVE - ");
									key=sc.nextInt();
									Camera.remove(cam,key);
									break;
							case 3: Camera.display(cam);
									break;
							case 4:CamMenu(cam,id); 
									break;
							default: System.out.println("ENTER CORRECT INPUT");
							break;
				}
				}catch (InputMismatchException e) {
					System.out.println("ENTER CORRECT INPUT");
					sc.nextLine();
				}
			}while(true);
			}
			
		
		
		
		//view and add money
		private static void walletfn() {
					System.out.println("YOUR CURRENT WALLET BALANCE IS - INR."+Wallet.getBal());
					Scanner sc = new Scanner(System.in);
					float bal;
					int choice;
					try {
					System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?( 1.YES 2. NO)");
					choice = sc.nextInt();
					if(choice == 1) {
					System.out.println("ENTER THE AMOUNT (INR): ");
					bal = sc.nextFloat();
					Wallet.setBal(Wallet.getBal()+bal);
					}
					}catch(InputMismatchException e) {
						System.out.println("Enter Correct Option");
					}
		
	}

}
