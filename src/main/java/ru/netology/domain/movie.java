package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class movie {
  private int id;
  private String movieName;
  private String movieGenre;
  private String image;


}
