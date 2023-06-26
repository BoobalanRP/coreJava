package in.boomibalan.fertagriboomi;

import in.boomibalan.fertagriboomi.service.UserService;

public class App {

	public static void main(String[] args) {
	
       UserService userService = new UserService();
       
       
       userService.create();
       userService.getAll();
   
	}

}
