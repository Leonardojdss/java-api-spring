package br.com.streaming.systemofstreaming.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //ignorar propriedades desconhecidas
public record DataEpisodes(
    @JsonAlias("Title") String title,
    @JsonAlias("Episode") Integer number,
    @JsonAlias("imdbRating") String rating,
    @JsonAlias("Released") String publishDate
) {}
