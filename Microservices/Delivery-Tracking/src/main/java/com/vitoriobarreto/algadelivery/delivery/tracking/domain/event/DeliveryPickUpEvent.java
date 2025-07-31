package com.vitoriobarreto.algadelivery.delivery.tracking.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString
public class DeliveryPickUpEvent {
    private final OffsetDateTime ocurredAt;
    private final UUID deliveryId;
}
