package Day51;

import java.io.*;
public class ExceptionHierarchy {
    public static void main(String[] args) {
        ///  Object
        ///    └── Throwable
        ///          ├── Error
        ///                └── Exception
        ///                      ├── Checked Exceptions
        ///                             └── RuntimeException (Unchecked)

        ///  Error vs Exception
        ///  Error == Serious Problems, Cannot be handled normally
        ///  Exception == Can be handled using try-catch


        ///  Checked vs Unchecked
        ///  Checked Exceptions == Must be handled OR declared using throw
        ///  Examples:
        ///  IOException
        ///  SQLException
        ///  FileNotFoundException

        try {
            FileReader file = new FileReader("test.txt");
        } catch(IOException e) {
            System.out.println("File error!");
        }

        ///  Unchecked Exceptions == Do not require handling
        ///  Examples:
        ///  IOException
        ///  SQLException
        ///  FileNotFoundException


        ///  Multiple Catch Blocks
        try {
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index error!");
        } catch (Exception e) {
            System.out.println("General Error!");
        }

        ///  finally Block
        try {
            int x = 10/2;
        } catch (Exception e) {
            System.out.println("Error!");
        } finally {
            System.out.println("Always run!");
        }

        ///  throw vs throws

        ///  throw (manually throw)
        ///  throw new ArithmeticException("Invalid operation");

        ///  throws (declare exception)
        ///  public static void test() throws IOException {
        ///      FileReader f = new FileReader("file.txt");
        ///  }
    }
}
