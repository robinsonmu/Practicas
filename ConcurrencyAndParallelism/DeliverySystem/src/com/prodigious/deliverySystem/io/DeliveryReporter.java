package com.prodigious.deliverySystem.io;

import java.io.*;
import java.time.LocalDate;

public class DeliveryReporter {

    private static final String FILE_NAME = "./out.txt";
    private static final String REPORT = "Plan Finished on $1 at location ($2,$3)";
    private static final String WILDCARD="$";

    public static void reportDeliveryPlanExecution(int x, int y) {
        try {
            File reportFile=new File(FILE_NAME);
            reportFile.createNewFile();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reportFile, true)));
            writer.append(REPORT.replace(WILDCARD+String.valueOf(1), LocalDate.now().toString()).
                    replace(WILDCARD+String.valueOf(2), String.valueOf(x)).
                    replace(WILDCARD+String.valueOf(3), String.valueOf(y)));
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
