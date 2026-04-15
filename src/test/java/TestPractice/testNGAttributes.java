package TestPractice;



import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testNGAttributes 
{
	
	@Test(priority=1)
	public void goodMorning()
	{
		System.out.println("Good Morning");
	}
	@Test(priority=2,dependsOnMethods = { "goodMorning","earlyMorning"})
	public void goodAfternoon()
	{
		System.out.println("Good Afternoon");
	}
	@Ignore
	@Test(priority=3,invocationCount = 3)
	public void goodEvening()
	{
		System.out.println("Good Evening");
	}
	
	@Test(priority=4,invocationCount=0)
	public void goodNight()
	{
		System.out.println("Good Night");
	}
	@Test
	public void earlyMorning()
	{
		System.out.println("Early Morning");
	}
}
