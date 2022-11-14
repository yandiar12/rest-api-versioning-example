package com.yandiar.api.models;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Book {
    private int id;
    private String name;
    private String author;
}
