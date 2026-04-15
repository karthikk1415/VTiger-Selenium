package Practices;

import java.beans.Transient;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion 
{
	@Test
	public void SoftAssetion()
	{
		String exceptedName = "Chicken Briyani";
		String actualName = "Briyani";
		SoftAssert s = new SoftAssert();
		System.out.println("Soft Asserttion is Started");
		s.assertEquals(actualName,exceptedName);
		System.out.println("Soft Assertion is Middle");
		s.assertTrue(actualName.equals(exceptedName));
		System.out.println("Soft Assertion is inside");
		s.assertFalse(actualName.contains(exceptedName));
		System.out.println("Soft Assertion is end");
		s.assertAll();
	}
}
