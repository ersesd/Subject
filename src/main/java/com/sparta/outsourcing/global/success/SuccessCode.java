package com.sparta.outsourcing.global.success;

import lombok.Getter;

@Getter
public enum SuccessCode {
  // JWT 성공 메세지
  SUCCESS_NEW_TOKEN("성공적으로 토큰을 발급하였습니다."),

  // 유저 성공 메세지
  SUCCESS_SIGNUP("회원 가입에 성공하였습니다."),
  SUCCESS_LOGIN("로그인에 성공하였습니다."),
  SUCCESS_LOGOUT("로그아웃에 성공하였습니다."),
  SUCCESS_SEARCH("조회에 성공하였습니다."),
  SUCCESS_UPDATE_MEMBER("회원 정보를 성공적으로 변경하였습니다."),
  SUCCESS_UPDATE_MEMBER_PASSWORD("회원의 비밀번호를 변경하였습니다."),
  SUCCESS_DELETE_MEMBER("회원을 성공적으로 삭제하였습니다."),

  // 음식 성공 메세지
  SUCCESS_CREATE_MENU("음식을 생성하였습니다."),
  SUCCESS_SEARCH_MENU("음식을 조회하였습니다."),
  SUCCESS_UPDATE_MENU("음식을 수정하였습니다."),
  SUCCESS_DELETE_MENU("음식을 삭제하였습니다."),

  // 주문 성공 대한 메세지
  SUCCESS_SEARCH_ORDER("주문 조회 성공하였습니다."),
  SUCCESS_ORDER("주문 성공하였습니다."),
  SUCCESS_CANCEL("주문을 취소하였습니다."),

  // 장바구니 성공 메세지
  SUCCESS_CONTAIN("장바구니에 담겨졌습니다."),
  SUCCESS_SEARCH_BASKET("장바구니 조회에 성공하였습니다."),
  SUCCESS_DELETE_BASKET("장바구니가 비워졌습니다."),

  // 결제 성공 메세지
  SUCCESS_SEARCH_PAYMENT("결제 조회가 완료되었습니다."),
  SUCCESS_CANCEL_PAYMENT("결제 취소가 완료되었습니다."),

  // 가게 성공 메세지
  SUCCESS_CREATE_RESTAURANT("가게 생성을 완료하였습니다."),
  SUCCESS_SEARCH_RESTAURANT("가게를 조회하였습니다."),
  SUCCESS_UPDATE_RESTAURANT("가게를 수정하였습니다."),
  SUCCESS_DELETE_RESTAURANT("가게를 삭제하였습니다."),


  REVIEW_DELETED("리뷰가 삭제되었습니다."), REVIEW_UPDATED("리뷰가 수정되었습니다."), REVIEWS_FOUND_BY_USER("사용자의 리뷰를 찾았습니다."), REVIEW_FOUND(
      "리뷰를 찾았습니다."), REVIEWS_FOUND("리뷰를 찾았습니다."), REVIEW_CREATED("리뷰를 생성했습니다.");

  private final String message;

  SuccessCode(String message) {
    this.message = message;
  }
}
