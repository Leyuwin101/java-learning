package Day56;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class number {
    public static void main(String[] args) {
        /// This is about displaying numbers neatly:
        ///
        /// Decimal places
        /// Currency
        /// Percentages

        /// DecimalFormat Class
        double num = 12345.6789;

        DecimalFormat df = new DecimalFormat("#.##"); // 2 decimal places
        System.out.println(df.format(num)); // 12345.68

        DecimalFormat df2 = new DecimalFormat("#,###.00");
        System.out.println(df2.format(num)); // 12,345.68

        /// NumberFormat for Currency
        double price = 1234.56;

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(price)); // ₱1,234.56 (default local)

        NumberFormat nfJA = NumberFormat.getCurrencyInstance(new Locale("ja", "JP"));
        System.out.println(nfJA.format(price)); // ￥1,235

        /// Formatting Percentages
        double ratio = 0.75;

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        System.out.println(percentFormat.format(ratio)); // 75%

    }
}
