import java.util.ArrayList;

public class APP_Ajaccio {

	ArrayList list;

	public APP_Ajaccio() {

	}

	public void getData() {
		Reader r = new Reader();

		ArrayList<String> inputData = new ArrayList<String>();
		inputData = r.readFile("input.csv");

		for (int i = 0; i < inputData.size(); i++) {
			System.out.println(inputData.get(i));

		}
		this.list = inputData;
	}
}
