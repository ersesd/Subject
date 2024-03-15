package com.sparta.outsourcing.domain.payment.controller;


import static com.sparta.outsourcing.global.success.SuccessCode.SUCCESS_CANCEL_PAYMENT;
import static com.sparta.outsourcing.global.success.SuccessCode.SUCCESS_SEARCH_PAYMENT;

import com.sparta.outsourcing.domain.payment.dto.PaymentsResponseDto;
import com.sparta.outsourcing.domain.payment.entity.CommonResponse;
import com.sparta.outsourcing.domain.payment.service.PaymentsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PaymentsController {

  private final PaymentsService paymentsService;

  @GetMapping("/payments/{paymentId}")
  public ResponseEntity<CommonResponse<PaymentsResponseDto>> getPayment(
      @PathVariable Long paymentId) {
    PaymentsResponseDto paymentsResponseDto = paymentsService.getPayment(paymentId);
    return ResponseEntity.ok().body(
        CommonResponse.<PaymentsResponseDto>builder().code(HttpStatus.OK.value())
            .message(SUCCESS_SEARCH_PAYMENT.getMessage()).data(paymentsResponseDto).build());
  }

  @GetMapping("/payments")
  public ResponseEntity<CommonResponse<List<PaymentsResponseDto>>> getPaymentList() {
    List<PaymentsResponseDto> paymentsResponseDto = paymentsService.getPaymentList();

    return ResponseEntity.ok().body(
        CommonResponse.<List<PaymentsResponseDto>>builder().code(HttpStatus.OK.value())
            .message(SUCCESS_SEARCH_PAYMENT.getMessage()).data(paymentsResponseDto).build());
  }

  @DeleteMapping("/payments/{paymentId}")
  public ResponseEntity<CommonResponse> deletePayment(@PathVariable Long paymentId) {

    paymentsService.deletePayment(paymentId);

    return ResponseEntity.ok().body(
        CommonResponse.<PaymentsResponseDto>builder().code(HttpStatus.OK.value())
            .message(SUCCESS_CANCEL_PAYMENT.getMessage()).build());
  }
}
