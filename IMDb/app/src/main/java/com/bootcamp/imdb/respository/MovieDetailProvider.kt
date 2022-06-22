package com.bootcamp.imdb.respository

import com.bootcamp.imdb.model.MovieDetail

//el genero seria mejor manejarlo por tags, ya que cada uno puede poseer varios
class MovieDetailProvider {
    companion object {
        val movieDetailList = listOf(
            MovieDetail(
                "Godzilla vs. Kong",
                "https://image.tmdb.org/t/p/w1280/iopYFB1b6Bh7FWZh3onQhph1sih.jpg",
                "Ciencia Ficción",
                null,
                null,
                null
            ),
            MovieDetail(
                "Spider-Man: No Way Home",
                "https://image.tmdb.org/t/p/w1280/VlHt27nCqOuTnuX6bku8QZapzO.jpg",
                "Ciencia Ficción",
                null,
                null,
                null
            ),
            MovieDetail(
                "Luca",
                "https://image.tmdb.org/t/p/w1280/PGSknIQZ96l7MG8nyQ76MuYnfY.jpg",
                "Aventura",
                null,
                null,
                null
            ),
            MovieDetail(
                "Cruella",
                "https://image.tmdb.org/t/p/w1280/huzHIuaWRMDIAB8jIXYAwE7CJzS.jpg",
                "Comedia",
                null,
                null,
                null
            ),
            MovieDetail(
                "Zack Snyder's Justice League",
                "https://image.tmdb.org/t/p/w1280/egtcnLhyj2A56uLmmfYX2p73Eky.jpg",
                "Accion | Fantasia",
                null,
                null,
                null
            ),
            MovieDetail(
                "Encanto",
                "https://image.tmdb.org/t/p/w1280/g2djzUqA6mFplzC03gDk0WSyg99.jpg",
                "Aventura",
                null,
                null,
                null
            ),
            MovieDetail(
                "Avengers: Endgame",
                "https://image.tmdb.org/t/p/w1280/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg",
                "Aventura | Fantasia",
                null,
                null,
                null
            ),
            MovieDetail(
                "Fast & Furious 9",
                "https://image.tmdb.org/t/p/w1280/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg",
                "Accion | Crimen",
                null,
                null,
                null
            ),
            MovieDetail(
                "Raya and the Last Dragon",
                "https://image.tmdb.org/t/p/w1280/hJuDvwzS0SPlsE6MNFOpznQltDZ.jpg",
                "Aventura",
                null,
                null,
                null
            ),
            MovieDetail(
                "Joker",
                "https://image.tmdb.org/t/p/w1280/ftkY1xIQ6ianSVp3EDufPVPLwa2.jpg",
                "Drama | Crimen",
                null,
                null,
                null
            ),
            MovieDetail(
                "Venom: Let There Be Carnage",
                "https://image.tmdb.org/t/p/w1280/t9nyF3r0WAlJ7Kr6xcRYI4jr9jm.jpg",
                "Ciencia Ficcion",
                null,
                null,
                null
            ),
            MovieDetail(
                "Mortal Kombat",
                "https://image.tmdb.org/t/p/w1280/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "Accion | Fantasia",
                null,
                null,
                null
            ),
            MovieDetail(
                "The Suicide Squad",
                "https://image.tmdb.org/t/p/w1280/rAgsOIhqRS6tUthmHoqnqh9PIAE.jpg",
                "Accion | Comedia",
                null,
                null,
                null
            ),
            MovieDetail(
                "Soul",
                "https://image.tmdb.org/t/p/w1280/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg",
                "Aventura",
                null,
                null,
                null
            ),
            MovieDetail(
                "Harry Potter and the Philosopher's Stone",
                "https://image.tmdb.org/t/p/w1280/hziiv14OpD73u9gAak4XDDfBKa2.jpg",
                "Fantasia",
                null,
                null,
                null
            ),
            MovieDetail(
                "Space Jam: A New Legacy",
                "https://image.tmdb.org/t/p/w1280/dkkDuToxTRMh5lmJXfULEOQK1ZM.jpg",
                "Aventura",
                null,
                null,
                null
            )
        )
    }
}