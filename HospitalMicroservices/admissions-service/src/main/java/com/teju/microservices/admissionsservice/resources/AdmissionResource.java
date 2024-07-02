package com.teju.microservices.admissionsservice.resources;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.teju.microservices.admissionsservice.models.DiseasesList;
import com.teju.microservices.admissionsservice.models.EmployeesList;
import com.teju.microservices.admissionsservice.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<Patient> patients = Arrays.asList(
			new Patient("P101", "Tejashree","USA"),
			new Patient("P102", "Neha","India"),
			new Patient("P103", "Smith","Germany")
			);
	
	
	
	@RequestMapping("/patients")
	public List<Patient> getPatients(){
	
		return patients;
		
	}
	
	@RequestMapping("/patients/{Id}")
	public Patient getPatientbyId(@PathVariable("Id") String Id) {
		
		Patient patientId = patients.stream()
							.filter(patient -> Id.equals(patient.getId()))
							.findAny()
							.orElse(null);
		return patientId;
	}
	
	//Here we are simply calling the Physician Employees nothing but Doctore list from the Hr Service class to Admision service class
		@RequestMapping("/physicians")
		public EmployeesList getPhysicians() {
			
			EmployeesList employeesList =restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
			//EmployeesList //employeesList =restTemplate.getForObject("http://localhost:8082/hr/employees", EmployeesList.class);
			return employeesList;
		}
		
		//Here we are simply calling the patholody Diseses list from the Pathology Service class to Admision service class
		@RequestMapping("/diseases")
		public DiseasesList getDiseases() {
			DiseasesList diseasesList =restTemplate.getForObject("http://pathalogy-service/pathology/diseases", DiseasesList.class);
			//DiseasesList diseasesList =restTemplate.getForObject("http://localhost:8083/pathology/diseases", DiseasesList.class);
			return diseasesList;
		}
}
