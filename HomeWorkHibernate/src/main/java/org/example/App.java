package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            //Получение режисера и его фильмов
//            Director director = session.get(Director.class, 1);
//            System.out.println(director.getMovies());
            //Получение фильма и его режиссера
//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getDirector());

//            Добавляем фильм
//            Director director = session.get(Director.class, 2);
//            Movie newMovie = new Movie("NewMovie",1999,director);
//            session.persist(newMovie);
//            director.getMovies().add(newMovie);
//            Создание нового режиссера и фильм + их связка
//            Director director = new Director("NewDirector", 65);
//            session.persist(director);
//            Movie newMovie = new Movie("TestMovie", 1987, director);
//            director.setMovies(new ArrayList<>(Collections.singletonList(newMovie)));
//            session.persist(newMovie);
//            newMovie.setDirector(director);
// Меняем фильму режиссера , и нужно удалить фильм у старого
//            Movie movie = session.get(Movie.class, 5);
//
//            Director newDirector = session.get(Director.class,1);
//            movie.setDirector(newDirector);
//            newDirector.getMovies().add(movie);

            Director director = session.get(Director.class, 1);
            Movie movie = session.get(Movie.class, 1);

            director.getMovies().remove(movie);
            session.remove(movie);


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}