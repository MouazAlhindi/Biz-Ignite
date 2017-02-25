/* Class that will hold the main method
 * 
 */

public class BizIgniteMain {

	//Fields
	private static DataBase mainData = new DataBase();
	private static LoginFrame lgFrame;
	
	//Main Method
	public static void main(String[] args){
		lgFrame = new LoginFrame(mainData);
	}
	//Static Methods
}
