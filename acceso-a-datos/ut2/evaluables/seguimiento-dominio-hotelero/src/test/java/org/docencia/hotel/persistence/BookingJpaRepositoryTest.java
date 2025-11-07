package org.docencia.hotel.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Guest;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.impl.BookingJpaRepository;
import org.docencia.hotel.persistence.jpa.impl.GuestJpaRepository;
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
class BookingJpaRepositoryTest {

    @Autowired
    private BookingJpaRepository bookingRepository;

    @Autowired
    private RoomJpaRepository roomRepository;

    @Autowired
    private GuestJpaRepository guestRepository;

    private Booking baseBooking;
    private LocalDateTime baseCheckIn = LocalDateTime.of(2025, 1, 1, 12, 0);
    private LocalDateTime baseCheckOut = LocalDateTime.of(2025, 3, 1, 12, 0);
    private String baseBookingRoomType = "single"; 
    private String baseBookingGuestName = "Susan Daniela";

    @BeforeEach
    @Transactional
    void beforeEach() {
        Room baseBookingRoom = roomRepository.save(new Room(1, baseBookingRoomType, 40));
        Guest baseBookingGuest = guestRepository.save(new Guest(baseBookingGuestName, "susanlugo@yahoo.com", "+012-3456-789"));
        baseBooking = new Booking();
        baseBooking.setCheckIn(baseCheckIn);
        baseBooking.setCheckOut(baseCheckOut);
        baseBooking.setRoom(baseBookingRoom);
        baseBooking.setGuest(baseBookingGuest);
        bookingRepository.save(baseBooking);

        Assertions.assertNotNull(baseBooking.getId());
    }

    @Test
    @Transactional
    void testExists() {
        String id = baseBooking.getId();
        Assertions.assertTrue(bookingRepository.exists(id));
    }

    @Test
    @Transactional
    void testFindByIdAndGetters() {
        String id = baseBooking.getId();
        Booking bookingFound = bookingRepository.findById(id);
        Assertions.assertNotNull(bookingFound);
        Assertions.assertEquals(baseCheckIn, bookingFound.getCheckIn());
        Assertions.assertEquals(baseCheckOut, bookingFound.getCheckOut());
        Assertions.assertEquals(baseBookingGuestName, bookingFound.getGuest().getFullname());
        Assertions.assertEquals(baseBookingRoomType, bookingFound.getRoom().getType());
    }

    @Test
    @Transactional
    void testFindAll() {
        Booking secondBooking = new Booking();
        secondBooking.setCheckIn(baseCheckIn);
        secondBooking.setCheckOut(baseCheckOut);
        bookingRepository.save(secondBooking);
        List<Booking> bookings = bookingRepository.findAll();
        Assertions.assertEquals(2, bookings.size());
        Assertions.assertTrue(bookingRepository.exists(secondBooking.getId()));
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseBooking.getId();
        Assertions.assertTrue(bookingRepository.exists(id));
        bookingRepository.delete(id);
        Assertions.assertFalse(false);
    }

}