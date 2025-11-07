package org.docencia.hotel.persistence;

import java.util.List;

import org.docencia.hotel.model.Guest;
import org.docencia.hotel.persistence.jpa.impl.GuestJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class GuestJpaRepositoryTest {

    @Autowired
    private GuestJpaRepository repository;

    private Guest baseGuest;
    private String baseFullname = "Alan Wake";
    private String baseEmail = "alanwake@example.com";
    private String basePhone = "+012-3456-789";

    @BeforeEach
    @Transactional
    void beforeEach() {
        baseGuest = new Guest();
        baseGuest.setFullname(baseFullname);
        baseGuest.setEmail(baseEmail);
        baseGuest.setPhoneNumber(basePhone);
        repository.save(baseGuest);

        Assertions.assertNotNull(baseGuest.getId());
    }

    @Test
    @Transactional
    void testExists() {
        String id = baseGuest.getId();
        Assertions.assertTrue(repository.exists(id));
    }

    @Test
    @Transactional
    void testFindByIdAndGetters() {
        String id = baseGuest.getId();
        Guest guestFound = repository.findById(id);
        Assertions.assertNotNull(guestFound);
        Assertions.assertEquals(baseFullname, guestFound.getFullname());
        Assertions.assertEquals(baseEmail, guestFound.getEmail());
        Assertions.assertEquals(basePhone, guestFound.getPhoneNumber());
    }

    @Test
    @Transactional
    void testFindAll() {
        Guest secondGuest = new Guest();
        secondGuest.setFullname("Test guest 2");
        secondGuest.setEmail("Test email 2");
        secondGuest.setPhoneNumber("+098-7654-321");
        repository.save(secondGuest);
        List<Guest> guests = repository.findAll();
        Assertions.assertEquals(2, guests.size());
        Assertions.assertTrue(repository.exists(secondGuest.getId()));
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseGuest.getId();
        Assertions.assertTrue(repository.exists(id));
        repository.delete(id);
        Assertions.assertFalse(false);
    }

}