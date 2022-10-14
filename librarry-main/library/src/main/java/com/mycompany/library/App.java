/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;
import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 *
 * @author NikitaSkr
 */
public class App {
    private Book[] books;
    private Reader[] readers;
    private History[] histories;

    public App() {
        books=new Book[0];
        readers=new Reader[0];
        histories=new History[0];
    }
   
   public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        Reader reader = null;
        History history = null;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить книгу");
                    System.out.println("add book name ");
                    String bookName= scanner.nextLine();
                    System.out.println("add book year ");
                    String publishedYear= scanner.nextLine();
                    System.out.println("add book quantity ");
                    String quantity= scanner.nextLine();
                    
                    Book book = createBook(bookName, new Integer(publishedYear),new Integer(quantity));
                    System.out.println("add authors quantity ");
                    int authursInBooks=scanner.nextInt();
                    for (int i = 0; i < authursInBooks; i++) {
                        System.out.println("add author name "+(i+1)+": ");
                        String firstname =scanner.nextLine();
                        System.out.println("add author lastname "+(i+1)+": ");
                        String lastname =scanner.nextLine();
                        System.out.println("add author birthday "+(i+1)+": ");
                        String birthday =scanner.nextLine();
                        book.addAuthor(createAuthor(firstname, lastname, new Integer(birthday)));
                        
                    }
                    Book[] newBooks= new Book[this.books.length+1];
                    newBooks[newBooks.length-1] =book;
                    this.books= newBooks;
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
       
                    System.out.println("add  name ");
                    String frstname= scanner.nextLine();
                    System.out.println("add lastname ");
                    String lastname= scanner.nextLine();
                    System.out.println("add phone ");
                    String phone= scanner.nextLine();
                    Reader readers = createReader(frstname, lastname,new Integer(phone));
                    Reader[] newReaders= new Reader[this.readers.length+1];
                    newReaders[newReaders.length-1] =readers;
                    this.readers= newReaders;
                    
                    break;
                case 3:
                    System.out.println("3. Выдать книгу");
                    for (int i = 0; i < this.readers.length; i++) {
                        System.out.printf(i+1+". "+this.readers[i].getFirstname()+this.readers[i].getLastname());
                    }
                    System.out.println("выберете читателя: ");
                    int numberReader= scanner.nextInt(); scanner.nextLine();
                    System.out.println("список книг: ");
                    for (int i = 0; books.length < 10; i++) {
                        
                    }
                    break;
                case 4: 
                    System.out.println("4. Вернуть книгу");
                    history.setReturnBook(new GregorianCalendar().getTime());
                    System.out.println(history);
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");;
            }
            
        }while(repeat);
        System.out.println("Закрытие программы, досвидания!");
    }
    public Book createBook(String bookName,int quantity, int publishedYear){
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;
    }
    public Author createAuthor(String firstname, String lastname, int birthday){
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    } 
    public Reader createReader(String firstname,String larstname, int phone){
        Reader reader = new Reader();
        reader.setFirstname(firstname);
        reader.setLastname(larstname);
        reader.setPhone(larstname);
        return reader;
    }
}
