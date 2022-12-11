package ru.eisbrecher.springboot.repository;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.eisbrecher.springboot.entity.Fine;

import java.util.List;

@Repository
@Transactional
public class FineRepositoryImplementation {
    @Autowired
    private EntityManager entityManager;

    public List<Fine> getAllFines() {
        return entityManager.unwrap(Session.class)
                .createQuery("from Fine", Fine.class).getResultList();
    }


    public void addNewFine(Fine fine) {
        entityManager.unwrap(Session.class)
                .persist(fine);
    }


    public void updateFine(Fine fine) {
        entityManager.unwrap(Session.class)
                .update(fine);
    }


    public Fine getFine(int fineId) {
        return entityManager.unwrap(Session.class)
                .get(Fine.class, fineId);
    }

    public void removeFine(Object fine) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(Fine.class, fine));
    }
}
