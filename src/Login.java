import java.util.Scanner;

/* username = admin , passoword = admin*/

public class Login {

	public static void login() {
		String uname,pswd;
		Scanner sc = new Scanner(System.in);
		System.out.println("+--------------------------------+");
		System.out.println("|  WELCOME TO CAMERA RENTAL APP  |");
		System.out.println("+--------------------------------+");
		do {
		System.out.println("PLEASE LOGIN TO CONTINUE - ");
		System.out.println("USERNAME - ");
		uname = sc.nextLine();
		System.out.println("PASSWORD - ");
		pswd = sc.nextLine();
		if(uname.equalsIgnoreCase("admin") && pswd.equals("admin")) {
			Menu.welcomePage(uname);//if login details correct call main class
			break;
		}else {
			System.out.println("Invalid Details Provided ........\nTry Again .....\n");//else repeat
		}
		}while(true);
		
	}

}
