package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {
	
	static WeatherController wController;
	static double[] temphrs;
	static MyDate myDate; 
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s223026486";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mansheen Kaur";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperaturePersist() {
		System.out.println(" testTemperaturePersist ");
		
		final Date date = Mockito.mock(Date.class);
		Mockito.when(date.getTime()).thenReturn(20L);

		myDate = Mockito.mock(MyDate.class);
        Mockito.when(myDate.getDate()).thenReturn(date);
        
		// Initialise controller
		WeatherController wController = WeatherController.getInstance(myDate);
		
		String persistTime = wController.persistTemperature(10, 19.5);
		String now = new SimpleDateFormat("H:m:s").format(myDate.getDate());
		System.out.println("Persist time: " + persistTime + ", now: " + now);
		
		Assert.assertTrue(persistTime.equals(now));
		
		wController.close();
	}
}