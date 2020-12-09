package MutantRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import SmartParkingTestSuite.tests.SmartParkingTestClass;
import SmartParkingTestSuite.tests.SmartParkingTestClass;

public class RemoteMutantRunner {
	
	
	private static final String resPath = "C:/Users/olly1/Dropbox/Tirocinio Dario/tools/estrazione_mutanti_node-red/smartparking_muts/results/";
	private static final String timesPath = "C:/Users/olly1/Dropbox/Tirocinio Dario/tools/estrazione_mutanti_node-red/smartparking_muts/times/times.csv";
	protected static String homeDir ="C:/Users/utente/Dropbox/Universita/Magistrale/Primo_anno/LSSE/lab/diamh/";
	public static NodeREDWrapper nr;
	
	
	public static String[] getTestNames(String fullClassName, int numTests) {
		String[] tests = new String[numTests];
		for(int i=0; i<numTests; i++) {
			tests[i] = "test_"+(i+1)+"("+fullClassName+")";
		}
		return tests;
	}
	
	public static String generateHeader(int numTests) {
		StringBuilder res = new StringBuilder();
		for(int i=1; i<=numTests; i++) {
			res.append("test"+i+",");
		}
		res.deleteCharAt(res.length()-1);
		res.append("\n");
		return res.toString();
	}
	
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
	
	public static void saveMutant(String mut, Integer[] res, String header, int index) throws IOException {
		FileWriter fw = new FileWriter(resPath+mut.replace("/", "_")+"_"+index+".csv");
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
	
	
	public static void saveTimes(String times) throws IOException {
		FileWriter fw = new FileWriter(timesPath);
		PrintWriter pw = new PrintWriter(fw);
		pw.print(times);
		pw.close();
		fw.close();
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		String host = "192.168.1.161";
		String times = "mutant,time\n";
		Class<?> testClass = SmartParkingTestClass.class;
		int numTests = 43;
		String[] testNames = getTestNames(testClass.getName(), numTests);
		String header = generateHeader(numTests);
		//List<Result> res = new ArrayList<>();
		HashMap<String, Integer[]> results = new HashMap<>();
		nr = new NodeREDWrapper(host);
		String[] muts = new String[] {"server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json" , "server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json", "server/3798f136.609bfe_10_BinaryExpression.js.json"};
		for(int i = 0; i<muts.length; i++) {

			nr.start(muts[i]);

			Thread.sleep(20000);
			JUnitCore junit = new JUnitCore();
			junit.addListener(new TextListener(System.out));
			long start = System.currentTimeMillis();
			Result result = junit.run(testClass);
			long end = System.currentTimeMillis();
			nr.stop();
			saveMutant(muts[i], getMutantResults(result, testNames), header, i);
			float duration = (end-start)/(float)1000;
			times += muts[i]+","+duration+"\n";
			saveTimes(times);
			Thread.sleep(10000);
		}

		
	}


	
}
