package org.jiraws.library.book.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

public class BookDTO {


    @Data
    @AllArgsConstructor
    @Builder
    public static  class PostInput {
        @NonNull @NotBlank
        String isbn;

        @NonNull @NotBlank
        String bookName;

        @NonNull
        Integer bookPages;

        Integer year;

        String description;


    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class  PostOutput{

        Long bookId;
        String bookIsbn;
        String bookName;
        Integer bookPages;
        Integer bookYear;
        String bookDescription;

    }
}
