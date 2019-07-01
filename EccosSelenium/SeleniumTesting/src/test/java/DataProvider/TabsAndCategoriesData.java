package DataProvider;

import org.testng.annotations.DataProvider;

public class TabsAndCategoriesData {
	
	
	@DataProvider(name="TabsProvider") 
    public Object[][] getTabsDataFromDataprovider(){
    return new Object[][] 
    	{
            {"collect"},
            {"review"},
            {"analyze"},
            {"report-protocol"}
            
        };

    }
	
	@DataProvider(name="CategoriesProvider") 
    public Object[][] getCategoriesDataFromDataprovider(){
    return new Object[][] 
    	{
            {"energy"},
            {"water"},
//            {"profile"}
            
        };

    }
	

}
