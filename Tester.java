
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqueIP(){
    LogAnalyzer la = new LogAnalyzer();
    la.readFile("weblog2_log");
    //System.out.println(la.countUniqueIPs());
    //la.printAllHigherThanNum(400);
    //la.uniqueIPVisitsOnDay("Sep 27");
    //System.out.println(la.countUniqueIPsInRange(200,299));
    //HashMap<String,Integer> counts = la.countVisitsPerIP(); 
    HashMap<String,ArrayList<String>> ipDays = la.iPsForDays();
    //System.out.println(la.mostNumberVisitsByIP(counts));
    System.out.println(la.dayWithMostIPVisits(ipDays));
    System.out.println(la.iPsWithMostVisitsOnDay(ipDays,"Sep 30"));
   }
    
}
