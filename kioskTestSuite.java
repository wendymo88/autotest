package testSuite;



import com.kiosk.testCase.testone;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class kioskTestSuite 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public kioskTestSuite( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite=new TestSuite( );
    	
    	//foraited  kiosk_test_NoActionTips_en_0211  /  kiosk_test_NoActionTips_en_0211
    	
//    	suite.addTestSuite(kiosk_start.class);
//    	suite.addTestSuite(kiosk_test_ChooceType_en_200.class);
//        suite.addTestSuite(kiosk_test_cartEmpty_en_0220.class);
//        suite.addTestSuite(kiosk_test_StartOver_en_0310.class);
//    	suite.addTestSuite(kiosk_test_OrderFood_en_0400.class);
//    	suite.addTestSuite(kiosk_test_OrderFoods_en_0510.class);
//    	suite.addTestSuite(kiosk_end.class);
    	
    	
    	suite.addTestSuite(testone.class);
    	
    	
        return suite;
     
    }

//    private static Object TestSuite(Class<test> class1) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
