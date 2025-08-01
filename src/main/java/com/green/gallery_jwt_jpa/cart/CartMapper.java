package com.green.gallery_jwt_jpa.cart;

import com.green.gallery_jwt_jpa.cart.model.CartDeleteReq;
import com.green.gallery_jwt_jpa.cart.model.CartGetRes;
import com.green.gallery_jwt_jpa.cart.model.CartPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    // 회원과 아이템 아이디로 중복 체크
    int countByMemberIdAndItemId(int memberId, int itemId);

    // 특정 회원의 장바구니 아이템 목록 조회
    List<CartGetRes> findAllWithItemByMemberId(int memberId);

    // 장바구니에 저장
    int save(CartPostReq p);

    // 장바구니 삭제
    int deleteByCartIdAndMemberId(CartDeleteReq p);

    // 장바구니 전체 삭제
    int deleteAllCart(int memberId);
}