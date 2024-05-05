package GDE.futo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FutoApplication {

	public static ArrayList<Result> results = new ArrayList<>();
    public static ArrayList<Runner> runners = new ArrayList<>();
    public static ArrayList<Competition> competitions = new ArrayList<>();  

	public static void main(String[] args) {
		SpringApplication.run(FutoApplication.class, args);
		CsvImporter.letsLoadIt();
		DatabaseConnection.runnersIntoMemory("SELECT * FROM runnerdb");
		DatabaseConnection.compsIntoMemory("SELECT * FROM competitiondb");
		DatabaseConnection.resultsIntoMemory("SELECT * FROM resultsdb");
		
	}

}
