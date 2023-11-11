package TestDungeonsOfLatserolf;

import java.util.Scanner;

import DungeonsOfLatserolf.entity.UserEntity;
import DungeonsOfLatserolf.system.DatabaseManagerSystem;

public class TestDatabaseManagerSystem {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DatabaseManagerSystem databaseManagerSystem = new DatabaseManagerSystem();
        UserEntity currentUser = new UserEntity("null", "null");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                System.out.print("Escolha uma opção: ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    switch (choice) {
                        case 1:
                            insertNewUser(currentUser, databaseManagerSystem);
                            break;
                        case 2:
                            userLogin(currentUser, databaseManagerSystem);
                            break;
                        case 3:
                            databaseManagerSystem.selectAllUsers();
                            break;
                        case 4:
                            updateUserScore(currentUser, databaseManagerSystem);
                            break;
                        case 5:
                            databaseManagerSystem.deleteAllUsers();
                            break;
                        case 0:
                            exitSystem(databaseManagerSystem);
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("\nMENU:");
        System.out.println("1. Inserir novo usuário");
        System.out.println("2. Fazer login");
        System.out.println("3. Visualizar todos os usuários");
        System.out.println("4. Atualizar pontuação do usuário");
        System.out.println("5. Excluir todos os usuários");
        System.out.println("0. Sair");
    }

    private static void insertNewUser(UserEntity currentUser, DatabaseManagerSystem databaseManagerSystem) {
        System.out.println("Digite o email do usuário: ");
        currentUser.setUserEmail(scanner.next());
        System.out.println("Digite o nome do usuário: ");
        currentUser.setUserName(scanner.next());
        databaseManagerSystem.insertNewUser(currentUser);
        currentUser.reset();
    }

    private static void userLogin(UserEntity currentUser, DatabaseManagerSystem databaseManagerSystem) {
        System.out.println("Digite o email do usuário: ");
        String userEmail = scanner.next();
        currentUser = databaseManagerSystem.userLogin(userEmail);
        System.out.println(currentUser.getUserEmail() + " " + currentUser.getUserName() + " "
                + currentUser.getUserScore());
        currentUser.reset();
    }

    private static void updateUserScore(UserEntity currentUser, DatabaseManagerSystem databaseManagerSystem) {
        System.out.println("Digite o email do usuário: ");
        String userEmail = scanner.next();
        currentUser = databaseManagerSystem.userLogin(userEmail);
        System.out.println("Digite a nova pontuação do usuário: ");
        int newUserScore = scanner.nextInt();
        databaseManagerSystem.updateUserScore(currentUser, newUserScore);
        currentUser.reset();
    }

    private static void exitSystem(DatabaseManagerSystem databaseManagerSystem) {
        databaseManagerSystem.closeConnection();
        System.out.println("Sistema encerrado!");
        System.exit(0);
    }
}
