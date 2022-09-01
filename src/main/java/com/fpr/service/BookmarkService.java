package com.fpr.service;

import com.fpr.domain.Bookmark;
import com.fpr.domain.Cart;
import com.fpr.domain.CartItem;
import com.fpr.persistance.BookmarkItemRepository;
import com.fpr.persistance.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkItemRepository bookmarkItemRepository;
//    private final MemberRepository memberRepository;
//    private final ProductRepository productRepository;

    // 즐겨찾기 등록


    // 즐겨찾기 삭제
    @Transactional
    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }


    // 즐겨찾기 목록 조회
    @Transactional
    public List<Bookmark> getBookmarkList(Long memberId) {
        return bookmarkItemRepository.findAllByMemberMemberId(memberId);
    }

}
