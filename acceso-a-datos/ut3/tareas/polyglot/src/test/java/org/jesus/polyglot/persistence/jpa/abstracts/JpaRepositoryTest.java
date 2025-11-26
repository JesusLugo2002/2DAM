package org.jesus.polyglot.persistence.jpa.abstracts;

import org.jesus.polyglot.model.Booking;
import org.jesus.polyglot.model.Guest;
import org.jesus.polyglot.model.Hotel;
import org.jesus.polyglot.model.Room;
import org.jesus.polyglot.persistence.jpa.impl.BookingJpaRepository;
import org.jesus.polyglot.persistence.jpa.impl.GuestJpaRepository;
import org.jesus.polyglot.persistence.jpa.impl.HotelJpaRepository;
import org.jesus.polyglot.persistence.jpa.impl.RoomJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
public class JpaRepositoryTest {

    @Autowired
    private HotelJpaRepository hotelRepository;

    @Autowired
    private RoomJpaRepository roomRepository;

    @Autowired
    private BookingJpaRepository bookingRepository;

    @Autowired
    private GuestJpaRepository guestRepository;

    private Hotel hotel;
    private final String hotelName = "Oceanview Hotel";
    private final String hotelAddress = "New York, 123";

    private Room roomA;
    private final int roomANumber = 665;
    private final double roomAPrice = 25.0;

    private Room roomB;
    private final int roomBNumber = 505;
    private final double roomBPrice = 35.5;
    private Guest guest;
    private final String guestName = "Alan Wake";
    private final String guestEmail = "alanwake@example.es";
    private final String guestPhone = "+01-2345-6789";

    private Booking booking;
    private final String bookingCheckIn = "01-01-2024";
    private final String bookingCheckOut = "01-01-2025";

    @Transactional
    @BeforeEach
    void BeforeEach() {
        hotel = new Hotel(hotelName, hotelAddress);
        hotelRepository.save(hotel);

        roomA = new Room(roomANumber, roomAPrice, hotel);
        roomB = new Room(roomBNumber, roomBPrice, hotel);
        roomRepository.save(roomA);
        roomRepository.save(roomB);

        guest = new Guest(guestName, guestEmail, guestPhone);
        guestRepository.save(guest);

        booking = new Booking(bookingCheckIn, bookingCheckOut, roomA, guest);
        bookingRepository.save(booking);
    }
    
    @Test
    void testEntitiesExistsInBBDD() {
        Assertions.assertTrue(hotelRepository.existsById(hotel.getId()));
        Assertions.assertTrue(roomRepository.existsById(roomA.getId()));
        Assertions.assertTrue(roomRepository.existsById(roomB.getId()));
        Assertions.assertTrue(guestRepository.existsById(guest.getId()));
        Assertions.assertTrue(bookingRepository.existsById(booking.getId()));
    }

}
