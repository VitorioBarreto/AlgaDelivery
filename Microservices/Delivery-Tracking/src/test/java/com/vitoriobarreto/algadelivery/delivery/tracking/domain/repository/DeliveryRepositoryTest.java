package com.vitoriobarreto.algadelivery.delivery.tracking.domain.repository;

import com.vitoriobarreto.algadelivery.delivery.tracking.domain.model.ContactPoint;
import com.vitoriobarreto.algadelivery.delivery.tracking.domain.model.Delivery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void shouldPersist() {
        Delivery delivery = Delivery.draft();

        delivery.editPreparationDetails(createdValidPreparationDetails());

        delivery.addItem("computador", 2);
        delivery.addItem("mouse", 1);

        deliveryRepository.saveAndFlush(delivery);

        Delivery peristedDelivery = deliveryRepository.findById(delivery.getId()).orElseThrow();

        assertEquals(2, peristedDelivery.getItems().size());

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