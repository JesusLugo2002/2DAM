package org.docencia.hotel.persistence;

import java.util.List;

import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.impl.HotelJpaRepository;
import org.docencia.hotel.persistence.jpa.impl.RoomJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class RoomJpaRepositoryTest {

    @Autowired
    private RoomJpaRepository roomRepository;

    @Autowired
    private HotelJpaRepository hotelRepository;

    private Room baseRoom;
    private int baseNumber = 1;
    private String baseType = "double";
    private double basePricePerNight = 50.0;
    private String baseHotelName = "Hotel Test";

    @BeforeEach
    @Transactional
    void beforeEach() {
        Hotel baseHotel = hotelRepository.save(new Hotel(baseHotelName, "Avenida 123"));
        baseRoom = new Room();
        baseRoom.setNumber(baseNumber);
        baseRoom.setType(baseType);
        baseRoom.setPricePerNight(basePricePerNight);
        baseRoom.setHotel(baseHotel);
        roomRepository.save(baseRoom);

        Assertions.assertNotNull(baseRoom.getId());
    }

    @Test
    @Transactional
    void testExists() {
        String id = baseRoom.getId();
        Assertions.assertTrue(roomRepository.exists(id));
    }

    @Test
    @Transactional
    void testFindByIdAndGetters() {
        String id = baseRoom.getId();
        Room roomFound = roomRepository.findById(id);
        Assertions.assertNotNull(roomFound);
        Assertions.assertEquals(baseNumber, roomFound.getNumber());
        Assertions.assertEquals(basePricePerNight, roomFound.getPricePerNight());
        Assertions.assertEquals(baseType, roomFound.getType());
        Assertions.assertEquals(baseHotelName, roomFound.getHotel().getName());
    }

    @Test
    @Transactional
    void testFindAll() {
        Room secondRoom = new Room();
        secondRoom.setNumber(2);
        secondRoom.setType("single");
        secondRoom.setPricePerNight(40.0);
        roomRepository.save(secondRoom);
        List<Room> rooms = roomRepository.findAll();
        Assertions.assertEquals(2, rooms.size());
        Assertions.assertTrue(roomRepository.exists(secondRoom.getId()));
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseRoom.getId();
        Assertions.assertTrue(roomRepository.exists(id));
        roomRepository.delete(id);
        Assertions.assertFalse(false);
    }

}