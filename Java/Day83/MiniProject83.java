package Day83;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MiniProject83 {

    /// OLD IO COPY
    public static void copyUsingOldIO(File source, File dest) throws Exception {

        long start = System.nanoTime();

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis.close();
        fos.close();

        long end = System.nanoTime();

        System.out.println("[OLD IO]");
        System.out.println("Copied: " + source.getName());
        System.out.println("Size: " + source.length() + " bytes");
        System.out.println("Execution Time: " + ((end - start) / 1_000_000.0) + " ms");
        System.out.println();
    }

    /// NIO COPY
    public static void copyUsingNIO(File source, File dest) throws Exception {

        Long start = System.nanoTime();

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);

        FileChannel sourceChannel = fis.getChannel();
        FileChannel destChannel = fos.getChannel();

        long sizeBefore = sourceChannel.size();

        System.out.println("[NIO]");
        System.out.println("File: " + source.getName());
        System.out.println("File size before: " + sizeBefore + " bytes");

        long transferred = destChannel.transferFrom(sourceChannel, 0, sizeBefore);

        System.out.println("File size after: " + transferred + " bytes");

        sourceChannel.close();
        destChannel.close();
        fis.close();
        fos.close();

        long end = System.nanoTime();

        System.out.println("Execution time: " + ((end - start) / 1_000_000.0) + " ms");
        System.out.println();
    }

    public static void main(String[] args) {

        try {

            /// Source Folder
            File folder = new File("FILES");

            /// Destination Folder
            File nioFolder = new File("nioCopies");
            File ioFolder = new File("ioCopies");

            nioFolder.mkdir();
            ioFolder.mkdir();

            /// Get all files
            File[] files = folder.listFiles();

            if (files == null || files.length == 0) {
                System.out.println("No files found");
                return;
            }

            System.out.println("FILES FOUND: ");
            Arrays.stream(files)
                    .forEach(file -> System.out.println("- " + file.getName()));

            System.out.println("\n============================\n");

            /// Copy multiple files
            for (File file : files) {

                if (file.isFile()) {

                    /// NIO COPY
                    File nioDest = new File(nioFolder, "nio_" + file.getName());
                    copyUsingNIO(file, nioDest);

                    /// OLD IO COPY
                    File ioDest = new File(ioFolder, "io_" + file.getName());
                    copyUsingOldIO(file, ioDest);

                    System.out.println("----------------------------");
                }
            }

            long originalSize = Files.walk(Paths.get("FILES"))
                    .filter(Files::isRegularFile)
                    .mapToLong(path -> path.toFile().length())
                    .sum();

            long nioSize = Files.walk(Paths.get("nioCopies"))
                    .filter(Files::isRegularFile)
                    .mapToLong(path -> path.toFile().length())
                    .sum();

            long ioSize = Files.walk(Paths.get("ioCopies"))
                    .filter(Files::isRegularFile)
                    .mapToLong(path -> path.toFile().length())
                    .sum();


            System.out.println("\nFINAL SUMMARY");
            System.out.println("Original Total Size: " + originalSize + " bytes");
            System.out.println("NIO Copies Size: " + nioSize + " bytes");
            System.out.println("Old IO Copies Size: " + ioSize + " bytes");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
