package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movies {
  private int id;
  private int MovieId;
  private String MovieName;
  private int MovieGenre;
  private int image;


}
