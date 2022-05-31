package Assessment_activity1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodTest {
	
	Food testfood1 = new Food("ID1","coke","Coke will pass the test",20,500,"Adult Food");
	Food testfood2 = new Food("ID2","Diet coke","Diet Coke will pass the test",10,40,"Adult Food");
	Food testfood3 = new Food("ID3","candy","candy will fail with excessive sugar content",15,200,"Kd Food");
	Food testfood4 = new Food("ID4","chocolate","chocolate will fail with excessive sugar conten",15,200,"Kid Food");
	Food testfood5 = new Food("ID5","Apple","Apple will pass the test",10,200,"Adult Food");
	
	@BeforeEach
	
	void setUp() throws Exception {
	}
	@After
	public void tearDown()
	{
		testfood1 = null;
		testfood2 = null;
		testfood3 = null;
		testfood4 = null;
		testfood5 = null;
		
		
	}

	
	
	@Test
	public void UpdateFoodTest()
	{
		assertAll("", ()->assertEquals(true,testfood1.UpdateFood("coke", "Cola will be replaced with low sugar", 20,500, "Aldult Food")),
				()->assertEquals(false,testfood1.UpdateFood("coke", "This product will fail because the price is too high", 20,500, "Aldult Food")),
				()->assertEquals(false,testfood1.UpdateFood("coke", "This product will fail because the number of milliliters is too small", 20,500, "Aldult Food")),
				()->assertEquals(false,testfood1.UpdateFood("coke", "This product will fail because it has not been changed to children's food", 20,500, "Kid Food"))
				);
	}
	@Test
	public void AddFoodTest() {
		assertAll("", ()->assertEquals(true,testfood1.AddFood()),
				()->assertEquals(true,testfood2.AddFood()),
				()->assertEquals(false,testfood3.AddFood()),
				()->assertEquals(false,testfood4.AddFood()),
				()->assertEquals(true,testfood5.AddFood())
				);
	}
}
