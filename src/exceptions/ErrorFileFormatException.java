package src.exceptions;

public class ErrorFileFormatException extends RuntimeException 
{
    public ErrorFileFormatException() {System.err.println("Wrong Format of File!");}
}
