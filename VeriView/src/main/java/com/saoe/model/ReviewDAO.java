package com.saoe.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.saoe.mybatis.SqlSessionManager;

public class ReviewDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// (피드 설정, s_f_201)
	// 메뉴, 지역, 팔로우 별 변수를 받아 테이블을 다르게 select
	public List<ReviewDTO> feedReview() {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		List<ReviewDTO> reviewList = sqlSession.selectList("feedReview");

		for(ReviewDTO review : reviewList) {
			List<ReviewPicDTO> reviewPicList = sqlSession.selectList("feedReviewPic", review);
			review.setReviewPicList(reviewPicList);
			
			List<ReplyDTO> ReplyList = sqlSession.selectList("feedReviewReply", review);
			review.setReplyList(ReplyList);
			
			MemberDTO reviewer = sqlSession.selectOne("selectReviewer", review);
			
			review.setNick(reviewer.getNick());
			review.setProfile(reviewer.getProfile());
			
			RestaurantDTO restaurant = sqlSession.selectOne("selectRest", review);
			review.setRestaurant(restaurant);
			
			CategoryDTO category = sqlSession.selectOne("selectCategory", restaurant);
			review.getRestaurant().setCategory(category);
	}

		sqlSession.close();

		return reviewList;

	}
	
	public ReviewDTO selectReview(int review_no) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		ReviewDTO no = new ReviewDTO();
		no.setReview_no(review_no);
		
		ReviewDTO review = sqlSession.selectOne("selectReview", no);
		
		List<ReviewPicDTO> reviewPicList = sqlSession.selectList("feedReviewPic", review);
		review.setReviewPicList(reviewPicList);
				
		sqlSession.close();
		
		return review;
	}

	// (리뷰 좋아요/싫어요, s_f_301/s_f_302)
	// 정수형 state변수로 -1이면 싫어요, +1이면 좋아요
	public int gbReview(ReviewMemberDTO reviewMember) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		int cnt = sqlSession.update("gbReview", reviewMember);
		
		sqlSession.close();

		return cnt;

	}

	// (리뷰 스크랩, s_f_303)
	public int scrapReview(ReviewDTO review) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		int cnt = sqlSession.update("scrapReview", review);
		
		sqlSession.close();

		return cnt;
	}

	// (리뷰 신고, s_f_304)
	public int reportReview(ReviewDTO review) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		int cnt = sqlSession.update("reportReview", review);
		
		sqlSession.close();

		return cnt;
	}

	// (리뷰 작성, s_f_401)
	public int uploadReview(ReviewDTO review, ReviewPicDTO reviewPic) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		int cnt = sqlSession.insert("uploadReview", review);

		reviewPic.setReview_no(review.getReview_no());

		if (cnt > 0) {
			cnt = sqlSession.insert("uploadPic", reviewPic);
		}

		sqlSession.close();

		return cnt;
	}

	// (리뷰 수정, s_f_402)
	public int updateReview(ReviewDTO review) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		int cnt = sqlSession.update("updateReview", review);
		
		sqlSession.close();

		return cnt;
	}

	// (리뷰 삭제, s_f_403)
	public int deleteReview(int review_no) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		ReviewDTO no = new ReviewDTO();
		no.setReview_no(review_no);
		
		int cnt = sqlSession.update("deleteReview", no);
		
		sqlSession.close();

		return cnt;
	}

	// (리뷰 차단, s_f_506)
	public int blockReview(ReviewDTO review) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		int cnt = sqlSession.update("blockReview", review);
		
		sqlSession.close();

		return cnt;
	}

	// (회원 리뷰 조회, s_f_504)
	public int memberReview() {

		return 0;
	}

}