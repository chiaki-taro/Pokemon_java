package com.example.pokemonapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * トレーナーを表すクラス。
 * 各トレーナーは名前とポケモンのリストを持つ。
 */
public class Trainer {
    
    private String name;
    private List<Pokemon> pokemon;
    
    /**
     * Trainerクラスのコンストラクタ。
     * 新しいトレーナーを作成し、空のポケモンリストを初期化する。
     *
     * @param name トレーナーの名前
     */
    public Trainer(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
    }
    
    

}
