package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movielist -> movielist.getVideos().stream())
                .map(movie -> Map.of("id", movie.getId(), "title", movie.getTitle(), "time", movie.getInterestingMoments().stream()
                        .map(moment -> moment.getTime()), "url", movie.getBoxarts().stream()
                            .reduce((boxart, boxart2) -> boxart.getWidth() * boxart.getHeight() < boxart2.getWidth() * boxart2.getHeight() ? boxart : boxart2)))
                .collect(Collectors.toList());
    }
}
