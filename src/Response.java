public class Response {
	private String greeting;
	private String name;
	
	public Response(String greeting, String name) {
		this.greeting = greeting;
		this.name = name;
	} // response

	@Override
	public String toString() {
		return greeting + ", " + name + "!";
	} // toString
} // class