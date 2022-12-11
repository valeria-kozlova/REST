package ru.eisbrecher.springboot.service;

import ru.eisbrecher.springboot.entity.Fine;

import java.util.List;

public interface FineService {

    public List<Fine> getAllFines(int pageNumber, int pageSize);

    Fine getFine(int fineId);

    void removeFine(Fine fine);

    void updateFine(Fine fine);

    void addNewFine(Fine fine);
}
