package it.progettojava.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.progettojava.best_of_the_year.model.Movie;
import it.progettojava.best_of_the_year.model.Song;


@Controller
@RequestMapping("/")
public class BestController {
    @GetMapping("/")
    public String BestController(@RequestParam(required = false) String nome, Model home) {
        nome = "Giovanni Occhipinti";
        home.addAttribute("nome", nome);
        
        return "bestofby";
    }
    
    private List<Movie> getBestMovies(){
        List<Movie> moviesList = new ArrayList<>();

        moviesList.add(new Movie(1, "Titanic"));
        moviesList.add(new Movie(2, "Madagascar 2"));
        moviesList.add(new Movie(3, "Pelè"));

        return moviesList;
    }

    private List<Song> getBestSongs(){
        List<Song> songsList = new ArrayList<>();

        songsList.add(new Song(1, "El Pibe de Oro"));
        songsList.add(new Song(2, "Rondini al guinzaglio"));
        songsList.add(new Song(3, "Sally"));

        return songsList;
    }


    @GetMapping("/movies")
   
    public String showMovies(Model moviesModel) {
        List<Movie> movies = getBestMovies(); 
        String titoli = movies.stream()
        .map(Movie::getTitolo)
        .collect(Collectors.joining(", "));

        moviesModel.addAttribute("titoli", titoli);

        return "movies";
    }

    @GetMapping("/songs")
   
    public String showSongs(Model songsModel) {
        List<Song> movies = getBestSongs(); 
        String titoli = movies.stream()
        .map(Song::getTitolo)
        .collect(Collectors.joining(", "));

        songsModel.addAttribute("titoli", titoli);

        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String showMovieById(@PathVariable int id, Model movieIdModel) {
        Movie movie = getBestMovies().stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
        String titolo = (movie != null) ? movie.getTitolo() : "This movie not exist";

        movieIdModel.addAttribute("titolo", titolo);

        return "moviebyid";
    }

    @GetMapping("/songs/{id}")
    public String showSongById(@PathVariable int id, Model songIdModel) {
        Song song = getBestSongs().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        String titolo = (song != null) ? song.getTitolo() : "This song not exist";

        songIdModel.addAttribute("titolo", titolo);

        return "songbyid";
    }
}

