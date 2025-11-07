package org.docencia.hotel.persistence;

import java.util.List;

import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.persistence.jpa.impl.HotelJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class HotelJpaRepositoryTest {

    @Autowired
    private HotelJpaRepository repository;

    private Hotel baseHotel;
    private String baseName = "Oceanview Hotel";
    private String baseAddress = "New York, 123";

    @BeforeEach
    @Transactional
    void beforeEach() {
        baseHotel = new Hotel();
        baseHotel.setName(baseName);
        baseHotel.setAddress(baseAddress);
        repository.save(baseHotel);

        Assertions.assertNotNull(baseHotel.getId());
    }

    @Test
    @Transactional
    void testExists() {
        String id = baseHotel.getId();
        Assertions.assertTrue(repository.exists(id));
    }

    @Test
    @Transactional
    void testFindByIdAndGetters() {
        String id = baseHotel.getId();
        Hotel hotelFound = repository.findById(id);
        Assertions.assertNotNull(hotelFound);
        Assertions.assertEquals(baseName, hotelFound.getName());
        Assertions.assertEquals(baseAddress, hotelFound.getAddress());
    }

    @Test
    @Transactional
    void testFindAll() {
        Hotel secondHotel = new Hotel();
        secondHotel.setName("Test hotel 2");
        secondHotel.setAddress("Test address 2");
        repository.save(secondHotel);
        List<Hotel> hotels = repository.findAll();
        Assertions.assertEquals(2, hotels.size());
        Assertions.assertTrue(repository.exists(secondHotel.getId()));
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseHotel.getId();
        Assertions.assertTrue(repository.exists(id));
        repository.delete(id);
        Assertions.assertFalse(false);
    }

}
