# Popular Movies

Here is a fully functional and colorful android app which I made from scratch for Android Developer Nanodegree program.
This app reveals the power of adaptive UI both for phone and tablet devices.

*Popular Movies* was highly evaluated by certified Udacity code reviewer and was graded as "Exceeds Specifications".

<img src= "https://github.com/JeffGoodrich9791/Popular-Movies-Stage-1/blob/master/PopularMoviesApp1" />

## Features

With the app, you can:
* Discover the most popular, the most rated or the highest rated movies
* Save favorite movies locally to view them even when offline
* Watch trailers
* Read reviews

<img src= "https://github.com/JeffGoodrich9791/Popular-Movies-Stage-1/blob/master/PopularMoviesApp2" />

## Utilizing the Source API

This app uses [The Movie Database](https://www.themoviedb.org/documentation/api) API to retrieve movies.
You must provide your own API key in order to build the app. Upon fetching an API Key, all you have to do is insert your 
API Key into this section of code in the MovieUrlUitls.java file. 


    public class MovieUrlUtils {

    /**
     * Put your api key here ****************
     */
    public static final String API_KEY = "YOUR API KEY HERE";
    /**
     * **************************************
     */
    private static final String LOG_TAG = MovieUrlUtils.class.getSimpleName();
    private static final String MOVIE_QUERY_API = "api_key";
    private static final String MOVIE_BASE_URL = "https://api.themoviedb.org/3/movie/";
    ```

## Libraries

* [ButterKnife](https://github.com/JakeWharton/butterknife)
* [Retrofit](https://github.com/square/retrofit)
* [SQLBrite](https://github.com/square/sqlbrite)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [Picasso](https://github.com/bumptech/glide)
* [Android-ObservableScrollView](https://github.com/ksoichiro/Android-ObservableScrollView)
* [Gradle Retrolambda Plugin](https://github.com/evant/gradle-retrolambda)
