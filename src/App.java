import java.util.HashMap;
import java.util.Map;

class App {
	public static void main(String[] args) {
		final String GREETING = "Hello";
		boolean hasName = false;
		Map<String, Boolean> options = new HashMap<>();
		options.put("interactive", false);
		options.put("stdin", false);
		String name = "World";

		// Building Application
		// Check for commandline args
		Context context = new Context(args);
		name = context.getName();

		// Responding to user
		Response response = new Response(GREETING, name);
		System.out.println(response);
	} // main
} // class
