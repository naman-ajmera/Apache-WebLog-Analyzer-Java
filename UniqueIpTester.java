import java.util.*;
/**
 * Write a description of UniqueIpTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UniqueIpTester {
public void test(){
    LogAnalyzer la = new LogAnalyzer();
    la.readFile("weblog1_log");
   // int uniqueIps = la.countUniqueIPs();
    //System.out.println("there Are " + uniqueIps + " IPS");
   //la.printAllHigherThanNum(400);
  //la.uniqueIPVisitsOnDay("Mar 24");
  // la.countUniqueIPsInRange(300,299);
HashMap<String,Integer> counts = la.countVisitsPerIP();
 //System.out.println(counts);
 HashMap<String, ArrayList<String>> map = la.iPsForDays();
 System.out.println(map);
// ArrayList<String> count = la.iPsMostVisits(counts);
 //System.out.println(count);
}
}