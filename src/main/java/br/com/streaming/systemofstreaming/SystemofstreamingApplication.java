package br.com.streaming.systemofstreaming;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.streaming.systemofstreaming.model.DataSerie;
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
		var consumerApi = new ConsumerAPI();
		String url = "http://www.omdbapi.com/?t=supernatural&apikey=" + omdbApiKey;
		var json = consumerApi.getdate(url);
		// System.out.println(json);
		ConverteData converteData = new ConverteData();
		DataSerie data = converteData.getdata(json, DataSerie.class);
		System.out.println(data);
	}
	
}