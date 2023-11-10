package TestDungeonsOfLatserolf;

import java.util.Scanner;

import DungeonsOfLatserolf.DatabaseManagerSystem;
import DungeonsOfLatserolf.PlayerEntity;

public class TestDatabaseManagerSystem {
    public static void main(String[] args) {
        // Cria um novo usuário
        Scanner sc = new Scanner(System.in);
        System.out.println("CADASTRANDO");
        System.out.println("E-mail : ");
        String playerEmail = sc.nextLine();
        System.out.println("Nome : ");
        String playerName = sc.nextLine();
        System.out.println("Score : ");
        int playerScore = sc.nextInt();
        PlayerEntity playerEntity = new PlayerEntity(playerEmail, playerName, playerScore);
        new DatabaseManagerSystem().newUser(playerEntity);
        // Consulta todos os usuários cadastrados
        System.out.println("LOGIN");
        System.out.println("E-mail : ");
        sc.nextLine();
        playerEmail = sc.nextLine();
        sc.close();
        System.out.println(new DatabaseManagerSystem().userLogin(playerEmail));
    }
}