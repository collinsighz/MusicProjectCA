package CLI;


import repository.MusicLibraryRepository;
import repository.UserRepository;
import repository.RatingRepository;

import java.util.Scanner;

public class MusicLibraryCLI {

    private final UserRepository userRepository;
    private final MusicLibraryRepository musicLibraryRepository;
    private final RatingRepository ratingRepository;

    private final Scanner scanner;

    public MusicLibraryCLI(
            UserRepository userRepository,
            MusicLibraryRepository musicLibraryRepository,
            RatingRepository ratingRepository) {

        this.userRepository = userRepository;
        this.musicLibraryRepository = musicLibraryRepository;
        this.ratingRepository = ratingRepository;

        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== MUSIC LIBRARY =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void register() {
        // Registration logic using UserRepository
    }

    private void login() {
        // Login logic using UserRepository
    }
}