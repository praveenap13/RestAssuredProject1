package publicapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployessSerializationDeserialization {
	
	private String allEmpJson;
	@Test
	public void createListOfEmployeeJsonArrayFromEmployeePojoClass() throws JsonProcessingException {
		PojoOfJsonarray amol=new PojoOfJsonarray();
		amol.setFirstname("amol");
		amol.setLastname("nirav");
		amol.setGender("female");
		amol.setAge(33);
		amol.setSalary(34567.00);
		amol.setMarried(false);
		
		PojoOfJsonarray aniket=new PojoOfJsonarray();
		aniket.setFirstname("aniket");
		aniket.setLastname("Gurav");
		aniket.setGender("female");
		aniket.setAge(33);
		aniket.setSalary(37667.00);
		aniket.setMarried(false);
		
		List<PojoOfJsonarray> allEmp=new ArrayList<>();
		allEmp.add(amol);
		allEmp.add(aniket);
		
		ObjectMapper objmap=new ObjectMapper();
		allEmpJson=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(allEmp);
		System.out.println(allEmpJson);
		
	}
	@Test
	public void getPojoFromEmployeeObject() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMap=new ObjectMapper();
		List<PojoOfJsonarray> allEmpDetail=objMap.readValue(allEmpJson, new TypeReference<List<PojoOfJsonarray>>() {});
		for(PojoOfJsonarray emp:allEmpDetail) {
			System.out.println(emp.getAge());
			System.out.println(emp.getFirstname());
					
					System.out.println(emp.getLastname());
		System.out.println(emp.getGender());
				System.out.println(emp.getSalary());
		}
	}

}
	