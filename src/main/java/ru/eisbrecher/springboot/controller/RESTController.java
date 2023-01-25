package ru.eisbrecher.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.eisbrecher.springboot.entity.Fine;
import ru.eisbrecher.springboot.service.FineService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/fines")
public class RESTController {

    @Autowired
    private FineService fineService;


    @GetMapping("/") //получение всех
    public List<Fine> getAllFines(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "5") Integer pageSize) {
        return fineService.getAllFines(pageNumber, pageSize);
    }

    @GetMapping("/{fineId}")
    public Fine getFines(@PathVariable int fineId) {
        return fineService.getFine(fineId);
    }

    @PostMapping("/")
    public Fine addNewFine(@RequestBody Fine fine) {
        fineService.addNewFine(fine);
        return fine;
    }

    @PutMapping("/")
    public Fine updateFine(@RequestBody Fine fine) {
        fineService.updateFine(fine);
        return fine;
    }

//    @DeleteMapping("/fines/{id}")
//    public String removeFine(@PathVariable int id) {
//        if (fineRepository.getFine(id) == null)
//            return "There is no fine with ID = " + id + " in database";
//        fineRepository.removeFine(id);
//        return "Fine with id = " + id + " was deleted.";
//    }
    @DeleteMapping("/")
    public String removeFine(@RequestBody Fine fine) {
        if (fineService.getFine(fine.getId()) == null)
            return "There is no fine with ID = " + fine.getId() + " in database";
        fineService.removeFine(fine);
        return "Fine with id = " + fine.getId() + " was deleted.";
    }




    @PatchMapping("/fines/{fineId}/pay")
    public Fine payFine(@PathVariable int fineId) {
        Fine fine = fineService.getFine(fineId);
        fine.setPayed(true);
        fineService.updateFine(fine);
        return fine;
    }
    @PatchMapping("/fines/{fineId}/court")
    public Fine courtFine(@PathVariable int fineId) {
        Fine fine = fineService.getFine(fineId);
        fine.setPayed(true);
        fineService.updateFine(fine);
        return fine;
    }

}
