package ru.eisbrecher.springboot.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.eisbrecher.springboot.entity.Fine;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class FineRepository {

    private ArrayList<Fine> fineList;

    @PostConstruct
    public void init(){
        fineList = new ArrayList<>();
        fineList.add(new Fine("A123BC", "Нарушитель1", "Инспектор1", "Составитель1", LocalDateTime.now(),500,false,false));
        fineList.add(new Fine("A123BC", "Нарушитель1", "Инспектор2", "Составитель1", LocalDateTime.now(),700,false,false));
        fineList.add(new Fine("A123BC", "Нарушитель1", "Инспектор1", "Составитель2", LocalDateTime.now(),800,false,false));
    }

    public ArrayList<Fine> getAllFines() {
        return fineList;
    }

    public void addNewFine(Fine fine) {
        fineList.add(fine);
    }

    public void updateFine(Fine fine) {
        fineList.set(fine.getId(), fine);
    }


    public Fine getFine(int fineId) {
        return fineList.get(fineId);
    }

    public String removeFine(Object fine) {
        if (!fineList.contains(fine))
            return "There is no " + fine.toString() + " in database";
        fineList.remove(fine);
        return fine.toString() + " was deleted.";
    }

}
