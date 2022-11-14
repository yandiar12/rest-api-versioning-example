package com.yandiar.api.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentV2 {
    private int id;
    private String name;
    private String address;
    private String gender;
}
