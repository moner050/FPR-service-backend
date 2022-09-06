package com.fpr.service;

import com.fpr.domain.Bookmark;
import com.fpr.domain.Member;
import com.fpr.domain.Product;
import com.fpr.dto.BookmarkResponseDto;
import com.fpr.persistence.BookmarkRepository;
import com.fpr.persistence.MemberRepository;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    // 즐겨찾기 등록
    @Transactional
    public void insertBookmark(Long memberId ,Long productId){
        Optional<Product> product = productRepository.findById(productId);
        Optional<Member> member = memberRepository.findById(memberId);

        product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다."));
        member.orElseThrow(() -> new RuntimeException("검색된 맴버가 없습니다."));

        Optional<Bookmark> bookmark = bookmarkRepository.findByBookmarkId(memberId);
        if(!bookmark.isPresent()) {
            bookmark = Optional.of(new Bookmark());
        }

        bookmark.get().setBookmarkId(memberId);
        bookmark.get().addProduct(product.get());

        BookmarkResponseDto.of(bookmarkRepository.save(bookmark.get()));
    }

    // 즐겨찾기 삭제
    @Transactional
    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }

    // 즐겨찾기 단일 삭제
//    @Transactional
//    public void deleteOneBookmark(Long bookmarkId, Long productId) {
//        Optional<Product> product = productRepository.findById(productId);
//        Optional<Member> member = memberRepository.findById(bookmarkId);
//
//        product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다."));
//        member.orElseThrow(() -> new RuntimeException("검색된 맴버가 없습니다."));
//
//        Optional<Bookmark> bookmark = bookmarkRepository.findByBookmarkId(bookmarkId);
//
//        bookmark.get().setBookmarkId(bookmarkId);
//        bookmark.get().removeProduct(product.get());
//
//        BookmarkResponseDto.of(bookmarkRepository.save(bookmark.get()));
//    }


    // 즐겨찾기 목록 조회
    @Transactional(readOnly = true)
    public BookmarkResponseDto getBookmarkList(Long bookmarkId) {
        return bookmarkRepository.findByBookmarkId(bookmarkId)
                .map(BookmarkResponseDto::of)
                .orElseThrow(() -> new RuntimeException("즐겨찾기 목록이 없습니다."));
    }
}
