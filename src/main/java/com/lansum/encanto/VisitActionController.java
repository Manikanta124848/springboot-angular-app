package com.lansum.encanto;

import com.lansum.encanto.entity.Visit;
import com.lansum.encanto.service.VisitService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visits")
@CrossOrigin(origins = "*")
public class VisitActionController {

	private final VisitService service;

	public VisitActionController(VisitService service) {
		this.service = service;
	}

	@GetMapping("/ping")
	public String ping() {
		return "Application is up and running 🚀";
	}

	@PostMapping
	public ResponseEntity<Visit> scheduleVisit(@RequestBody Visit visit) {
		System.err.println("Application called...");
		Visit saved = service.saveVisit(visit);
		return ResponseEntity.ok(saved);
	}
}
