package com.fpr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookmarkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookmark_Id")
    private Bookmark bookmark;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_Id")
//    private Product product;
}
