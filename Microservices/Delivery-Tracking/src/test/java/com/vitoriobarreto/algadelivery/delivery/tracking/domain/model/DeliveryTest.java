package com.vitoriobarreto.algadelivery.delivery.tracking.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

@Test
    public void shouldChangeStatustoPlaced(){
        Delivery delivery = Delivery.draft();

        delivery.editPreparationDetails(createdValidPreparationDetails());

        delivery.place();

        assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
        assertNotNull(delivery.getPlacedAt());


    }

    private Delivery.PreparationDetails createdValidPreparationDetails() {
        ContactPoint sender = ContactPoint.builder()
                .zipCode("12345-678")
                .street("Sender Street")
                .number("123")
                .complement("Apt 1")
                .name("Sender Name")
                .phone("1234567890")
                .build();

        ContactPoint recipient = ContactPoint.builder()
                .zipCode("12345-678")
                .street("RECIPIENT Street")
                .number("123")
                .complement("Apt 1")
                .name("Recipient Name")
                .phone("1234567890")
                .build();



        return Delivery.PreparationDetails.builder()
                .sender(sender)
                .recipient(recipient)
                .distanceFee(new BigDecimal("10.00"))
                .courierPayOut(new BigDecimal("5.00"))
                .expectedDeliveryTime(Duration.ofMinutes(45))
                .build();
    }

}