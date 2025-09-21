package com.lansum.encanto.service;

import org.springframework.stereotype.Service;

import com.lansum.encanto.entity.Visit;
import com.lansum.encanto.entity.VisitRepository;

@Service
public class VisitService {
	private final VisitRepository repository;

    public VisitService(VisitRepository repository) {
        this.repository = repository;
    }

    public Visit saveVisit(Visit visit) {
        return repository.save(visit);
    }
}
