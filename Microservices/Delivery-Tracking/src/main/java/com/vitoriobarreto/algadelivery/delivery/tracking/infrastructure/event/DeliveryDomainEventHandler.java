package com.vitoriobarreto.algadelivery.delivery.tracking.infrastructure.event;

import com.vitoriobarreto.algadelivery.delivery.tracking.domain.event.DeliveryFulfilledEvent;
import com.vitoriobarreto.algadelivery.delivery.tracking.domain.event.DeliveryPickUpEvent;
import com.vitoriobarreto.algadelivery.delivery.tracking.domain.event.DeliveryPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.vitoriobarreto.algadelivery.delivery.tracking.infrastructure.kafka.KafkaTopicConfig.DELIVERY_EVENTS_TOPIC_NAME;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeliveryDomainEventHandler {

    private final IntegrationEventPublisher integrationEventPublisher;

    @EventListener
    public void handle(DeliveryPlacedEvent event) {
        log.info(event.toString());
        integrationEventPublisher.publish(event, event.getDeliveryId().toString(),
                DELIVERY_EVENTS_TOPIC_NAME);
    }

    @EventListener
    public void handle(DeliveryPickUpEvent event) {
        log.info(event.toString());
        integrationEventPublisher.publish(event, event.getDeliveryId().toString(),
                DELIVERY_EVENTS_TOPIC_NAME);
    }

    @EventListener
    public void handle(DeliveryFulfilledEvent event) {
        log.info(event.toString());
        integrationEventPublisher.publish(event, event.getDeliveryId().toString(),
                DELIVERY_EVENTS_TOPIC_NAME);
    }
}
