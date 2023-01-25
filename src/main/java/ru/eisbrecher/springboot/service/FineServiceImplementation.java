package ru.eisbrecher.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.eisbrecher.springboot.entity.Fine;
import ru.eisbrecher.springboot.repository.FineRepository;

import java.util.List;

@Service
public class FineServiceImplementation implements FineService{

    @Autowired
    private FineRepository fineRepository;

    @Override
    public List<Fine> getAllFines(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return fineRepository.findAll(pages).getContent();
    }

    @Override
    public void updateFine(Fine fine) {
        fineRepository.save(fine);
    }

    @Override
    public void addNewFine(Fine fine) {
        fineRepository.save(fine);
    }

    @Override
    public Fine getFine(int fineId) {
        return fineRepository.getReferenceById(fineId);
    }

    @Override
    public void removeFine(Fine fine) {
        fineRepository.delete(fine);
    }
}
