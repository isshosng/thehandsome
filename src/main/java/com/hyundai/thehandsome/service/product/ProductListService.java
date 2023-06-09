package com.hyundai.thehandsome.service.product;

import java.security.Principal;
import java.util.List;

import com.hyundai.thehandsome.Vo.product.CatePListVO;
import com.hyundai.thehandsome.Vo.product.detail.ProductDetailVO;
import com.hyundai.thehandsome.domain.Criteria;
import com.hyundai.thehandsome.domain.mypage.WishList;

/**
 * ProductListService
 * @author 박세영
 * @since 2023.02.01
 * @version 1.0
 * 
 * <pre>
 * 수정일        	수정자       			수정내용
 * ----------  --------    ---------------------------
 * 2023.02.01  	박세영        최초 생성, getListTest() 추가
 * 2023.02.05  	박세영       getProductDetail(), getProductImg() 추가
 * 2023.02.06  	박성환       getPListWithLikes() 추가
 * 2023.02.10  	박세영       getCategory() 추가
 * 2023.02.11  	박세영       getIsLiked() 추가
 * </pre>
 */

public interface ProductListService {
	// 리스트 정보 받아오기
	List<CatePListVO> getPListWithCategory(Criteria cri, String categoryCode, String brand, Principal principal);
	List<CatePListVO> getPListWithLikes(List<WishList> wishList);
	
	// 좋아요 여부 확인
	Boolean getIsLiked(String MID, String PCID);
	
	// 상품 상세 정보 가져오기
	ProductDetailVO getProductDetail(String PCID);
	List<String> getProductImg(String PCID);
	
	// 카테고리 
	List<String> getCategory (String depth1);
	List<String> getCategory(String depth1, String depth2);
	
}
