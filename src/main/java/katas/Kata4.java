package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movielist -> movielist.getVideos().stream()
                        .map(movie -> Map.of("id", movie.getId(),"title", movie.getTitle(),"box", movie.getBoxarts().stream()
                                .filter(boxart -> boxart.getWidth() == 150 && boxart.getHeight() == 200)
                                .collect(Collectors.toList()))))
                .collect(Collectors.toList());
    }
}
