package shapes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author declan
 */
public class Player {
    private int pid;
    private String gamertag;
    public int gamercore;

    public Player(){}

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getGamertag() {
        return gamertag;
    }

    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    public int getGamercore() {
        return gamercore;
    }

    public void setGamercore(int gamercore) {
        this.gamercore = gamercore;
    }
    
}