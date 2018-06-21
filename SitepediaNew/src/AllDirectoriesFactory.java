import org.testng.annotations.Factory;


public class AllDirectoriesFactory {

		@Factory
	   public  Object[] factoryMethod() {
	        return new Object[] {
	                
	        						//test Frequency Directory
	        						new AllDirectoriesTest("http://92.242.32.232:8133/#/administration/catalogs/freqperiod"),
	        						//test Platforms Directory
	                                new AllDirectoriesTest("http://92.242.32.232:8133/#/administration/catalogs/platform")
	                            };
	    }
		

	}

