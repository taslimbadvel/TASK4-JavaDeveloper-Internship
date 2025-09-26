
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesApp {
    private static final String file = "notes.txt";

    public static void addNote(String notes) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(notes + "\n");
            System.out.println("note saved successfully");

        } catch (IOException e) {
            System.out.println("error writing notes" + e.getMessage());

        }

    }

    public static void viewNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n___YourNotes____");
            while ((line = br.readLine()) != null) {
                System.out.println("_" + line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("no notes found");

        } catch (IOException e) {
            System.out.println("error reading notes:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n___ Notes App____");
            System.out.println("1. Add Notes");
            System.out.println("2. View Notes");
            System.out.println("3.Exit");
            System.out.println("choose option:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("enter your notes");
                    String notes = sc.nextLine();
                    addNote(notes);
                }
                case 2 -> viewNotes();
                case 3 -> {
                    running = false;
                    System.out.println("Existing app");

                }
                default -> System.err.println("invalid option");
            }

        }
        sc.close();

    }
}
