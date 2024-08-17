package com.example.pokemonapp.service;

import java.util.Random;
import java.util.Scanner;

import com.example.pokemonapp.model.Battle;
import com.example.pokemonapp.model.Move;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.Trainer;
import com.example.pokemonapp.util.TypeEffectiveness;

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

        Pokemon first, second;
        
        // 素早さで攻撃順を決定
        if (playerPokemon.getSpeed() > cpuPokemon.getSpeed()) {
            first = playerPokemon;
            second = cpuPokemon;
        } else {
            first = cpuPokemon;
            second = playerPokemon;
        }

        Scanner scanner = new Scanner(System.in);

        while (playerPokemon.getHp() > 0 && cpuPokemon.getHp() > 0) {
            // プレイヤーが技を選択
            if (first == playerPokemon) {
                selectMoveAndAttack(first, second, scanner);
                if (second.getHp() <= 0) break;
                performCpuAttack(second, first);
            } else {
                performCpuAttack(first, second);
                if (second.getHp() <= 0) break;
                selectMoveAndAttack(second, first, scanner);
            }

            displayCurrentStatus(playerPokemon, cpuPokemon);
        }

        announceWinner(playerPokemon, cpuPokemon);
        scanner.close();
    }

    /**
     * プレイヤーが技を選択して攻撃を実行する。
     *
     * @param attacker 攻撃するポケモン
     * @param defender 防御するポケモン
     * @param scanner ユーザー入力を受け取るスキャナ
     */
    private void selectMoveAndAttack(Pokemon attacker, Pokemon defender, Scanner scanner) {
        System.out.println(attacker.getName() + "はどうする？");

        // 技リストを表示
        for (int i = 0; i < attacker.getMoves().size(); i++) {
            System.out.println((i + 1) + ": " + attacker.getMoves().get(i).getName());
        }

        int moveIndex;
        while (true) {
            try {
                moveIndex = Integer.parseInt(scanner.nextLine()) - 1;
                if (moveIndex >= 0 && moveIndex < attacker.getMoves().size()) {
                    break;
                } else {
                    System.out.println("正しい番号を選んでください。");
                }
            } catch (NumberFormatException e) {
                System.out.println("正しい番号を選んでください。");
            }
        }

        Move selectedMove = attacker.getMoves().get(moveIndex);
        performAttack(attacker, defender, selectedMove);
    }

    /**
     * CPUがランダムに技を選んで攻撃を実行する。
     *
     * @param attacker 攻撃するポケモン
     * @param defender 防御するポケモン
     */
    private void performCpuAttack(Pokemon attacker, Pokemon defender) {
        Move selectedMove = attacker.getMoves().get(random.nextInt(attacker.getMoves().size()));
        performAttack(attacker, defender, selectedMove);
    }

    /**
     * 攻撃を実行する。
     *
     * @param attacker 攻撃するポケモン
     * @param defender 防御するポケモン
     * @param move 使用する技
     * @return 攻撃によって相手のHPが0以下になった場合はtrue、そうでない場合はfalse
     */
    private boolean performAttack(Pokemon attacker, Pokemon defender, Move move) {
        System.out.println(attacker.getName() + "の" + move.getName() + "！");
        
        // 攻撃の成功率に基づいて命中判定
        if (random.nextDouble() * 100 < move.getAccuracy()) {
            int damage = calculateDamage(attacker, defender, move);
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
     * @param move 使用する技
     * @return 計算されたダメージ
     */
    private int calculateDamage(Pokemon attacker, Pokemon defender, Move move) {
        final double LEVEL = 50; // レベルを固定値に設定

        // 基本ダメージ計算式
        double damage = (((2 * LEVEL / 5 + 2) * move.getPower() * attacker.getAttack() / defender.getDefense()) / 50 + 2);

        // タイプ相性による効果倍率を計算
        double typeEffectiveness = TypeEffectiveness.getEffectiveness(move.getType(), defender.getType());

        // ランダム要素
        double randomFactor = 0.85 + random.nextDouble() * 0.15;

        // 効果倍率に基づいてメッセージを表示
        if (typeEffectiveness == 0.0) {
            System.out.println("効果がないようだ...");
            return 0; // ダメージを0に設定
        } else if (typeEffectiveness > 1.0) {
            System.out.println("こうかはばつぐんだ！");
        } else if (typeEffectiveness < 1.0) {
            System.out.println("こうかは今ひとつのようだ...");
        }

        // 最終ダメージ
        int finalDamage = (int) Math.max(1, damage * typeEffectiveness * randomFactor); // 最小ダメージは1
        
        return finalDamage;
    }

    /**
     * 現在のバトル状況を表示する。
     *
     * @param playerPokemon プレイヤーのポケモン
     * @param cpuPokemon CPUのポケモン
     */
    private void displayCurrentStatus(Pokemon playerPokemon, Pokemon cpuPokemon) {
        System.out.println("----現在の状況----");
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
