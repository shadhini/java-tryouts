package com.shadhini.java.helpers.pagination;

import java.util.Arrays;

public class PaginationDemo {

    public static void main(String[] args) {
        var movies = new Movie[]{
            new Movie("Movie A", 100),
            new Movie("Movie B", 200),
            new Movie("Movie C", 300),
            new Movie("Movie D", 400),
            new Movie("Movie E", 500),
            new Movie("Movie F", 600),
            new Movie("Movie G", 700),
            new Movie("Movie H", 800),
            new Movie("Movie I", 900),
            new Movie("Movie J", 1000),
            new Movie("Movie K", 1100),
            new Movie("Movie L", 1200),
            new Movie("Movie M", 1300),
            new Movie("Movie N", 1400),
            new Movie("Movie O", 1500),
            new Movie("Movie P", 1600),
            new Movie("Movie Q", 1700),
            new Movie("Movie R", 1800),
            new Movie("Movie S", 1900),
            new Movie("Movie T", 2000),
            new Movie("Movie U", 2100),
            new Movie("Movie V", 2200),
            new Movie("Movie W", 2300),
            new Movie("Movie X", 2400),
            new Movie("Movie Y", 2500),
            new Movie("Movie Z", 2600)
        };

        // 26 movies
        // 3 movies per page -> pageSize = 3
        // current page = 4
        // @ current page : skip(12) and limit(3)
        // skip -> skip( (page - 1) * pageSize )
        // limit -> limit(pageSize)
        paginate(movies, 3, 4);
    }

    /**
     * Paginates the movies array and prints the titles and likes of the movies on the specified page.
     *
     * @param movies      The array of movies to paginate.
     * @param pageSize    The number of movies per page.
     * @param currentPage The current page number (1-based).
     */
    public static void paginate(Movie[] movies, int pageSize, int currentPage) {
        Arrays.stream(movies)
            .skip((currentPage - 1) * pageSize)
            .limit(pageSize)
            .forEach(movie -> System.out.println(movie.getTitle() + " - " + movie.getLikes() + " likes"));
    }
}
