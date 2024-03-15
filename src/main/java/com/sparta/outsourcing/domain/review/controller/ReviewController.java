package com.sparta.outsourcing.domain.review.controller;

import com.sparta.outsourcing.domain.review.model.dto.ReviewRequestDto;
import com.sparta.outsourcing.domain.review.model.dto.ReviewResponseDto;
import com.sparta.outsourcing.domain.review.service.ReviewService;
import com.sparta.outsourcing.global.dto.CommonResponseDto;
import com.sparta.outsourcing.global.success.SuccessCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

  private final ReviewService reviewService;

  @PostMapping
  public ResponseEntity<CommonResponseDto<ReviewResponseDto>> createReview(
      @RequestBody ReviewRequestDto requestDto,
      @AuthenticationPrincipal UserDetails userDetails) {
    ReviewResponseDto reviewResponseDto = reviewService.createReview(requestDto, userDetails);
    return CommonResponseDto.ok(SuccessCode.REVIEW_CREATED, reviewResponseDto);
  }

  @GetMapping
  public ResponseEntity<CommonResponseDto<List<ReviewResponseDto>>> findReviews(
      @RequestParam(required = false) Long restaurantId,
      @AuthenticationPrincipal UserDetails userDetails) {
    List<ReviewResponseDto> reviews = reviewService.findReviews(userDetails, restaurantId);
    return CommonResponseDto.ok(SuccessCode.REVIEWS_FOUND, reviews);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommonResponseDto<ReviewResponseDto>> findReviewById(
      @PathVariable Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    ReviewResponseDto reviewResponseDto = reviewService.findReviewById(id, userDetails);
    return CommonResponseDto.ok(SuccessCode.REVIEW_FOUND, reviewResponseDto);
  }

  @GetMapping("/user")
  public ResponseEntity<CommonResponseDto<List<ReviewResponseDto>>> findAllReviewsByUser(
      @AuthenticationPrincipal UserDetails userDetails) {
    List<ReviewResponseDto> reviews = reviewService.findAllReviewsByUser(userDetails);
    return CommonResponseDto.ok(SuccessCode.REVIEWS_FOUND_BY_USER, reviews);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CommonResponseDto<ReviewResponseDto>> updateReview(
      @PathVariable Long id,
      @RequestBody ReviewRequestDto requestDto,
      @AuthenticationPrincipal UserDetails userDetails) {
    ReviewResponseDto updatedReview = reviewService.updateReview(id, requestDto, userDetails);
    return CommonResponseDto.ok(SuccessCode.REVIEW_UPDATED, updatedReview);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CommonResponseDto<Void>> deleteReview(
      @PathVariable Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    reviewService.deleteReview(id, userDetails);
    return CommonResponseDto.ok(SuccessCode.REVIEW_DELETED, null);
  }
}
