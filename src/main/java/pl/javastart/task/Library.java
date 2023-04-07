package pl.javastart.task;

import java.util.Scanner;

class Library {
    private static final int MAX_BOOKS_NUMBER = 3;
    private final Scanner input = new Scanner(System.in);
    private final Book[] books = new Book[MAX_BOOKS_NUMBER];
    private int bookNumber = 0;

    public void readBooks() {
        System.out.println("Podaj informację o trzech unikalnych książkach:");

        while (bookNumber != books.length) {
            System.out.println("Podaj tytuł:");
            String title = input.nextLine();
            System.out.println("Podaj liczbę stron:");
            int pages = getInt();

            Book book = new Book(title, pages);
            if (!alreadyExists(book)) {
                books[bookNumber] = book;
                bookNumber++;
            } else {
                System.out.println("Duplikat");
            }
        }
    }

    public void viewBooks() {
        System.out.println("Książki zapisane w tablicy:");
        for (int i = 0; i < bookNumber; i++) {
            System.out.println(books[i].toString());
        }
    }

    private boolean alreadyExists(Book book) {
        for (int i = 0; i < bookNumber; i++) {
            if (books[i].equals(book)) {
                return true;
            }
        }
        return false;
    }

    private int getInt() {
        int integer = input.nextInt();
        input.nextLine();

        return integer;
    }
}
