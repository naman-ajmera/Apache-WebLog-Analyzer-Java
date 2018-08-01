
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()){
            records.add(WebLogParser.parseEntry(line));
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
     ArrayList<String> uniqueIPs = new ArrayList<String>();
       for(LogEntry le : records){
       String ipAddr = le.getIpAddress();
          if(!uniqueIPs.contains(ipAddr)){
          uniqueIPs.add(ipAddr);
          }
        }
     return uniqueIPs.size(); 
    }

    public void printAllHigherThanNum(int num){
        for(LogEntry le : records){
            if(le.getStatusCode() > num){
            System.out.println(le);
        }
        }
    }
    
   public void uniqueIPVisitsOnDay(String someday){
       ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
       for(LogEntry le : records){
       Date d = le.getAccessTime();
       String str = d.toString();
       str = str.substring(4,10);
         if(someday.equals(str)){
           if(!uniqueIPsOnDay.contains(le.getIpAddress()))
           uniqueIPsOnDay.add(le.getIpAddress());}
            }
       System.out.println(uniqueIPsOnDay);
       System.out.println(uniqueIPsOnDay.size());
       }
   
   public int countUniqueIPsInRange(int low, int high){
     ArrayList<String> uniqueIPsInRange = new ArrayList<String>();
       for(LogEntry le : records){
         if(le.getStatusCode() >= low && le.getStatusCode() <= high){    
            if(!uniqueIPsInRange.contains(le.getIpAddress())){
            uniqueIPsInRange.add(le.getIpAddress());
            }
         } 
      }
     return uniqueIPsInRange.size();
    }
   
   public HashMap<String,Integer> countVisitsPerIP(){
   HashMap<String,Integer> counts = new HashMap<String,Integer>();
     for(LogEntry le : records){
       String ip = le.getIpAddress();
         if(!counts.containsKey(ip)){
            counts.put(ip,1);
            }
         else{
            counts.put(ip,counts.get(ip)+1);
            }   
     }
     return counts;
    } 
    
   public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
      int max = 0;
       for(Integer v : counts.values()){
          if(v > max){
          max = v;
          }
       }
       return max;
    } 
    
   public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts ){
    ArrayList<String> MostVisitIp = new ArrayList<String>();
    int max = mostNumberVisitsByIP(counts);
      for(String s : counts.keySet()){
         if(counts.get(s) ==  max){
         MostVisitIp.add(s);
            }
       }
    return MostVisitIp;   
    } 
   
   public HashMap<String,ArrayList<String>> iPsForDays(){
     HashMap<String,ArrayList<String>> ipDays = new HashMap<String,ArrayList<String>>();
       for(LogEntry le : records){
       ArrayList<String> myList = new ArrayList<String>();
       String ip = le.getIpAddress();
       String date = le.getAccessTime().toString().substring(4,10);
           if(!ipDays.containsKey(date)){
               myList.add(ip);
               ipDays.put(date,myList);
           }
           else{
               myList = ipDays.get(date);
               myList.add(ip);
               ipDays.put(date,myList);
            }
     }
     return ipDays;
    } 
   
   public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> ipDays){
       int max = 0;
       String ans = "";
       for(ArrayList<String> myList : ipDays.values()){
          if(myList.size() > max){
            max = myList.size();
            }  
        }
       for(String k : ipDays.keySet()){
         if((ipDays.get(k)).size() == max ){
             ans = k;
            }
        } 
        return ans;
    } 
    
   public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> ipDays, String someday){
     ArrayList<String> myList = new ArrayList<String>();
      for(String k : ipDays.keySet()){
          if(k.equals(someday)){
             myList = ipDays.get(k);
             
            }
         }
      return myList;     
    }
}
    

