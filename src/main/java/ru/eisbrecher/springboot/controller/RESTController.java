package ru.eisbrecher.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.eisbrecher.springboot.entity.Fine;
import ru.eisbrecher.springboot.repository.FineRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fines")
public class RESTController {

    @Autowired
    FineRepository fineRepository;

    @GetMapping("/") //получение всех
    public List<Fine> getAllFines() {
        return fineRepository.getAllFines();
    }

    @GetMapping("/{fineId}")
    public Fine getFine(@PathVariable int fineId) {
        return fineRepository.getFine(fineId);
    }

    @PostMapping("/")
    public Fine addNewFine(@RequestBody Fine fine) {
        fineRepository.addNewFine(fine);
        return fine;
    }

    @PutMapping("/")
    public Fine updateFine(@RequestBody Fine fine) {
        fineRepository.updateFine(fine);
        return fine;
    }

    @DeleteMapping("/{fineId}")
    public String removeFine(@RequestParam int fineId) {
        return fineRepository.removeFine(fineId);
    }

    @DeleteMapping("/")
    public String removeFine(@RequestBody Fine fine) {
        return fineRepository.removeFine(fine);
    }

    @PatchMapping("/fines/{fineId}/pay")
    public Fine payFine(@PathVariable int fineId) {
        Fine fine = getFine(fineId);
        fine.setPayed(true);
        updateFine(fine);
        return fine;
    }

    @PatchMapping("/fines/{fineId}/court")
    public Fine courtFine(@PathVariable int fineId) {
        Fine fine = getFine(fineId);
        fine.setCourt(true);
        updateFine(fine);
        return fine;
    }

}
