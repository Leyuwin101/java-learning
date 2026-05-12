package Day83;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NIO {
    public static void main(String[] args) {
        /// 1. Buffer
        /// Temporary storage
        /// 2. Channel
        /// Connection to file / network
        /// 3. Selector
        /// Manages multiple channels (advanced servers)

        /// 1. Buffer
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte) 65);
        buffer.put((byte) 65);

        buffer.flip(); // switch to reading mode
        /// Write Mode → flip() → Read Mode

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

        /// 2. FileChannel
        /// Copy file using NIO
        try {
            FileInputStream fis = new FileInputStream("names.txt");
            FileOutputStream fos = new FileOutputStream("output.txt");

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            outChannel.transferFrom(inChannel, 0, inChannel.size());

            inChannel.close();
            outChannel.close();

            fis.close();
            fos.close();

            System.out.println("File copied using NIO");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /// 3. Reading file using NIO

        try {
            List<String> lines = Files.readAllLines(
                    Paths.get("names.txt")
            );

            for (String line: lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        /// 4. Writing file using NIO

        try {
            Files.write(
                    Paths.get("output.txt"),
                    Arrays.asList("Hello", "NIO File", "System")
            );

            System.out.println("File written");
        } catch (Exception e) {
            e.printStackTrace();
        }


        /// Class	        Purpose
        /// ByteBuffer	    stores data
        /// FileChannel	    file operations
        /// Path	        file location
        /// Files	        utility operations
    }

}
