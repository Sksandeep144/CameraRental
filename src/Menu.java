import java.util.ArrayList;
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
		int id=1;

		CamMenu(cam,id);
	}
//Main Menu
	static void CamMenu(ArrayList<Camera> cam, int id) {
		
		int op,key;
		Scanner sc = new Scanner(System.in);
		do {
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
			}
		}while(true);

		
		
	}

	//MyCamera SubMenu
		private static void menu(ArrayList<Camera> cam,int id) {
			int opt,key;
			Scanner sc = new Scanner(System.in);
			do { 
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
					}catch(Exception e) {
						System.out.println("WRONG INPUTS");
					}
		
	}

}
