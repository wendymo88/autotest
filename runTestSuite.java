package testSuite;

public class runTestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    for(int i=0;i<5;i++)
	    {
	        junit.textui.TestRunner.run(kioskTestSuite.suite())	;
			System.out.println("ok");
	    }
	}

}
