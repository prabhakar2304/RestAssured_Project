package DAY_6;//(Serialization)--> Java Object TO JSON Object and (DE-Serialization)--> JSON Object to Java Object

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.*;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Serialization_Deserialization 
{   @Test(priority=1)
	void convertPojoToJson() throws Exception
	{
	
	Student_pojo student = new Student_pojo();
	student.setName("Ravi");
	student.setGender("Male");
	student.setEnglish("90");
	student.setMaths("80");
	student.setPhysics("70");

    ObjectMapper mapper=new ObjectMapper();
     
    String jsondataString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
    
    System.out.println(jsondataString);
    }

	@Test(priority=2)
	void convertJsonToPojo() throws Exception
	{
		String jsondataString="{\r\n"
				+ "  \"name\" : \"Ravi\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"english\" : \"90\",\r\n"
				+ "  \"maths\" : \"80\",\r\n"
				+ "  \"physics\" : \"70\"\r\n"
				+ "}";

	ObjectMapper newmapper=new ObjectMapper();
    Student_pojo student_pojo=newmapper.readValue(jsondataString, Student_pojo.class);
    System.out.println(student_pojo.getName());
    System.out.println(student_pojo.getGender());
    System.out.println(student_pojo.getEnglish());
	System.out.println(student_pojo.getMaths());
    System.out.println(student_pojo.getPhysics());
	}
}