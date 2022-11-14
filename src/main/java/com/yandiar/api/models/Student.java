package com.yandiar.api.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    private int id;
    private String name;
    private String address;
}
