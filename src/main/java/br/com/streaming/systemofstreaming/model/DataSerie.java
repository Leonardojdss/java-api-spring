package br.com.streaming.systemofstreaming.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(
    @JsonAlias("Title") String title,
    @JsonAlias("totalSeasons") Integer totalTemp,
    @JsonAlias("imdbRating") String ratingIMDB
    // @JsonProperty("imdbVotes") String votesIMDB
) {



}
