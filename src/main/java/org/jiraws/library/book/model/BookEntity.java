package org.jiraws.library.book.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "book")
@Entity
public class BookEntity {

   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   long id;

   @Column(unique = true)
   String isbn;

    String name;

    String description;

    Integer year;

    Integer pages;
}
