import java.util.ArrayList;

public class Airport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reader r = new Reader();
		
		ArrayList<String> inputData = new ArrayList<String>();
		inputData = r.readFile("input.csv");
		
		for (int i = 0; i<inputData.size(); i++)
		{
			System.out.println(inputData.get(i));
			
		}
	}

}
