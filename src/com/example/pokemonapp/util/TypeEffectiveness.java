package com.example.pokemonapp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ポケモンの技のタイプ相性を管理するクラス。
 * 技のタイプとポケモンのタイプに基づいて、技の効果倍率を計算する。
 */
public class TypeEffectiveness {
    
    // タイプごとの効果倍率を保持するマップ
    private static final Map<String, Map<String, Double>> typeChart = new HashMap<>();

    static {
        // ノーマルタイプ
        Map<String, Double> normalChart = new HashMap<>();
        normalChart.put("いわ", 0.5);
        normalChart.put("ゴースト", 0.0);
        normalChart.put("はがね", 0.5);
        typeChart.put("ノーマル", normalChart);

        // ほのおタイプ
        Map<String, Double> fireChart = new HashMap<>();
        fireChart.put("くさ", 2.0);
        fireChart.put("みず", 0.5);
        fireChart.put("ほのお", 0.5);
        fireChart.put("こおり", 2.0);
        fireChart.put("むし", 2.0);
        fireChart.put("いわ", 0.5);
        fireChart.put("ドラゴン", 0.5);
        fireChart.put("はがね", 2.0);
        typeChart.put("ほのお", fireChart);

        // みずタイプ
        Map<String, Double> waterChart = new HashMap<>();
        waterChart.put("ほのお", 2.0);
        waterChart.put("みず", 0.5);
        waterChart.put("くさ", 0.5);
        waterChart.put("じめん", 2.0);
        waterChart.put("いわ", 2.0);
        waterChart.put("ドラゴン", 0.5);
        typeChart.put("みず", waterChart);

        // くさタイプ
        Map<String, Double> grassChart = new HashMap<>();
        grassChart.put("ほのお", 0.5);
        grassChart.put("みず", 2.0);
        grassChart.put("くさ", 0.5);
        grassChart.put("どく", 0.5);
        grassChart.put("じめん", 2.0);
        grassChart.put("ひこう", 0.5);
        grassChart.put("むし", 0.5);
        grassChart.put("いわ", 2.0);
        grassChart.put("ドラゴン", 0.5);
        typeChart.put("くさ", grassChart);
        
     // でんきタイプ
        Map<String, Double> electricChart = new HashMap<>();
        electricChart.put("みず", 2.0);
        electricChart.put("でんき", 0.5);
        electricChart.put("じめん", 0.0);
        electricChart.put("ひこう", 2.0);
        electricChart.put("ドラゴン", 0.5);
        typeChart.put("でんき", electricChart);

        // こおりタイプ
        Map<String, Double> iceChart = new HashMap<>();
        iceChart.put("ほのお", 0.5);
        iceChart.put("みず", 0.5);
        iceChart.put("くさ", 2.0);
        iceChart.put("こおり", 0.5);
        iceChart.put("じめん", 2.0);
        iceChart.put("ひこう", 2.0);
        iceChart.put("ドラゴン", 2.0);
        typeChart.put("こおり", iceChart);

        // かくとうタイプ
        Map<String, Double> fightingChart = new HashMap<>();
        fightingChart.put("ノーマル", 2.0);
        fightingChart.put("こおり", 2.0);
        fightingChart.put("どく", 0.5);
        fightingChart.put("ひこう", 0.5);
        fightingChart.put("エスパー", 0.5);
        fightingChart.put("むし", 0.5);
        fightingChart.put("いわ", 2.0);
        fightingChart.put("ゴースト", 0.0);
        fightingChart.put("あく", 2.0);
        fightingChart.put("はがね", 2.0);
        typeChart.put("かくとう", fightingChart);

        // どくタイプ
        Map<String, Double> poisonChart = new HashMap<>();
        poisonChart.put("くさ", 2.0);
        poisonChart.put("どく", 0.5);
        poisonChart.put("じめん", 0.5);
        poisonChart.put("いわ", 0.5);
        poisonChart.put("ゴースト", 0.5);
        poisonChart.put("はがね", 0.0);
        typeChart.put("どく", poisonChart);

        // じめんタイプ
        Map<String, Double> groundChart = new HashMap<>();
        groundChart.put("ほのお", 2.0);
        groundChart.put("でんき", 2.0);
        groundChart.put("くさ", 0.5);
        groundChart.put("どく", 2.0);
        groundChart.put("ひこう", 0.0);
        groundChart.put("むし", 0.5);
        groundChart.put("いわ", 2.0);
        groundChart.put("はがね", 2.0);
        typeChart.put("じめん", groundChart);

        // ひこうタイプ
        Map<String, Double> flyingChart = new HashMap<>();
        flyingChart.put("くさ", 2.0);
        flyingChart.put("でんき", 0.5);
        flyingChart.put("かくとう", 2.0);
        flyingChart.put("むし", 2.0);
        flyingChart.put("いわ", 0.5);
        typeChart.put("ひこう", flyingChart);

        // エスパータイプ
        Map<String, Double> psychicChart = new HashMap<>();
        psychicChart.put("かくとう", 2.0);
        psychicChart.put("どく", 2.0);
        psychicChart.put("エスパー", 0.5);
        psychicChart.put("あく", 0.5);
        psychicChart.put("はがね", 0.5);
        typeChart.put("エスパー", psychicChart);

        // むしタイプ
        Map<String, Double> bugChart = new HashMap<>();
        bugChart.put("ほのお", 0.5);
        bugChart.put("くさ", 2.0);
        bugChart.put("かくとう", 0.5);
        bugChart.put("どく", 0.5);
        bugChart.put("ひこう", 0.5);
        bugChart.put("エスパー", 2.0);
        bugChart.put("ゴースト", 0.5);
        bugChart.put("あく", 2.0);
        bugChart.put("はがね", 0.5);
        typeChart.put("むし", bugChart);

        // いわタイプ
        Map<String, Double> rockChart = new HashMap<>();
        rockChart.put("ほのお", 2.0);
        rockChart.put("こおり", 2.0);
        rockChart.put("かくとう", 0.5);
        rockChart.put("じめん", 0.5);
        rockChart.put("ひこう", 2.0);
        rockChart.put("むし", 2.0);
        typeChart.put("いわ", rockChart);

        // ゴーストタイプ
        Map<String, Double> ghostChart = new HashMap<>();
        ghostChart.put("ノーマル", 0.0);
        ghostChart.put("エスパー", 2.0);
        ghostChart.put("ゴースト", 2.0);
        ghostChart.put("あく", 0.5);
        typeChart.put("ゴースト", ghostChart);

        // ドラゴンタイプ
        Map<String, Double> dragonChart = new HashMap<>();
        dragonChart.put("ドラゴン", 2.0);
        dragonChart.put("はがね", 0.5);
        typeChart.put("ドラゴン", dragonChart);

        // あくタイプ
        Map<String, Double> darkChart = new HashMap<>();
        darkChart.put("かくとう", 0.5);
        darkChart.put("エスパー", 2.0);
        darkChart.put("ゴースト", 2.0);
        darkChart.put("あく", 0.5);
        darkChart.put("フェアリー", 0.5);
        typeChart.put("あく", darkChart);

        // はがねタイプ
        Map<String, Double> steelChart = new HashMap<>();
        steelChart.put("ほのお", 0.5);
        steelChart.put("みず", 0.5);
        steelChart.put("くさ", 1.0);
        steelChart.put("こおり", 2.0);
        steelChart.put("いわ", 2.0);
        steelChart.put("フェアリー", 2.0);
        typeChart.put("はがね", steelChart);
        
        // フェアリータイプ
        Map<String, Double> fairyChart = new HashMap<>();
        fairyChart.put("かくとう", 2.0);
        fairyChart.put("どく", 1.0);
        fairyChart.put("ドラゴン", 2.0);
        fairyChart.put("あく", 2.0);
        fairyChart.put("はがね", 0.5);
        typeChart.put("フェアリー", fairyChart);   
    }

    /**
     * 与えられた技のタイプがターゲットのポケモンに対してどの程度効果的かを返す。
     *
     * @param moveType   技のタイプ
     * @param targetType ターゲットのポケモンのタイプ
     * @return 効果倍率
     */
    public static double getEffectiveness(String moveType, String targetType) {
        return typeChart.getOrDefault(moveType, new HashMap<>()).getOrDefault(targetType, 1.0);
    }

}
