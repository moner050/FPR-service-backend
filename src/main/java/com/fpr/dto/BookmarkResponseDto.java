package com.fpr.dto;

import com.fpr.domain.Bookmark;
import com.fpr.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkResponseDto {

    private List<Product> products = new ArrayList<>();

//    public static BookmarkResponseDto of(Bookmark bookmark) {
//        return new BookmarkResponseDto (bookmark);
//    }
}
