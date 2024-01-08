package com.example.storageservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name="ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImageData {
    @Id

@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  String type;
    @Lob
    @Column(name = "imagedata",length= 1000)
    private  byte[] imageData;

}
