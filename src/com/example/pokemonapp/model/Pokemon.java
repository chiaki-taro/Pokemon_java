package com.example.pokemonapp.model;

import java.util.List;

/**
 * ポケモンを表すクラス。
 * 各ポケモンは名前、タイプ、HP、攻撃力、防御力を持つ。
 */
public class Pokemon {
    
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private List<Move> moves;
    
    /**
     * Pokemonクラスのコンストラクタ。
     *
     * @param name    ポケモンの名前
     * @param type    ポケモンのタイプ
     * @param hp      ポケモンの体力（HP）
     * @param attack  ポケモンの攻撃力
     * @param defense ポケモンの防御力
     * @param speed   ポケモンの素早さ
     * @param moves   ポケモンの技
     */
    public Pokemon(String name, String type, int hp, int attack, int defense, int speed, List<Move> moves) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = moves;
    }
    
    /**
     * ポケモンの名前を取得する。
     *
     * @return ポケモンの名前
     */
    public String getName() { 
        return name; 
    }

    /**
     * ポケモンのタイプを取得する。
     *
     * @return ポケモンのタイプ
     */
    public String getType() { 
        return type; 
    }

    /**
     * ポケモンの現在のHPを取得する。
     *
     * @return ポケモンの現在のHP
     */
    public int getHp() { 
        return hp; 
    }

    /**
     * ポケモンのHPを設定する。
     *
     * @param hp 設定するHP値
     */
    public void setHp(int hp) { 
        this.hp = hp;
    }

    /**
     * ポケモンの攻撃力を取得する。
     *
     * @return ポケモンの攻撃力
     */
    public int getAttack() { 
        return attack; 
    }

    /**
     * ポケモンの防御力を取得する。
     *
     * @return ポケモンの防御力
     */
    public int getDefense() { 
        return defense; 
    }
    
    /**
     * ポケモンの素早さを取得する。
     *
     * @return ポケモンの素早さ
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * ポケモンの技を取得する。
     *
     * @return ポケモンの技
     */
    public List<Move> getMoves() {
        return moves;
    }

}
