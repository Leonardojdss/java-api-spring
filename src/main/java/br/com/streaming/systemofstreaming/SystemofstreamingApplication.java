package br.com.streaming.systemofstreaming;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.streaming.systemofstreaming.model.DataSerie;
import br.com.streaming.systemofstreaming.model.DataEpisodes;
import br.com.streaming.systemofstreaming.model.DataSeasons;
import br.com.streaming.systemofstreaming.service.ConsumerAPI;
import br.com.streaming.systemofstreaming.service.ConverteData;

@SpringBootApplication
public class SystemofstreamingApplication implements CommandLineRunner {
	@Value("${omdb.api.key}")
	private String omdbApiKey;


	public static void main(String[] args) {
		SpringApplication.run(SystemofstreamingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Consumindo a API do OMDB para obter dados de uma série
		var consumerApi = new ConsumerAPI();
		String url = "http://www.omdbapi.com/?t=supernatural&apikey=" + omdbApiKey;
		var json = consumerApi.getdate(url);
		// System.out.println(json);
		ConverteData converteData = new ConverteData();
		DataSerie dataSerie = converteData.getdata(json, DataSerie.class);
		System.out.println(dataSerie);

		// Consumindo a API do OMDB para obter dados de um episódio específico
		String title = "supernatural";
		String season = "1";
		String episode = "1";
		json = consumerApi.getdate("http://www.omdbapi.com/?t=" + title + "&Season=" + season + "&episode=" + episode + "&apikey=" + omdbApiKey);
		DataEpisodes dataEpisodes = converteData.getdata(json, DataEpisodes.class);
		System.out.println(dataEpisodes);

		// Consumindo a API do OMDB para obter dados de todos episódios das temporadas
		List <DataSeasons> listDataSeasons = new ArrayList<>();

		for (int i = 1; i <= dataSerie.totalSeasons(); i++) {
			title = "supernatural";
			season = String.valueOf(i);
			json = consumerApi.getdate("http://www.omdbapi.com/?t=" + title + "&Season=" + season + "&apikey=" + omdbApiKey);
			DataSeasons dataSeasons = converteData.getdata(json, DataSeasons.class);
			listDataSeasons.add(dataSeasons);
		}
		listDataSeasons.forEach(System.out::println);
	}
	
}