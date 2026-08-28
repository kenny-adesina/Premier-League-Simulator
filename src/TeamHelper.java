// import java.io.*;
import java.util.*;

public class TeamHelper{


// Instance Variables
private String team1;
private String team2;
private int score1;
private int score2;

// List of all present Premier League Teams
    private ArrayList<String> teams = new ArrayList<>(Arrays.asList(
"Tottenham Hotspur",
     "Arsenal",
     "Ipswich Town",
     "Coventry City",
     "Hull City",
     "Chelsea",
     "Manchester City",
     "Manchester United",
     "Liverpool",
     "Brighton",
     "Everton",
     "Newcastle United",
     "Sunderland",
     "Brentford",
     "Aston Villa",
     "Crystal Palace",
     "Fulham",
     "AFC Bournemouth",
     "Leeds United",
     "Nottingham Forest"
));

// Each team's attack strength (out of 100)
 private ArrayList<Double> atk = new ArrayList<>(Arrays.asList(
    80.0, // Tottenham
     87.0, // Arsenal
     77.0, // Ipswich
     76.0, // Coventry
     75.0, // Hull
     83.0, // Chelsea
     90.0, // Man City
     84.0, // Man Utd
     86.0, // Liverpool
     79.0, // Brighton
     78.0, // Everton
     80.0, // Newcastle
     79.0, // Sunderland
     81.0, // Brentford
     78.0, // Aston Villa
     79.0, // Crystal Palace
     78.0, // Fulham
     81.0, // Bournemouth
     78.0, // Leeds
     78.0 // Forest
 ));

 // Each team's midfield strength (out of 100)
 private ArrayList<Double> mid = new ArrayList<>(Arrays.asList(
  82.0, // Tottenham
     89.0, // Arsenal
     75.0, // Ipswich
     78.0, // Coventry
     77.0, // Hull
     84.0, // Chelsea
     91.0, // Man City
     86.0, // Man Utd
     84.0, // Liverpool
     77.0, // Brighton
     79.0, // Everton
     81.0, // Newcastle
     78.0, // Sunderland
     77.0, // Brentford
     79.0, // Aston Villa
     77.0, // Crystal Palace
     75.0, // Fulham
     80.0, // Bournemouth
     77.0, // Leeds
     76.0 // Forest
 ));

// Each team's defensive strength (out of 100)
 private ArrayList<Double> def = new ArrayList<>(Arrays.asList(
    76.0, // Tottenham
     93.0, // Arsenal
     75.0, // Ipswich
     74.0, // Coventry
     77.0, // Hull
     78.0, // Chelsea
     88.0, // Man City
     83.0, // Man Utd
     86.0, // Liverpool
     78.0, // Brighton
     79.0, // Everton
     82.0, // Newcastle
     83.0, // Sunderland
     82.0, // Brentford
     77.0, // Aston Villa
     79.0, // Crystal Palace
     79.0, // Fulham
     84.0, // Bournemouth
     77.0, // Leeds
     80.0 // Forest
 ));
  

   // Method to select a team
   public boolean selectTeam(int team1, int team2){ 
     if (team1 != team2){
      this.team1 = teams.get(team1);
      this.team2 = teams.get(team2);
      return true;
     } else {
      return false;
     }
   }

  // Leaving it blank will make it select random teams for you
   public void selectTeam(){
      team1 = teams.get((int)(Math.random()*20));
      team2 =  teams.get((int)(Math.random()*20));
      
      if(team1.equals(team2)){
        selectTeam();
      }
   }
   
   // Simulates entire match
   public String startMatch(){
    score1 = 0;
    score2 = 0;
    if (team1 == null || team2 == null){
     return ("E01: 2 (two) teams not selected.");
    } else {
    int i1 = teams.indexOf(team1); // index of team1
    int i2 = teams.indexOf(team2); //  index of team2
    int mins = (int)(90 + Math.floor(Math.random()*11)); // Total minutes to play
    int possesion; // 0 = t1 has possesion 1 = t2 has possesion. This value should not exceed 1.
    int chance; // 1 in 6 chance for a major attacking chance to occur.
    double opportunity; // Goal is registered if this number is bigger than the goal threshold.
    double goalThreshold; // Amount needed for a goal to be simulated
    score1 = 0;
    score2 = 0;
    for(int i = 0 ; i <= mins ; i++){
        // Every minute possesion is re-simulated
     possesion = (int)(Math.random()*2);
      
      if (possesion == 0){
        chance = (int)(Math.ceil(Math.random()*6));
          if (chance == 1){
            opportunity = ((atk.get(i1)+(mid.get(i1)/2)) / (def.get(i2)+(mid.get(i2)/2)) + (Math.random()/3));
            goalThreshold = 0.5 + Math.random()*2;
             if (opportunity >= goalThreshold){
                score1++;
             }
          }
      } else {
        chance = (int)(Math.ceil(Math.random()*6));
          if (chance == 1){
            opportunity = ((atk.get(i2)+(mid.get(i2)/2)) / (def.get(i1)+(mid.get(i1)/2))) + (Math.random()/3);
            goalThreshold = 0.5 + Math.random()*2;
             if (opportunity >= goalThreshold){
                score2++;
             }
          }
      }
    }
     return team1+" "+score1+" - "+score2+" "+team2+" ("+mins+" mins)";
   }
 }
}