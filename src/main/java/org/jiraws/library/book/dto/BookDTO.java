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
        String bookName;

        @NonNull
        Integer bookPages;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class  PostOutput{

        Long id;

        String bookName;

        Integer bookPages;


    }
}
