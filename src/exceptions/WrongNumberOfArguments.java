package src.exceptions;

public class WrongNumberOfArguments extends RuntimeException 
{
    public WrongNumberOfArguments() {System.err.println("Wrong number of arguments!");}
}
