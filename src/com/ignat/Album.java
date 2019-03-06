package com.ignat;

import java.util.ArrayList;

public class Album {

    private String albumTitle;
    private ArrayList<Song> songs;

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.songs = new ArrayList<>();
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void addSong (Song song) {
        this.songs.add(song);
    }
    public Song retrieveSong(int songIndex) {
        return this.songs.get(songIndex);
    }

    public void printAlbum () {
        System.out.println(this.albumTitle + "\n====================================");
        for(int i =0; i<this.songs.size();i++) {
            System.out.println((i+1) + ": " + this.songs.get(i).getTitle() + " (" + this.songs.get(i).getDuration() + ")");
        }
        System.out.println();
    }
}
