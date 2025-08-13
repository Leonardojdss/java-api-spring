package br.com.streaming.systemofstreaming.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //ignorar propriedades desconhecidas
public record DataSeasons(
    @JsonAlias("Season") Integer seasonNumber,
    @JsonAlias("Episodes") List<DataEpisodes> episodes
) {

}
