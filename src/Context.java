import java.util.Map;
import java.util.Scanner;

public class Context {
	private String name;

	public Context(String[] args) {
		parseArgs(args);
	} // Context

	public void parseArgs(String[] args) {
		String name = "World";
			if (args.length > 0) {
				//  Loop through and set up flags
				for(int i = 0; i < args.length; i++) {
					switch(args[i]) {
						case "--name":
						case "-n":
							name = args[i+1];
							i++;
							break;
						case "--interactive":
						case"-i":
							//options.replace("interactive", true);
							break;
						case"--stdin":
						case"-s":
							//options.replace("stdin", true);
							Scanner scanner = new Scanner(System.in);
							if(scanner.hasNext()) {
								name = scanner.nextLine();
							} // if
							break;
						default:
							System.out.println("Unkown arg: " + args[i] + "\nUsage: App [-n] Name");
							break;
					} // switch
				} // for
			} // if
			this.name = name;
	} // parseArgs

	public String getName() {
		return name;
	} // getName
} // class
