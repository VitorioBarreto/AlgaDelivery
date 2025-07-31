package com.vitoriobarreto.algadelivery.delivery.tracking.infrastructure.http.client;

import com.vitoriobarreto.algadelivery.delivery.tracking.domain.service.CourierPayoutCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CourierPayoutCalculationServiceImpl implements CourierPayoutCalculationService {

    private final CourierApiClient courierApiClient;

    @Override
    public BigDecimal calculatePayout(Double distanceInKm) {
        var courierPayoutResultModel = courierApiClient.payoutCalculation(
                new CourierPayoutCalculationInput(distanceInKm)
        );
        return courierPayoutResultModel.getPayoutFee();
    }
}
