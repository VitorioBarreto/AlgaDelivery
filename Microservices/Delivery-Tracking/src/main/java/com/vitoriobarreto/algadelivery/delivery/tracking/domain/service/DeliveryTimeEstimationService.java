package com.vitoriobarreto.algadelivery.delivery.tracking.domain.service;

import com.vitoriobarreto.algadelivery.delivery.tracking.domain.model.ContactPoint;

public interface DeliveryTimeEstimationService {
    DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver);
}
