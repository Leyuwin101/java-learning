package Day80;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class DownloadTask implements Runnable {
    private String fileURL;
    private String saveAs;

    public DownloadTask(String fileURL, String saveAs) {
        this.fileURL = fileURL;
        this.saveAs = saveAs;
    }

    @Override
    public void run() {
        System.out.println("Starting download: " + saveAs);

        try {
            URL url = new URL(fileURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Failed: " + saveAs + "(HTTP " + responseCode + ")");
                return;
            }

            int fileSize = conn.getContentLength();

            InputStream in = new BufferedInputStream(conn.getInputStream());
            FileOutputStream out = new FileOutputStream(saveAs);


            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while((bytesRead = in.read(dataBuffer)) != -1) {
                out.write(dataBuffer, 0, bytesRead);
                totalBytes += bytesRead;

                if (fileSize > 0) {
                    int percent = (totalBytes * 100) / fileSize;
                    System.out.println(saveAs + " -> " + percent + "%");
                }

            }

            out.close();
            in.close();

            System.out.println("Finished download: " + saveAs);
        } catch (Exception e) {
            System.out.println("Error downloading " + saveAs + ": " + e.getMessage());
        }
    }
}
public class multithread {
    public static void main(String[] args) {

        Thread d1 = new Thread(new DownloadTask("https://speed.cloudflare.com/__down?bytes=10000000", "file1.bin"));
        Thread d2 = new Thread(new DownloadTask("https://samplelib.com/lib/preview/mp4/sample-5s.mp4",  "video.mp4"));
        Thread d3 = new Thread(new DownloadTask("https://picsum.photos/300", "image.jpg"));

        d1.start();
        d2.start();
        d3.start();
    }
}
