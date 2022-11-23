package com.fpr.service;

import com.fpr.domain.Bookmark;
import com.fpr.domain.BookmarkItem;
import com.fpr.domain.Member;
import com.fpr.domain.Product;
import com.fpr.dto.BookmarkResponseDto;
import com.fpr.persistence.BookmarkItemRepository;
import com.fpr.persistence.BookmarkRepository;
import com.fpr.persistence.MemberRepository;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkItemRepository bookmarkItemRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    // 즐겨찾기 등록
    @Transactional
    public void insertBookmark(Long memberId ,Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다."));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("검색된 맴버가 없습니다."));

        Bookmark bookmark = bookmarkRepository.findByMemberId(memberId)
                .orElse(Bookmark.builder().member(member).build());

        BookmarkItem bookmarkItem = bookmarkItemRepository.findByBookmarkIdAndProductId(bookmark.getId(), productId)
                .orElse(BookmarkItem.builder().bookmark(bookmark).product(product).build());

        bookmarkRepository.save(bookmark);
        bookmarkItemRepository.save(bookmarkItem);
    }

    // 즐겨찾기 전체 삭제
    @Transactional
    public void deleteAllBookmark(Long bookmarkId) {
        bookmarkRepository.deleteByMemberId(bookmarkId);
    }

    // 즐겨찾기 단일 삭제
    @Transactional
    public void deleteBookmark(Long memberId, Long productId) {
        Bookmark bookmark = bookmarkRepository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException("즐겨찾기가 존재하지 않습니다."));

        BookmarkItem bookmarkItem = bookmarkItemRepository.findByBookmarkIdAndProductId(bookmark.getId(), productId)
                .orElseThrow(() -> new RuntimeException("검색된 즐겨찾기 목록이 없습니다."));

        bookmarkItemRepository.delete(bookmarkItem);
    }

    // 즐겨찾기 목록 조회
    @Transactional(readOnly = true)
    public List<BookmarkResponseDto> getBookmarkList(Long memberId) {
        Bookmark bookmark = bookmarkRepository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException("즐겨찾기가 존재하지 않습니다."));

        List<Product> productList = bookmarkItemRepository.findAllByBookmarkId(bookmark.getId())
                .stream().map(BookmarkItem::getProduct).collect(Collectors.toList());

        return productList.stream().map(BookmarkResponseDto::of).collect(Collectors.toList());
    }
}
