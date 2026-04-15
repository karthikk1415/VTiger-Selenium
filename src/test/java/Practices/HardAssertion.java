package Practices;

import static org.testng.Assert.expectThrows;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion 
{
	@Test
	public void hardAssertion ()
	{
		String exceptedName = "karthi";
		String actualName = "karthi";
		System.out.println("Hard Asserttion is Started");
		Assert.assertEquals(actualName,exceptedName);
		System.out.println("Hard Assertion is Middle");
		Assert.assertTrue(actualName.equals(exceptedName));
		System.out.println("Hard Assertion is inside");
		Assert.assertFalse(actualName.contains(exceptedName));
		System.out.println("Hard Assertion is end");
	}
}
