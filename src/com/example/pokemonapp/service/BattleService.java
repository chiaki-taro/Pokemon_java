package com.example.pokemonapp.service;

import java.util.Random;

import com.example.pokemonapp.model.Battle;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.Trainer;

/**
 * ポケモンバトルのシミュレーションを行うサービスクラス。
 */
public class BattleService {
    private Random random = new Random();

    /**
     * バトルをシミュレートする。
     * プレイヤーとCPUのポケモンが交互に攻撃を行い、一方のHPが0になるまで続ける。
     *
     * @param battle シミュレートするバトル
     */
    public void simulateBattle(Battle battle) {
        Trainer cpuTrainer = battle.getCpuTrainer();
        Pokemon playerPokemon = battle.getPlayerPokemon();
        Pokemon cpuPokemon = battle.getCpuPokemon();
        
        System.out.println(cpuTrainer.getName() + "が勝負をしかけてきた！");
        System.out.println(cpuTrainer.getName() + "は" + cpuPokemon.getName() + "をくり出した！");

        System.out.println("いけっ！" + playerPokemon.getName() + "！");

        while (playerPokemon.getHp() > 0 && cpuPokemon.getHp() > 0) {
            // プレイヤーのターン
            if (performAttack(playerPokemon, cpuPokemon)) {
                break;
            }

            // CPUのターン
            if (performAttack(cpuPokemon, playerPokemon)) {
                break;
            }

            // 現在のHP状況を表示
            displayCurrentStatus(playerPokemon, cpuPokemon);
        }

        // 勝者
        announceWinner(playerPokemon, cpuPokemon);
    }

    /**
     * 攻撃を実行する。
     *
     * @param attacker 攻撃するポケモン
     * @param defender 防御するポケモン
     * @return 攻撃によって相手のHPが0以下になった場合はtrue、そうでない場合はfalse
     */
    private boolean performAttack(Pokemon attacker, Pokemon defender) {
        System.out.println(attacker.getName() + "の攻撃！");
        
        // 攻撃の成功率を80%に設定
        if (random.nextDouble() < 0.8) {
            int damage = calculateDamage(attacker, defender);
            defender.setHp(Math.max(0, defender.getHp() - damage));
            System.out.println(defender.getName() + "に" + damage + "のダメージ！");
            
            if (defender.getHp() <= 0) {
                System.out.println(defender.getName() + "は倒れた！");
                return true;
            }
        } else {
            System.out.println("しかし、攻撃は外れた！");
        }
        return false;
    }

    /**
     * ダメージを計算する。
     *
     * @param attacker 攻撃するポケモン
     * @param defender 防御するポケモン
     * @return 計算されたダメージ
     */
    private int calculateDamage(Pokemon attacker, Pokemon defender) {
        // 基本ダメージ計算式: (攻撃力 - 防御力 / 2) + ランダム要素
        int baseDamage = attacker.getAttack() - defender.getDefense() / 2;
        int randomFactor = random.nextInt(10) + 1; // 1から10のランダムな値
        return Math.max(1, baseDamage + randomFactor); // 最小ダメージは1
    }

    /**
     * 現在のバトル状況を表示する。
     *
     * @param playerPokemon プレイヤーのポケモン
     * @param cpuPokemon CPUのポケモン
     */
    private void displayCurrentStatus(Pokemon playerPokemon, Pokemon cpuPokemon) {
        System.out.println("---現在の状況---");
        System.out.println(playerPokemon.getName() + " HP: " + playerPokemon.getHp());
        System.out.println(cpuPokemon.getName() + " HP: " + cpuPokemon.getHp());
        System.out.println("----------------");
    }

    /**
     * バトルの勝者を発表する。
     *
     * @param playerPokemon プレイヤーのポケモン
     * @param cpuPokemon CPUのポケモン
     */
    private void announceWinner(Pokemon playerPokemon, Pokemon cpuPokemon) {
        if (playerPokemon.getHp() > 0) {
            System.out.println("プレイヤーの勝利！");
        } else {
            System.out.println("CPUの勝利！");
        }
    }
}