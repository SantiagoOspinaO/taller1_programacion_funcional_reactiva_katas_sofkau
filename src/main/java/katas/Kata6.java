package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {

    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(boxarts -> boxarts.stream())
                .reduce((boxart1, boxart2) -> boxart1.getWidth() > boxart2.getWidth() ? boxart1 : boxart2)
                .map(boxart -> boxart.getUrl())
                .get();
    }
}

