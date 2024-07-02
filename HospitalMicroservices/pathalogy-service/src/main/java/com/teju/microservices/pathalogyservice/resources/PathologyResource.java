package com.teju.microservices.pathalogyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teju.microservices.pathalogyservice.models.Disease;
import com.teju.microservices.pathalogyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	List<Disease> diseases = Arrays.asList(
			
			new Disease("D101","Fever","Tylenol Tablet"),
			new Disease("D102","Thyphoid","Amplicine Capsule"),
			new Disease("D103","Cough","Nyqil Syrup")
			);
	
//	@RequestMapping("/diseases")
//	public List<Disease> getDisease(){
//		return diseases;
//	}
	
	@RequestMapping("/diseases")
	public DiseasesList getDisease() {
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDisease(diseases);
		return diseasesList;
		
	}
	
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {
		Disease diseaseId = diseases.stream()
							.filter(disease -> Id.equals(disease.getId()))
							.findAny()
							.orElse(null);
		return diseaseId;
	}
}














