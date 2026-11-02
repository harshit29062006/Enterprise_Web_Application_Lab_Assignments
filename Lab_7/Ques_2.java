import java.io.*;

public class Ques_2{

    public static void analyzeLogFile(String inputPath, String outputPath){
        int totalLines = 0;
        int errorCount = 0;
        int warningCount = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))){

            String line;
            while((line = reader.readLine()) != null){
                totalLines++;

                if(line.contains("ERROR") || line.contains("WARNING")){
                    if(line.contains("ERROR")) errorCount++;
                    if(line.contains("WARNING")) warningCount++;

                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("=== Log Analysis Report ===");
            System.out.println("Total log lines: " + totalLines);
            System.out.println("Errors found: " + errorCount);
            System.out.println("Warnings found: " + warningCount);
            System.out.println("Filtered entries saved to: " + outputPath);

        } catch(FileNotFoundException e){
            System.err.println("Log file not found: " + e.getMessage());
        } catch(IOException e){
            System.err.println("I/O Error during processing: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        String logFile = "app.log";
        String filteredFile = "filtered_logs.txt";

        try(BufferedWriter sampleWriter = new BufferedWriter(new FileWriter(logFile))){
            sampleWriter.write("INFO: Application started\n");
            sampleWriter.write("WARNING: High memory usage detected\n");
            sampleWriter.write("INFO: User login successful\n");
            sampleWriter.write("ERROR: Database connection timed out\n");
            sampleWriter.write("INFO: Background sync completed\n");
        } catch(IOException e){
            System.err.println("Failed to create sample log: " + e.getMessage());
        }

        analyzeLogFile(logFile, filteredFile);
    }
}