package src.exceptions;

public class EmptyFileException extends RuntimeException 
{
    public EmptyFileException() {System.err.println("Empty file!");}
}
