package com.ignat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();
        // Adding albums to a list:
        albums.add(new Album("The Eminem Show"));
        albums.add(new Album("Encore"));
        albums.add(new Album("Revival"));
        albums.add(new Album("Kamikaze"));

        //Adding songs to album The Eminem Show:
        albums.get(0).addSong(new Song("White America",5.25));
        albums.get(0).addSong(new Song("Cleanin' out my closet",4.58));
        albums.get(0).addSong(new Song("Square Dance",5.24));
        albums.get(0).addSong(new Song("Soldier",3.46));
        albums.get(0).addSong(new Song("Without Me",4.50));
        albums.get(0).addSong(new Song("Sing for the Moment",5.40));
        albums.get(0).addSong(new Song("Superman",5.50));
        albums.get(0).addSong(new Song("'Till I collapse",4.58));

        //Adding songs to album Encore:
        albums.get(1).addSong(new Song("Like toy soldiers",4.50));
        albums.get(1).addSong(new Song("Mosh",5.18));
        albums.get(1).addSong(new Song("Just lose it",4.09));
        albums.get(1).addSong(new Song("Mockingbird",4.11));
        albums.get(1).addSong(new Song("Encore",5.13));

        //Adding songs to album Revival:
        albums.get(2).addSong(new Song("Believe",5.15));
        albums.get(2).addSong(new Song("Framed",4.13));
        albums.get(2).addSong(new Song("In your head",3.03));

        //Adding songs to album Kamikaze:
        albums.get(3).addSong(new Song("Greatest",3.47));
        albums.get(3).addSong(new Song("Venom",4.30));

        //Printing albums:
        printAlbums(albums);

        //Adding song to playlist
        LinkedList<Song> playlist = new LinkedList<>();
        playlist.add(getSong(albums,0,4));
        playlist.add(getSong(albums,0,5));
        playlist.add(getSong(albums,0,6));
        playlist.add(getSong(albums,3,1));
        playlist.add(getSong(albums,1,2));
        playlist.add(getSong(albums,2,1));
        playlist.add(getSong(albums,0,7));

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        int choice;
        ListIterator<Song> listIterator = playlist.listIterator();
        boolean goingForward = true;
        if(playlist.isEmpty()) {
            System.out.println("No songs in playlist!");
        } else {
            System.out.println("Now playing:   " + listIterator.next().getTitle());
            printOptions();

            while (!quit) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0: //exit while
                        quit = true;
                        break;
                    case 1: //play next song in playlist
                        if(!goingForward) {
                            if(listIterator.hasNext()) {
                                listIterator.next();
                            }
                        }
                        if(listIterator.hasNext()){
                            System.out.println("Next song ==> Now playing:   " + listIterator.next().getTitle());
                            goingForward=true;
                        } else {
                            System.out.println("Reached end of playlist");
                        }
                        break;
                    case 2: //play previous song in playlist
                        if(goingForward){
                            if(listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                        }
                        if(listIterator.hasPrevious()){
                            System.out.println("Previous song ==> Now playing:   " + listIterator.previous().getTitle());
                            goingForward = false;
                        } else {
                            System.out.println("Reached beginning of playlist");
                        }
                        break;
                    case 3: //replay current song
                        System.out.print("Replay ==> Now playing:   ");
                        if(goingForward) {
                            System.out.println(listIterator.previous().getTitle());
                            goingForward=false;
                        } else {
                            System.out.println(listIterator.next().getTitle());
                            goingForward=true;
                        }
                        break;
                    case 4: //list song in playlist
                        listSong(playlist);
                        break;
                    case 5: //remove current song from playlist
                        listIterator.remove();
                        break;
                    case 6:
                        printOptions();
                        break;
                }
            }
        }
    }

    public static void printAlbums(ArrayList<Album> albums) {
        for(int i=0;i<albums.size();i++) {
            albums.get(i).printAlbum();
        }
    }


    public static Song getSong(ArrayList<Album> album, int albumIndex, int songIndex) {
        return album.get(albumIndex).retrieveSong(songIndex);
    }

    public static void printOptions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("\t0  - to exit\n" +
                "\t1  - to play next song\n" +
                "\t2  - to play previous song\n" +
                "\t3  - to replay current song\n" +
                "\t4  - to list the songs in this playlist\n" +
                "\t5  - to remove current song from playlist\n" +
                "\t6  - to print options");
        System.out.println("Choose your action: ");
    }

     public static void listSong(LinkedList<Song> playlist) {
        ListIterator<Song> printSong = playlist.listIterator();
        while(printSong.hasNext()) {
            System.out.println(printSong.next().getTitle());
        }
      }
}
