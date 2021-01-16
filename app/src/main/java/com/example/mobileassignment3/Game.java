package com.example.mobileassignment3;

public class Game {
    private String name;
    private String genre;
    private String year;
    private String developer;
    private String imgID;
    private String lon;
    private String lat;


    public Game() {
    }

    public Game(String name, String genre, String year, String developer, String imgID, String lon, String lat) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.developer = developer;
        this.imgID = imgID;
        this.lon = lon;
        this.lat = lat;
    }
    //
//    public static final Game[] games = {
//            new Game("Uncharted 4: A Thief's End", "Action & Adventure",
//                    2016, "Naughty Dog", R.drawable.uncharted4),
//            new Game("CyberPunk 2077", "RPG",
//                    2020, "CD Projekt Red", R.drawable.cyberpunk),
//            new Game("Assassin\'s Creed Brotherhood", "Action & Adventure",
//                    2010, "Ubisoft", R.drawable.acbrotherhood),
//            new Game("The Last of Us", "Survival",
//                    2013, "Naughty Dog", R.drawable.lastofus),
//            new Game("FIFA 2020", "Sports",
//                    2019, "EA Games", R.drawable.fifa),
//            new Game("Horizon Zero Dawn", "Action & Adventure",
//                    2017, "Guerrilla Games", R.drawable.horizonzerodawn),
//            new Game("The Witcher 3: Wild Hunt", "RPG",
//                    2015, "CD Projekt Red", R.drawable.witcher3),
//            new Game("The Crew 2", "Racing",
//                    2018, "Ubisoft", R.drawable.crew2),
//            new Game("God Of War", "Hack and Slash",
//                    2018, "Santa Monica Studio", R.drawable.godofwar),
//            new Game("Call of Duty: Black Ops", "First Person Shooter",
//                    2010, "Treyarch", R.drawable.blackops),
//            new Game("Red Dead Redemption 2", "Action & Adventure",
//                    2018, "Rockstar Games", R.drawable.reddeadredemption),
//            new Game("Ghost of Tsushima", "RPG",
//                    2020, "Sucker Punch", R.drawable.ghostoftsushima),
//    };


    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getImgID() {
        return imgID;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }
}
