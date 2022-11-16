package com.fpr.controller;

import com.fpr.dto.BookmarkResponseDto;
import com.fpr.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    // 즐겨찾기 등록
    @PostMapping("/bookmark/{memberId}/{productId}")
    public ResponseEntity insertBookmark(@PathVariable Long memberId, @PathVariable Long productId) {
        bookmarkService.insertBookmark(memberId, productId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // 즐겨찾기 전체 삭제
    @DeleteMapping("/bookmark/{bookmarkId}")
    public void deleteBookmark(@PathVariable Long bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
    }

    // 즐겨찾기 단일 삭제
//    @DeleteMapping("/bookmark/{bookmarkId}/{productId}")
//    public void deleteOneBookmark(@PathVariable("bookmarkId") Long bookmarkId, @PathVariable("productId") Long productId){
//        bookmarkService.deleteOneBookmark(bookmarkId, productId);
//    }

    // 즐겨찾기 목록 조회
    @GetMapping("/bookmark/{bookmarkId}")
    public ResponseEntity<BookmarkResponseDto> bookmarkList(@PathVariable("bookmarkId") Long bookmarkId) {
        return ResponseEntity.ok(bookmarkService.getBookmarkList(bookmarkId));
    }

}
