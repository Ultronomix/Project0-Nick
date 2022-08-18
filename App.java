import java.util.Scanner;

class App {
	public static void main(String[] args) {
		// Check for commandline args
		if (args.length > 0) {
			// App -n Name
			for(int i = 0; i < args.length; i++) {
				switch(args[i]) {
					case "--name":
					case "-n":
						System.out.println("Hello, "  + args[i+1] + "!");
						break;
					default:
						System.out.println("Unkown arg: " + args[i] + "\nUsage: App [-n] Name");
						break;
				}
			}
			// System.out.println("Hello, " + args[0]);
		} else {
			// if no args, then check stdin
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNext()) {
				String name = scanner.nextLine();
				System.out.println("Hello, " + name + "!");
			} else {
				// if no args and no stdin
				System.out.println("Hello World!");
			}
			scanner.close();
		}
	}	
}
