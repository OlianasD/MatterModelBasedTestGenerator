package MutantRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ResultsManager {

	public static Integer[] getMutantResults(Result result, String[] testNames) {
	    System.out.println("Finished. Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms.");
	    
	    Integer[] res = new Integer[result.getRunCount()];
	    for(int i = 0; i<result.getRunCount(); i++) {
	    	res[i] = 1;
	    }
	    System.out.println("Failures: ");
	    for(Failure failure : result.getFailures()) {
	    	for(int i = 0; i<testNames.length; i++) {
	    		if(failure.getTestHeader().equals(testNames[i])) {
	    			res[i] = 0;
	    		}
	    	}
	    }
	   return res;
	}

	public static void saveMutant(String mut, Integer[] res, String header, String path, int index) throws IOException {
		FileWriter fw = new FileWriter(path+mut.replace("/", "_")+".csv");
		PrintWriter pw = new PrintWriter(fw);
		pw.print(header);
		String currLine = "";
		for(int i =0; i<res.length; i++) {
			currLine += res[i].toString()+",";
		}
		currLine = currLine.substring(0, currLine.length()-1);
		currLine += "\n";
		pw.print(currLine);
		pw.close();
		fw.close();
	}

	public static void saveTimes(String times, String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		PrintWriter pw = new PrintWriter(fw);
		pw.print(times);
		pw.close();
		fw.close();
	}

}
