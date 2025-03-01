package com.esr.service.game.component.adventurer;

import com.esr.service.game.component.cards.TreasureFigurines;
import com.esr.utils.Map;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Author William
 * @Date 2020/11/8
 * @Version 1.0
 **/
public abstract class Adventurer {
    protected int id;
    protected int order;
    protected int x;
    protected int y;
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected String name;
    protected String pawnImg;
    protected ArrayList<Integer> handCards;
    protected ArrayList<TreasureFigurines> capturedFigurines;

    public Adventurer(int order, String name) {
        this.order = order;
        this.name = name;
        this.pawnImg = "/Pawns/" + this.name + ".png";
        this.handCards = new ArrayList<>();
        this.capturedFigurines = new ArrayList<>();
    }

    // set position of an adventurer
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // before check whether we can move to a tile, put coordinates here temporarily
    public void setMove(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    // move to buffered coordinates
    public void Move() {
        this.x = this.x1;
        this.y = this.y1;
    }

    // set the tile position that will be shored up
    public void setShoreUp(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    // give player hand cards
    public void setHandCards(ArrayList<Integer> handCards) {
        this.handCards.addAll(handCards);
    }

    public void setCapturedFigurines(TreasureFigurines capturedFigurines) {
        this.capturedFigurines.add(capturedFigurines);
    }

    public ArrayList<TreasureFigurines> getCapturedFigurines() {
        return capturedFigurines;
    }

    public ArrayList<Integer> getHandCards() {
        return handCards;
    }

    public String getPawnImg() {
        return pawnImg;
    }

    public int getOrder() {
        return order;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getPos() {
        return Map.numberMatcher.get(Arrays.toString(new int[]{this.x, this.y}));
    }

    public int getShoredPos() {
        return Map.numberMatcher.get(Arrays.toString(new int[]{this.x2, this.y2}));
    }
}
