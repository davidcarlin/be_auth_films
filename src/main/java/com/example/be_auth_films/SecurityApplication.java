package com.example.be_auth_films;

import com.example.be_auth_films.film.Film;
import com.example.be_auth_films.film.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(FilmRepository filmRepository) {
        return args -> {
            // Check if films already exist in the database
            if (filmRepository.count() == 0) {
                List<Film> films = Arrays.asList(
                        Film.builder()
                                .name("Inception")
                                .director("Christopher Nolan")
                                .year(2010)
                                .build(),
                        Film.builder()
                                .name("The Shawshank Redemption")
                                .director("Frank Darabont")
                                .year(1994)
                                .build(),
                        Film.builder()
                                .name("The Godfather")
                                .director("Francis Ford Coppola")
                                .year(1972)
                                .build(),
                        Film.builder()
                                .name("Pulp Fiction")
                                .director("Quentin Tarantino")
                                .year(1994)
                                .build(),
                        Film.builder()
                                .name("The Dark Knight")
                                .director("Christopher Nolan")
                                .year(2008)
                                .build(),
                        Film.builder()
                                .name("Fight Club")
                                .director("David Fincher")
                                .year(1999)
                                .build(),
                        Film.builder()
                                .name("Forrest Gump")
                                .director("Robert Zemeckis")
                                .year(1994)
                                .build(),
                        Film.builder()
                                .name("The Matrix")
                                .director("Lana Wachowski")
                                .year(1999)
                                .build(),
                        Film.builder()
                                .name("Goodfellas")
                                .director("Martin Scorsese")
                                .year(1990)
                                .build(),
                        Film.builder()
                                .name("The Lord of the Rings: The Fellowship of the Ring")
                                .director("Peter Jackson")
                                .year(2001)
                                .build()
                );

                filmRepository.saveAll(films);
                System.out.println("10 popular films added to the database.");
            }
        };
    }
}