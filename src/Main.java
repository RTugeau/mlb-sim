// mlb_sim Main
// Created by Riley Tugeau
// Summer 2022

package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.lang.Thread;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        String csvFile = "teamWins.csv";
        try(PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            Team BAL = new Team("Orioles", 0, 0, 45.9, 0, 0);
            Team NYY = new Team("Yankees", 0, 0, 53.3, 0, 0);
            Team TOR = new Team("Blue Jays", 0, 0, 58.5, 0, 0);
            Team BOS = new Team("Red Sox", 0, 0, 54.5, 0, 0);
            Team TB = new Team("Rays", 0, 0, 48.8, 0, 0);
            Team WSH = new Team("Nationals", 0, 0, 40.2, 0, 0);
            Team NYM = new Team("Mets", 0, 0, 52.5, 0, 0);
            Team ATL = new Team("Braves", 0, 0, 44.3, 0, 0);
            Team PHI = new Team("Phillies", 0, 0, 57.4, 0, 0);
            Team MIA = new Team("Marlins", 0, 0, 47.5, 0, 0);
            Team CWS = new Team("White Sox", 0, 0, 36.1, 0, 0);
            Team CLE = new Team("Guardians", 0, 0, 52.1, 0, 0);
            Team MIN = new Team("Twins", 0, 0, 46.7, 0, 0);
            Team DET = new Team("Tigers", 0, 0, 58.1, 0, 0);
            Team KC = new Team("Royals", 0, 0, 50.0, 0, 0);
            Team STL = new Team("Cardinals", 0, 0, 49.6, 0, 0);
            Team MIL = new Team("Brewers", 0, 0, 63.6, 0, 0);
            Team PIT = new Team("Pirates", 0, 0, 42.3, 0, 0);
            Team CIN = new Team("Reds", 0, 0, 52.0, 0, 0);
            Team CHC = new Team("Cubs", 0, 0, 56.2, 0, 0);
            Team LAA = new Team("Angels", 0, 0, 48.4, 0, 0);
            Team HOU = new Team("Astros", 0, 0, 55.7, 0, 0);
            Team SAC = new Team("Athletics", 0, 0, 44.4, 0, 0);
            Team TEX = new Team("Rangers", 0, 0, 49.6, 0, 0);
            Team SEA = new Team("Mariners", 0, 0, 55.3, 0, 0);
            Team LAD = new Team("Dodgers", 0, 0, 56.6, 0, 0);
            Team SF = new Team("Giants", 0, 0, 48.4, 0, 0);
            Team SD = new Team("Padres", 0, 0, 56.6, 0, 0);
            Team COL = new Team("Rockies", 0, 0, 27.0, 0, 0);
            Team ARI = new Team("Diamondbacks", 0, 0, 48.8, 0, 0);
            List<Team> alEast = new ArrayList();
            List<Team> nlEast = new ArrayList();
            List<Team> alCentral = new ArrayList();
            List<Team> nlCentral = new ArrayList();
            List<Team> alWest = new ArrayList();
            List<Team> nlWest = new ArrayList();
            List<Team> americanLeague = new ArrayList();
            List<Team> nationalLeague = new ArrayList();
            List<Team> alDivWinners = new ArrayList();
            List<Team> nlDivWinners = new ArrayList();
            List<Team> alwcWinners = new ArrayList();
            List<Team> nlwcWinners = new ArrayList();
            Team[] nlPostseason = new Team[4];
            Team[] alPostseason = new Team[4];
            Team[] alds = new Team[4];
            Team[] nlds = new Team[4];
            Team[] alcs = new Team[2];
            Team[] nlcs = new Team[2];
            Team[] worldSeries = new Team[2];
            alEast.add(BAL);
            alEast.add(NYY);
            alEast.add(TOR);
            alEast.add(BOS);
            alEast.add(TB);
            nlEast.add(WSH);
            nlEast.add(NYM);
            nlEast.add(ATL);
            nlEast.add(PHI);
            nlEast.add(MIA);
            alCentral.add(CWS);
            alCentral.add(CLE);
            alCentral.add(MIN);
            alCentral.add(DET);
            alCentral.add(KC);
            nlCentral.add(STL);
            nlCentral.add(MIL);
            nlCentral.add(PIT);
            nlCentral.add(CIN);
            nlCentral.add(CHC);
            alWest.add(LAA);
            alWest.add(HOU);
            alWest.add(SAC);
            alWest.add(TEX);
            alWest.add(SEA);
            nlWest.add(LAD);
            nlWest.add(SF);
            nlWest.add(SD);
            nlWest.add(COL);
            nlWest.add(ARI);
            americanLeague.add(BAL);
            americanLeague.add(NYY);
            americanLeague.add(TOR);
            americanLeague.add(BOS);
            americanLeague.add(TB);
            americanLeague.add(CWS);
            americanLeague.add(MIN);
            americanLeague.add(DET);
            americanLeague.add(KC);
            americanLeague.add(CLE);
            americanLeague.add(LAA);
            americanLeague.add(HOU);
            americanLeague.add(SAC);
            americanLeague.add(SEA);
            americanLeague.add(TEX);
            nationalLeague.add(WSH);
            nationalLeague.add(NYM);
            nationalLeague.add(ATL);
            nationalLeague.add(PHI);
            nationalLeague.add(MIA);
            nationalLeague.add(MIL);
            nationalLeague.add(STL);
            nationalLeague.add(CIN);
            nationalLeague.add(CHC);
            nationalLeague.add(PIT);
            nationalLeague.add(LAD);
            nationalLeague.add(SD);
            nationalLeague.add(SF);
            nationalLeague.add(COL);
            nationalLeague.add(ARI);
            Scanner scan = new Scanner(System.in);
            System.out.println("1.) Sim Games");
            System.out.println("2.) Enter Team W%");
            System.out.println("3.) Quit");
            int response = scan.nextInt();
            while(response != 3) {
                if (response == 1) {
                    System.out.println("Enter simulation speed (sec.): ");
                    int i = scan.nextInt() * 1000;
                    List<Team> mlb = new ArrayList();
                    mlb.add(BAL);
                    mlb.add(BOS);
                    mlb.add(NYY);
                    mlb.add(TB);
                    mlb.add(TOR);
                    mlb.add(KC);
                    mlb.add(MIN);
                    mlb.add(DET);
                    mlb.add(CWS);
                    mlb.add(CLE);
                    mlb.add(TEX);
                    mlb.add(SEA);
                    mlb.add(LAA);
                    mlb.add(HOU);
                    mlb.add(SAC);
                    mlb.add(WSH);
                    mlb.add(ATL);
                    mlb.add(MIA);
                    mlb.add(PHI);
                    mlb.add(NYM);
                    mlb.add(MIL);
                    mlb.add(CHC);
                    mlb.add(PIT);
                    mlb.add(STL);
                    mlb.add(CIN);
                    mlb.add(LAD);
                    mlb.add(SD);
                    mlb.add(SF);
                    mlb.add(COL);
                    mlb.add(ARI);

                    int games = 0;

                    writer.println("#,BAL,BOS,NYY,TOR,TB,DET,MIN,CWS,CLE,KC,LAA,ATH,HOU,SEA,TEX,WSH,ATL,NYM,PHI,MIA,CHC,MIL,STL,PIT,CIN,SF,LAD,SD,COL,ARI");

                    while (response == 1 && games < 162) {
                        Collections.shuffle(mlb);
                        games += 3;
                        System.out.println("Series Previews: Games " + (games - 2) + " - " + games);
                        System.out.println(mlb.get(0).getName() + " (" + mlb.get(0).getWins() + "-" + mlb.get(0).getLosses() + ") vs. " + mlb.get(1).getName() + " (" + mlb.get(1).getWins() + "-" + mlb.get(1).getLosses() + ")");
                        System.out.println(mlb.get(2).getName() + " (" + mlb.get(2).getWins() + "-" + mlb.get(2).getLosses() + ") vs. " + mlb.get(3).getName() + " (" + mlb.get(3).getWins() + "-" + mlb.get(3).getLosses() + ")");
                        System.out.println(mlb.get(4).getName() + " (" + mlb.get(4).getWins() + "-" + mlb.get(4).getLosses() + ") vs. " + mlb.get(5).getName() + " (" + mlb.get(5).getWins() + "-" + mlb.get(5).getLosses() + ")");
                        System.out.println(mlb.get(6).getName() + " (" + mlb.get(6).getWins() + "-" + mlb.get(6).getLosses() + ") vs. " + mlb.get(7).getName() + " (" + mlb.get(7).getWins() + "-" + mlb.get(7).getLosses() + ")");
                        System.out.println(mlb.get(8).getName() + " (" + mlb.get(8).getWins() + "-" + mlb.get(8).getLosses() + ") vs. " + mlb.get(9).getName() + " (" + mlb.get(9).getWins() + "-" + mlb.get(9).getLosses() + ")");
                        System.out.println(mlb.get(10).getName() + " (" + mlb.get(10).getWins() + "-" + mlb.get(10).getLosses() + ") vs. " + mlb.get(11).getName() + " (" + mlb.get(11).getWins() + "-" + mlb.get(11).getLosses() + ")");
                        System.out.println(mlb.get(12).getName() + " (" + mlb.get(12).getWins() + "-" + mlb.get(12).getLosses() + ") vs. " + mlb.get(13).getName() + " (" + mlb.get(13).getWins() + "-" + mlb.get(13).getLosses() + ")");
                        System.out.println(mlb.get(14).getName() + " (" + mlb.get(14).getWins() + "-" + mlb.get(14).getLosses() + ") vs. " + mlb.get(15).getName() + " (" + mlb.get(15).getWins() + "-" + mlb.get(15).getLosses() + ")");
                        System.out.println(mlb.get(16).getName() + " (" + mlb.get(16).getWins() + "-" + mlb.get(16).getLosses() + ") vs. " + mlb.get(17).getName() + " (" + mlb.get(17).getWins() + "-" + mlb.get(17).getLosses() + ")");
                        System.out.println(mlb.get(18).getName() + " (" + mlb.get(18).getWins() + "-" + mlb.get(18).getLosses() + ") vs. " + mlb.get(19).getName() + " (" + mlb.get(19).getWins() + "-" + mlb.get(19).getLosses() + ")");
                        System.out.println(mlb.get(20).getName() + " (" + mlb.get(20).getWins() + "-" + mlb.get(20).getLosses() + ") vs. " + mlb.get(21).getName() + " (" + mlb.get(21).getWins() + "-" + mlb.get(21).getLosses() + ")");
                        System.out.println(mlb.get(22).getName() + " (" + mlb.get(22).getWins() + "-" + mlb.get(22).getLosses() + ") vs. " + mlb.get(23).getName() + " (" + mlb.get(23).getWins() + "-" + mlb.get(23).getLosses() + ")");
                        System.out.println(mlb.get(24).getName() + " (" + mlb.get(24).getWins() + "-" + mlb.get(24).getLosses() + ") vs. " + mlb.get(25).getName() + " (" + mlb.get(25).getWins() + "-" + mlb.get(25).getLosses() + ")");
                        System.out.println(mlb.get(26).getName() + " (" + mlb.get(26).getWins() + "-" + mlb.get(26).getLosses() + ") vs. " + mlb.get(27).getName() + " (" + mlb.get(27).getWins() + "-" + mlb.get(27).getLosses() + ")");
                        System.out.println(mlb.get(28).getName() + " (" + mlb.get(28).getWins() + "-" + mlb.get(28).getLosses() + ") vs. " + mlb.get(29).getName() + " (" + mlb.get(29).getWins() + "-" + mlb.get(29).getLosses() + ")");
                        Thread.sleep(i);
                        BAL.game(mlb.get(0), mlb.get(1));
                        BAL.game(mlb.get(2), mlb.get(3));
                        BAL.game(mlb.get(4), mlb.get(5));
                        BAL.game(mlb.get(6), mlb.get(7));
                        BAL.game(mlb.get(8), mlb.get(9));
                        BAL.game(mlb.get(10), mlb.get(11));
                        BAL.game(mlb.get(12), mlb.get(13));
                        BAL.game(mlb.get(14), mlb.get(15));
                        BAL.game(mlb.get(16), mlb.get(17));
                        BAL.game(mlb.get(18), mlb.get(19));
                        BAL.game(mlb.get(20), mlb.get(21));
                        BAL.game(mlb.get(22), mlb.get(23));
                        BAL.game(mlb.get(24), mlb.get(25));
                        BAL.game(mlb.get(26), mlb.get(27));
                        BAL.game(mlb.get(28), mlb.get(29));
                        Thread.sleep(i);
                        BAL.game(mlb.get(0), mlb.get(1));
                        BAL.game(mlb.get(2), mlb.get(3));
                        BAL.game(mlb.get(4), mlb.get(5));
                        BAL.game(mlb.get(6), mlb.get(7));
                        BAL.game(mlb.get(8), mlb.get(9));
                        BAL.game(mlb.get(10), mlb.get(11));
                        BAL.game(mlb.get(12), mlb.get(13));
                        BAL.game(mlb.get(14), mlb.get(15));
                        BAL.game(mlb.get(16), mlb.get(17));
                        BAL.game(mlb.get(18), mlb.get(19));
                        BAL.game(mlb.get(20), mlb.get(21));
                        BAL.game(mlb.get(22), mlb.get(23));
                        BAL.game(mlb.get(24), mlb.get(25));
                        BAL.game(mlb.get(26), mlb.get(27));
                        BAL.game(mlb.get(28), mlb.get(29));
                        Thread.sleep(i);
                        BAL.game(mlb.get(0), mlb.get(1));
                        BAL.game(mlb.get(2), mlb.get(3));
                        BAL.game(mlb.get(4), mlb.get(5));
                        BAL.game(mlb.get(6), mlb.get(7));
                        BAL.game(mlb.get(8), mlb.get(9));
                        BAL.game(mlb.get(10), mlb.get(11));
                        BAL.game(mlb.get(12), mlb.get(13));
                        BAL.game(mlb.get(14), mlb.get(15));
                        BAL.game(mlb.get(16), mlb.get(17));
                        BAL.game(mlb.get(18), mlb.get(19));
                        BAL.game(mlb.get(20), mlb.get(21));
                        BAL.game(mlb.get(22), mlb.get(23));
                        BAL.game(mlb.get(24), mlb.get(25));
                        BAL.game(mlb.get(26), mlb.get(27));
                        BAL.game(mlb.get(28), mlb.get(29));
                        Thread.sleep(i);

                        writer.println(games + "," + winToLosses(BAL) + "," + winToLosses(BOS) + "," + winToLosses(NYY) + ","
                                + winToLosses(TOR) + "," + winToLosses(TB) + "," + winToLosses(DET) + "," + winToLosses(MIN) + "," + winToLosses(CWS) + ","
                                + winToLosses(CLE) + "," + winToLosses(KC) + "," + winToLosses(LAA) + "," + winToLosses(SAC) + "," + winToLosses(HOU) + ","
                                + winToLosses(SEA) + "," + winToLosses(TEX) + "," + winToLosses(WSH) + "," + winToLosses(ATL) + "," + winToLosses(NYM) + ","
                                + winToLosses(PHI) + "," + winToLosses(MIA) + "," + winToLosses(CHC) + "," + winToLosses(MIL) + "," + winToLosses(STL) + ","
                                + winToLosses(PIT) + "," + winToLosses(CIN) + "," + winToLosses(SF) + "," + winToLosses(LAD) + "," + winToLosses(SD) + ","
                                + winToLosses(COL) + "," + winToLosses(ARI));

                        System.out.format("%-30s%-4s%-4s%-5s%-4s%n", "AL East Standings", "W", "L", "GB", "STRK");
                        System.out.println("------------------------------------------------");
                        double gb1;
                        int first1 = 0;
                        while (alEast.size() > 0) {
                            Team highest = alEast.get(0);

                            for (int j = 0; j < alEast.size(); j++) {
                                if (alEast.get(j).getWins() > highest.getWins()) {
                                    highest = alEast.get(j);
                                }
                            }

                            if (alEast.size() == 5) {
                                first1 = highest.getLosses();
                                highest.firstPlace = true;
                                highest.wildCard = false;
                            } else {
                                highest.wildCard = true;
                                highest.firstPlace = false;
                            }
                            gb1 = highest.getLosses() - first1;
                            System.out.format("%-30s%-4s%-4s%-5s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses(), gb1, highest.getStreak());
                            alEast.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%-4s%n", "AL Central Standings", "W", "L", "GB", "STRK");
                        System.out.println("------------------------------------------------");
                        double gb2;
                        int first2 = 0;
                        while (alCentral.size() > 0) {
                            Team highest = alCentral.get(0);

                            for (int j = 0; j < alCentral.size(); j++) {
                                if (alCentral.get(j).getWins() > highest.getWins()) {
                                    highest = alCentral.get(j);
                                }
                            }
                            if (alCentral.size() == 5) {
                                first2 = highest.getLosses();
                                highest.firstPlace = true;
                                highest.wildCard = false;
                            } else {
                                highest.wildCard = true;
                                highest.firstPlace = false;
                            }
                            gb2 = highest.getLosses() - first2;
                            System.out.format("%-30s%-4s%-4s%-5s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses(), gb2, highest.getStreak());
                            alCentral.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%-4s%n", "AL West Standings", "W", "L", "GB", "STRK");
                        System.out.println("------------------------------------------------");
                        double gb3;
                        int first3 = 0;
                        while (alWest.size() > 0) {
                            Team highest = alWest.get(0);
                            for (int j = 0; j < alWest.size(); j++) {
                                if (alWest.get(j).getWins() > highest.getWins()) {
                                    highest = alWest.get(j);
                                }
                            }
                            if (alWest.size() == 5) {
                                first3 = highest.getLosses();
                                highest.firstPlace = true;
                                highest.wildCard = false;
                            } else {
                                highest.wildCard = true;
                                highest.firstPlace = false;
                            }
                            gb3 = highest.getLosses() - first3;
                            System.out.format("%-30s%-4s%-4s%-5s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses(), gb3, highest.getStreak());
                            alWest.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%n", "AL Wild Card Standings", "W", "L", "GB");
                        System.out.println("------------------------------------------------");
                        double alwc;
                        int firstAlwc = 0;
                        for (int a = 0; a < americanLeague.size(); a++) {
                            if (americanLeague.get(a).firstPlace) {
                                americanLeague.remove(americanLeague.get(a));
                            }
                        }

                        while (americanLeague.size() > 0) {
                            Team highest = americanLeague.get(0);
                            for (int j = 0; j < americanLeague.size(); j++) {
                                if (americanLeague.get(j).getWins() > highest.getWins()) {
                                    highest = americanLeague.get(j);
                                }
                            }
                            if (americanLeague.size() >= 10) {
                                firstAlwc = highest.getLosses();
                            }
                            alwc = highest.getLosses() - firstAlwc;
                            if (americanLeague.size() > 9) {
                                System.out.format("%-30s%-4s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses());
                            } else if (americanLeague.size() == 9) {
                                highest.wildCard = false;
                                System.out.println("------------------------------------------------");
                                System.out.format("%-30s%-4s%-4s%-5s%n", highest.getName(), highest.getWins(), highest.getLosses(), alwc);
                            } else {
                                highest.wildCard = false;
                                System.out.format("%-30s%-4s%-4s%-5s%n", highest.getName(), highest.getWins(), highest.getLosses(), alwc);
                            }
                            americanLeague.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%-4s%n", "NL East Standings", "W", "L", "GB", "STRK");
                        System.out.println("------------------------------------------------");
                        double gb4;
                        int first4 = 0;
                        while (nlEast.size() > 0) {
                            Team highest = nlEast.get(0);
                            for (int j = 0; j < nlEast.size(); j++) {
                                if (nlEast.get(j).getWins() > highest.getWins()) {
                                    highest = nlEast.get(j);
                                }
                            }
                            if (nlEast.size() == 5) {
                                first4 = highest.getLosses();
                                highest.firstPlace = true;
                                highest.wildCard = false;
                            } else {
                                highest.wildCard = true;
                                highest.firstPlace = false;
                            }
                            gb4 = highest.getLosses() - first4;
                            System.out.format("%-30s%-4s%-4s%-5s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses(), gb4, highest.getStreak());
                            nlEast.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%-4s%n", "NL Central Standings", "W", "L", "GB", "STRK");
                        System.out.println("------------------------------------------------");
                        double gb5;
                        int first5 = 0;
                        while (nlCentral.size() > 0) {
                            Team highest = nlCentral.get(0);
                            for (int j = 0; j < nlCentral.size(); j++) {
                                if (nlCentral.get(j).getWins() > highest.getWins()) {
                                    highest = nlCentral.get(j);
                                }
                            }
                            if (nlCentral.size() == 5) {
                                first5 = highest.getLosses();
                                highest.firstPlace = true;
                                highest.wildCard = false;
                            } else {
                                highest.wildCard = true;
                                highest.firstPlace = false;
                            }
                            gb5 = highest.getLosses() - first5;
                            System.out.format("%-30s%-4s%-4s%-5s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses(), gb5, highest.getStreak());
                            nlCentral.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%-4s%n", "NL West Standings", "W", "L", "GB", "STRK");
                        System.out.println("------------------------------------------------");
                        double gb6;
                        int first6 = 0;
                        while (nlWest.size() > 0) {
                            Team highest = nlWest.get(0);
                            for (int j = 0; j < nlWest.size(); j++) {
                                if (nlWest.get(j).getWins() > highest.getWins()) {
                                    highest = nlWest.get(j);
                                }
                            }
                            if (nlWest.size() == 5) {
                                first6 = highest.getLosses();
                                highest.wildCard = false;
                                highest.firstPlace = true;
                            } else {
                                highest.wildCard = true;
                                highest.firstPlace = false;
                            }
                            gb6 = highest.getLosses() - first6;
                            System.out.format("%-30s%-4s%-4s%-5s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses(), gb6, highest.getStreak());
                            nlWest.remove(highest);
                        }

                        System.out.println("");
                        System.out.format("%-30s%-4s%-4s%-5s%n", "NL Wild Card Standings", "W", "L", "GB");
                        System.out.println("------------------------------------------------");
                        double nlwc;
                        int firstNlwc = 0;
                        for (int n = 0; n < nationalLeague.size(); n++) {
                            if (nationalLeague.get(n).firstPlace) {
                                nationalLeague.remove(nationalLeague.get(n));
                            }
                        }
                        while (nationalLeague.size() > 0) {
                            Team highest = nationalLeague.get(0);
                            for (int j = 0; j < nationalLeague.size(); j++) {
                                if (nationalLeague.get(j).getWins() > highest.getWins()) {
                                    highest = nationalLeague.get(j);
                                }
                            }
                            if (nationalLeague.size() >= 10) {
                                firstNlwc = highest.getLosses();
                            }
                            nlwc = highest.getLosses() - firstNlwc;
                            if (nationalLeague.size() > 9) {
                                highest.wildCard = true;
                                System.out.format("%-30s%-4s%-4s%n", highest.getName(), highest.getWins(), highest.getLosses());
                            } else if (nationalLeague.size() == 9) {
                                highest.wildCard = false;
                                System.out.println("------------------------------------------------");
                                System.out.format("%-30s%-4s%-4s%-5s%n", highest.getName(), highest.getWins(), highest.getLosses(), nlwc);
                            } else {
                                highest.wildCard = false;
                                System.out.format("%-30s%-4s%-4s%-5s%n", highest.getName(), highest.getWins(), highest.getLosses(), nlwc);
                            }
                            nationalLeague.remove(highest);
                        }

                        alEast.add(BAL);
                        alEast.add(NYY);
                        alEast.add(TOR);
                        alEast.add(BOS);
                        alEast.add(TB);
                        nlEast.add(WSH);
                        nlEast.add(NYM);
                        nlEast.add(ATL);
                        nlEast.add(PHI);
                        nlEast.add(MIA);
                        alCentral.add(CWS);
                        alCentral.add(CLE);
                        alCentral.add(MIN);
                        alCentral.add(DET);
                        alCentral.add(KC);
                        nlCentral.add(STL);
                        nlCentral.add(MIL);
                        nlCentral.add(PIT);
                        nlCentral.add(CIN);
                        nlCentral.add(CHC);
                        alWest.add(LAA);
                        alWest.add(HOU);
                        alWest.add(SAC);
                        alWest.add(TEX);
                        alWest.add(SEA);
                        nlWest.add(LAD);
                        nlWest.add(SF);
                        nlWest.add(SD);
                        nlWest.add(COL);
                        nlWest.add(ARI);
                        americanLeague.add(BAL);
                        americanLeague.add(NYY);
                        americanLeague.add(TOR);
                        americanLeague.add(BOS);
                        americanLeague.add(TB);
                        americanLeague.add(CWS);
                        americanLeague.add(MIN);
                        americanLeague.add(DET);
                        americanLeague.add(KC);
                        americanLeague.add(CLE);
                        americanLeague.add(LAA);
                        americanLeague.add(HOU);
                        americanLeague.add(SAC);
                        americanLeague.add(SEA);
                        americanLeague.add(TEX);
                        nationalLeague.add(WSH);
                        nationalLeague.add(NYM);
                        nationalLeague.add(ATL);
                        nationalLeague.add(PHI);
                        nationalLeague.add(MIA);
                        nationalLeague.add(MIL);
                        nationalLeague.add(STL);
                        nationalLeague.add(CIN);
                        nationalLeague.add(CHC);
                        nationalLeague.add(PIT);
                        nationalLeague.add(LAD);
                        nationalLeague.add(SD);
                        nationalLeague.add(SF);
                        nationalLeague.add(COL);
                        nationalLeague.add(ARI);

                        System.out.println("");
                        if (games < 162) {
                            System.out.println("1.) Continue Season");
                        } else {
                            System.out.println("1.) End Season");
                        }
                        response = scan.nextInt();
                    }

                    for (int a = 0; a < americanLeague.size(); a++) {
                        if (americanLeague.get(a).firstPlace) {
                            alDivWinners.add(americanLeague.get(a));
                        } else if (americanLeague.get(a).wildCard) {
                            alwcWinners.add(americanLeague.get(a));
                        }
                    }

                    for (int n = 0; n < nationalLeague.size(); n++) {
                        if (nationalLeague.get(n).firstPlace) {
                            nlDivWinners.add(nationalLeague.get(n));
                        } else if (nationalLeague.get(n).wildCard) {
                            nlwcWinners.add(nationalLeague.get(n));
                        }
                    }

                    System.out.println("Playoffs");
                    System.out.println("------------------------------------------------");

                    System.out.println("Enter simulation speed (sec.): ");
                    int speed = scan.nextInt() * 1000;

                    int seed = 1;
                    while (alDivWinners.size() > 0) {
                        Team highest = alDivWinners.get(0);
                        for (int j = 0; j < alDivWinners.size(); j++) {
                            if (alDivWinners.get(j).getWins() > highest.getWins()) {
                                highest = alDivWinners.get(j);
                            }
                        }
                        System.out.println("(" + seed + ") " + highest.getName() + " (" + highest.getWins() + "-" + highest.getLosses() + ")");
                        highest.setSeed(seed);
                        seed++;
                        alDivWinners.remove(highest);
                    }

                    while (alwcWinners.size() > 0) {
                        Team highest = alwcWinners.get(0);
                        for (int j = 0; j < alwcWinners.size(); j++) {
                            if (alwcWinners.get(j).getWins() > highest.getWins()) {
                                highest = alwcWinners.get(j);
                            }
                        }
                        System.out.println("(" + seed + ") " + highest.getName() + " (" + highest.getWins() + "-" + highest.getLosses() + ")");
                        highest.setSeed(seed);
                        seed++;
                        alwcWinners.remove(highest);
                    }

                    System.out.println("------------------------------------------------");
                    seed = 1;

                    while (nlDivWinners.size() > 0) {
                        Team highest = nlDivWinners.get(0);
                        for (int j = 0; j < nlDivWinners.size(); j++) {
                            if (nlDivWinners.get(j).getWins() > highest.getWins()) {
                                highest = nlDivWinners.get(j);
                            }
                        }
                        System.out.println("(" + seed + ") " + highest.getName() + " (" + highest.getWins() + "-" + highest.getLosses() + ")");
                        highest.setSeed(seed);
                        seed++;
                        nlDivWinners.remove(highest);
                    }

                    while (nlwcWinners.size() > 0) {
                        Team highest = nlwcWinners.get(0);
                        for (int j = 0; j < nlwcWinners.size(); j++) {
                            if (nlwcWinners.get(j).getWins() > highest.getWins()) {
                                highest = nlwcWinners.get(j);
                            }
                        }
                        System.out.println("(" + seed + ") " + highest.getName() + " (" + highest.getWins() + "-" + highest.getLosses() + ")");
                        highest.setSeed(seed);
                        seed++;
                        nlwcWinners.remove(highest);
                    }

                    for (int g = 0; g < americanLeague.size(); g++) {
                        if (americanLeague.get(g).getSeed() == 1) {
                            alds[0] = americanLeague.get(g);
                            americanLeague.get(g).setWins(0);
                            americanLeague.get(g).setLosses(0);
                        } else if (americanLeague.get(g).getSeed() == 2) {
                            alds[1] = americanLeague.get(g);
                            americanLeague.get(g).setWins(0);
                            americanLeague.get(g).setLosses(0);
                        } else if (americanLeague.get(g).getSeed() == 3) {
                            alPostseason[0] = americanLeague.get(g);
                            americanLeague.get(g).setWins(0);
                            americanLeague.get(g).setLosses(0);
                        } else if (americanLeague.get(g).getSeed() == 4) {
                            alPostseason[1] = americanLeague.get(g);
                            americanLeague.get(g).setWins(0);
                            americanLeague.get(g).setLosses(0);
                        } else if (americanLeague.get(g).getSeed() == 5) {
                            alPostseason[2] = americanLeague.get(g);
                            americanLeague.get(g).setWins(0);
                            americanLeague.get(g).setLosses(0);
                        } else if (americanLeague.get(g).getSeed() == 6) {
                            alPostseason[3] = americanLeague.get(g);
                            americanLeague.get(g).setWins(0);
                            americanLeague.get(g).setLosses(0);
                        }
                    }

                    for (int g = 0; g < nationalLeague.size(); g++) {
                        if (nationalLeague.get(g).getSeed() == 1) {
                            nlds[0] = nationalLeague.get(g);
                            nationalLeague.get(g).setWins(0);
                            nationalLeague.get(g).setLosses(0);
                        } else if (nationalLeague.get(g).getSeed() == 2) {
                            nlds[1] = nationalLeague.get(g);
                            nationalLeague.get(g).setWins(0);
                            nationalLeague.get(g).setLosses(0);
                        } else if (nationalLeague.get(g).getSeed() == 3) {
                            nlPostseason[0] = nationalLeague.get(g);
                            nationalLeague.get(g).setWins(0);
                            nationalLeague.get(g).setLosses(0);
                        } else if (nationalLeague.get(g).getSeed() == 4) {
                            nlPostseason[1] = nationalLeague.get(g);
                            nationalLeague.get(g).setWins(0);
                            nationalLeague.get(g).setLosses(0);
                        } else if (nationalLeague.get(g).getSeed() == 5) {
                            nlPostseason[2] = nationalLeague.get(g);
                            nationalLeague.get(g).setWins(0);
                            nationalLeague.get(g).setLosses(0);
                        } else if (nationalLeague.get(g).getSeed() == 6) {
                            nlPostseason[3] = nationalLeague.get(g);
                            nationalLeague.get(g).setWins(0);
                            nationalLeague.get(g).setLosses(0);
                        }
                    }

                    int g = 1;
                    System.out.println("");
                    System.out.println("American League Wild Card Series: " + alPostseason[3].getName() + " vs. " + alPostseason[0].getName());
                    Thread.sleep(speed);
                    while (alPostseason[3].getWins() < 2 && alPostseason[0].getWins() < 2) {
                        System.out.println("Game " + g + ": " + alPostseason[3].getName() + " vs. " + alPostseason[0].getName());
                        Thread.sleep(speed);
                        alPostseason[0].game(alPostseason[3], alPostseason[0]);
                        g++;
                        Thread.sleep(speed);
                        if (alPostseason[3].getWins() == 2) {
                            System.out.println(alPostseason[3].getName() + " win series " + alPostseason[3].getWins() + " - " + alPostseason[0].getWins());
                            alds[3] = alPostseason[3];
                            Thread.sleep(speed);
                        } else if (alPostseason[0].getWins() == 2) {
                            System.out.println(alPostseason[0].getName() + " win series " + alPostseason[0].getWins() + " - " + alPostseason[3].getWins());
                            alds[3] = alPostseason[0];
                            Thread.sleep(speed);
                        } else if (alPostseason[3].getWins() > alPostseason[0].getWins()) {
                            System.out.println(alPostseason[3].getName() + " lead series " + alPostseason[3].getWins() + " - " + alPostseason[0].getWins());
                            Thread.sleep(speed);
                        } else if (alPostseason[3].getWins() == alPostseason[0].getWins()) {
                            System.out.println("Series Tied " + alPostseason[3].getWins() + " - " + alPostseason[0].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(alPostseason[0].getName() + " lead series " + alPostseason[0].getWins() + " - " + alPostseason[3].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    alds[3].setWins(0);
                    alds[3].setLosses(0);

                    g = 1;
                    System.out.println("");
                    System.out.println("American League Wild Card Series: " + alPostseason[2].getName() + " vs. " + alPostseason[1].getName());
                    Thread.sleep(speed);
                    while (alPostseason[2].getWins() < 2 && alPostseason[1].getWins() < 2) {
                        System.out.println("Game " + g + ": " + alPostseason[2].getName() + " vs. " + alPostseason[1].getName());
                        Thread.sleep(speed);
                        alPostseason[1].game(alPostseason[2], alPostseason[1]);
                        g++;
                        Thread.sleep(speed);
                        if (alPostseason[2].getWins() == 2) {
                            System.out.println(alPostseason[2].getName() + " win series " + alPostseason[2].getWins() + " - " + alPostseason[1].getWins());
                            alds[2] = alPostseason[2];
                            Thread.sleep(speed);
                        } else if (alPostseason[1].getWins() == 2) {
                            System.out.println(alPostseason[1].getName() + " win series " + alPostseason[1].getWins() + " - " + alPostseason[2].getWins());
                            alds[2] = alPostseason[1];
                            Thread.sleep(speed);
                        } else if (alPostseason[2].getWins() > alPostseason[1].getWins()) {
                            System.out.println(alPostseason[2].getName() + " lead series " + alPostseason[2].getWins() + " - " + alPostseason[1].getWins());
                            Thread.sleep(speed);
                        } else if (alPostseason[2].getWins() == alPostseason[1].getWins()) {
                            System.out.println("Series Tied " + alPostseason[2].getWins() + " - " + alPostseason[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(alPostseason[1].getName() + " lead series " + alPostseason[1].getWins() + " - " + alPostseason[2].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    alds[2].setWins(0);
                    alds[2].setLosses(0);

                    g = 1;
                    System.out.println("");
                    System.out.println("National League Wild Card Series: " + nlPostseason[3].getName() + " vs. " + nlPostseason[0].getName());
                    Thread.sleep(speed);
                    while (nlPostseason[3].getWins() < 2 && nlPostseason[0].getWins() < 2) {
                        System.out.println("Game " + g + ": " + nlPostseason[3].getName() + " vs. " + nlPostseason[0].getName());
                        Thread.sleep(speed);
                        nlPostseason[0].game(nlPostseason[3], nlPostseason[0]);
                        g++;
                        Thread.sleep(speed);
                        if (nlPostseason[3].getWins() == 2) {
                            System.out.println(nlPostseason[3].getName() + " win series " + nlPostseason[3].getWins() + " - " + nlPostseason[0].getWins());
                            nlds[3] = nlPostseason[3];
                            Thread.sleep(speed);
                        } else if (nlPostseason[0].getWins() == 2) {
                            System.out.println(nlPostseason[0].getName() + " win series " + nlPostseason[0].getWins() + " - " + nlPostseason[3].getWins());
                            nlds[3] = nlPostseason[0];
                            Thread.sleep(speed);
                        } else if (nlPostseason[3].getWins() > nlPostseason[0].getWins()) {
                            System.out.println(nlPostseason[3].getName() + " lead series " + nlPostseason[3].getWins() + " - " + nlPostseason[0].getWins());
                            Thread.sleep(speed);
                        } else if (nlPostseason[3].getWins() == nlPostseason[0].getWins()) {
                            System.out.println("Series Tied " + nlPostseason[3].getWins() + " - " + nlPostseason[0].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(nlPostseason[0].getName() + " lead series " + nlPostseason[0].getWins() + " - " + nlPostseason[3].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    nlds[3].setWins(0);
                    nlds[3].setLosses(0);

                    g = 1;
                    System.out.println("");
                    System.out.println("National League Wild Card Series: " + nlPostseason[2].getName() + " vs. " + nlPostseason[1].getName());
                    Thread.sleep(speed);

                    while (nlPostseason[2].getWins() < 2 && nlPostseason[1].getWins() < 2) {
                        System.out.println("Game " + g + ": " + nlPostseason[2].getName() + " vs. " + nlPostseason[1].getName());
                        Thread.sleep(speed);
                        nlPostseason[1].game(nlPostseason[2], nlPostseason[1]);
                        ++g;
                        Thread.sleep(speed);
                        if (nlPostseason[2].getWins() == 2) {
                            System.out.println(nlPostseason[2].getName() + " win series " + nlPostseason[2].getWins() + " - " + nlPostseason[1].getWins());
                            nlds[2] = nlPostseason[2];
                            Thread.sleep(speed);
                        } else if (nlPostseason[1].getWins() == 2) {
                            System.out.println(nlPostseason[1].getName() + " win series " + nlPostseason[1].getWins() + " - " + nlPostseason[2].getWins());
                            nlds[2] = nlPostseason[1];
                            Thread.sleep(speed);
                        } else if (nlPostseason[2].getWins() > nlPostseason[1].getWins()) {
                            System.out.println(nlPostseason[2].getName() + " lead series " + nlPostseason[2].getWins() + " - " + nlPostseason[1].getWins());
                            Thread.sleep(speed);
                        } else if (nlPostseason[2].getWins() == nlPostseason[1].getWins()) {
                            System.out.println("Series Tied " + nlPostseason[2].getWins() + " - " + nlPostseason[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(nlPostseason[1].getName() + " lead series " + nlPostseason[1].getWins() + " - " + nlPostseason[2].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    nlds[2].setWins(0);
                    nlds[2].setLosses(0);

                    System.out.println("");
                    System.out.println("American League Division Series: " + alds[3].getName() + " vs. " + alds[0].getName());
                    Thread.sleep(speed);
                    g = 1;
                    while (alds[3].getWins() < 3 && alds[0].getWins() < 3) {
                        if (g > 2 && g < 5) {
                            System.out.println("Game " + g + ": " + alds[0].getName() + " vs. " + alds[3].getName());
                            Thread.sleep(speed);
                            alds[0].game(alds[3], alds[0]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + alds[3].getName() + " vs. " + alds[0].getName());
                            Thread.sleep(speed);
                            alds[3].game(alds[0], alds[3]);
                            Thread.sleep(speed);
                        }
                        g++;
                        if (alds[3].getWins() == 3) {
                            System.out.println(alds[3].getName() + " win series " + alds[3].getWins() + " - " + alds[0].getWins());
                            alcs[0] = alds[3];
                            Thread.sleep(speed);
                        } else if (alds[0].getWins() == 3) {
                            System.out.println(alds[0].getName() + " win series " + alds[0].getWins() + " - " + alds[3].getWins());
                            alcs[0] = alds[0];
                            Thread.sleep(speed);
                        } else if (alds[3].getWins() > alds[0].getWins()) {
                            System.out.println(alds[3].getName() + " lead series " + alds[3].getWins() + " - " + alds[0].getWins());
                            Thread.sleep(speed);
                        } else if (alds[3].getWins() == alds[0].getWins()) {
                            System.out.println("Series Tied " + alds[3].getWins() + " - " + alds[0].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(alds[0].getName() + " lead series " + alds[0].getWins() + " - " + alds[3].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    alcs[0].setWins(0);
                    alcs[0].setLosses(0);

                    System.out.println("");
                    System.out.println("American League Division Series: " + alds[2].getName() + " vs. " + alds[1].getName());
                    Thread.sleep(speed);
                    g = 1;
                    while (alds[2].getWins() < 3 && alds[1].getWins() < 3) {
                        if (g > 2 && g < 5) {
                            System.out.println("Game " + g + ": " + alds[1].getName() + " vs. " + alds[2].getName());
                            Thread.sleep(speed);
                            alds[1].game(alds[2], alds[1]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + alds[2].getName() + " vs. " + alds[1].getName());
                            Thread.sleep(speed);
                            alds[2].game(alds[1], alds[2]);
                            Thread.sleep(speed);
                        }
                        g++;
                        if (alds[2].getWins() == 3) {
                            System.out.println(alds[2].getName() + " win series " + alds[2].getWins() + " - " + alds[1].getWins());
                            alcs[1] = alds[2];
                            Thread.sleep(speed);
                        } else if (alds[1].getWins() == 3) {
                            System.out.println(alds[1].getName() + " win series " + alds[1].getWins() + " - " + alds[2].getWins());
                            alcs[1] = alds[1];
                            Thread.sleep(speed);
                        } else if (alds[2].getWins() > alds[1].getWins()) {
                            System.out.println(alds[2].getName() + " lead series " + alds[2].getWins() + " - " + alds[1].getWins());
                            Thread.sleep(speed);
                        } else if (alds[2].getWins() == alds[1].getWins()) {
                            System.out.println("Series Tied " + alds[2].getWins() + " - " + alds[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(alds[1].getName() + " lead series " + alds[1].getWins() + " - " + alds[2].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    alcs[1].setWins(0);
                    alcs[1].setLosses(0);

                    System.out.println("");
                    System.out.println("National League Division Series: " + nlds[3].getName() + " vs. " + nlds[0].getName());
                    Thread.sleep(speed);
                    g = 1;
                    while (nlds[3].getWins() < 3 && nlds[0].getWins() < 3) {
                        if (g > 2 && g < 5) {
                            System.out.println("Game " + g + ": " + nlds[0].getName() + " vs. " + nlds[3].getName());
                            Thread.sleep(speed);
                            nlds[0].game(nlds[3], nlds[0]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + nlds[3].getName() + " vs. " + nlds[0].getName());
                            Thread.sleep(speed);
                            nlds[3].game(nlds[0], nlds[3]);
                            Thread.sleep(speed);
                        }
                        g++;
                        if (nlds[3].getWins() == 3) {
                            System.out.println(nlds[3].getName() + " win series " + nlds[3].getWins() + " - " + nlds[0].getWins());
                            nlcs[0] = nlds[3];
                            Thread.sleep(speed);
                        } else if (nlds[0].getWins() == 3) {
                            System.out.println(nlds[0].getName() + " win series " + nlds[0].getWins() + " - " + nlds[3].getWins());
                            nlcs[0] = nlds[0];
                            Thread.sleep(speed);
                        } else if (nlds[3].getWins() > nlds[0].getWins()) {
                            System.out.println(nlds[3].getName() + " lead series " + nlds[3].getWins() + " - " + nlds[0].getWins());
                            Thread.sleep(speed);
                        } else if (nlds[3].getWins() == nlds[0].getWins()) {
                            System.out.println("Series Tied " + nlds[3].getWins() + " - " + nlds[0].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(nlds[0].getName() + " lead series " + nlds[0].getWins() + " - " + nlds[3].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    nlcs[0].setWins(0);
                    nlcs[0].setLosses(0);

                    System.out.println("");
                    System.out.println("National League Division Series: " + nlds[2].getName() + " vs. " + nlds[1].getName());
                    Thread.sleep(speed);
                    g = 1;
                    while (nlds[2].getWins() < 3 && nlds[1].getWins() < 3) {
                        if (g > 2 && g < 5) {
                            System.out.println("Game " + g + ": " + nlds[1].getName() + " vs. " + nlds[2].getName());
                            Thread.sleep(speed);
                            nlds[1].game(nlds[2], nlds[1]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + nlds[2].getName() + " vs. " + nlds[1].getName());
                            Thread.sleep(speed);
                            nlds[2].game(nlds[1], nlds[2]);
                            Thread.sleep(speed);
                        }

                        g++;
                        if (nlds[2].getWins() == 3) {
                            System.out.println(nlds[2].getName() + " win series " + nlds[2].getWins() + " - " + nlds[1].getWins());
                            nlcs[1] = nlds[2];
                            Thread.sleep(speed);
                        } else if (nlds[1].getWins() == 3) {
                            System.out.println(nlds[1].getName() + " win series " + nlds[1].getWins() + " - " + nlds[2].getWins());
                            nlcs[1] = nlds[1];
                            Thread.sleep(speed);
                        } else if (nlds[2].getWins() > nlds[1].getWins()) {
                            System.out.println(nlds[2].getName() + " lead series " + nlds[2].getWins() + " - " + nlds[1].getWins());
                            Thread.sleep(speed);
                        } else if (nlds[2].getWins() == nlds[1].getWins()) {
                            System.out.println("Series Tied " + nlds[2].getWins() + " - " + nlds[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(nlds[1].getName() + " lead series " + nlds[1].getWins() + " - " + nlds[2].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    nlcs[1].setWins(0);
                    nlcs[1].setLosses(0);

                    Team temp;
                    if (alcs[1].getSeed() < alcs[0].getSeed()) {
                        temp = alcs[1];
                        alcs[1] = alcs[0];
                        alcs[0] = temp;
                    }

                    if (nlcs[1].getSeed() < nlcs[0].getSeed()) {
                        temp = nlcs[1];
                        nlcs[1] = nlcs[0];
                        nlcs[0] = temp;
                    }

                    System.out.println("");
                    System.out.println("American League Championship Series: " + alcs[1].getName() + " vs. " + alcs[0].getName());
                    Thread.sleep(speed);
                    g = 1;

                    while (alcs[0].getWins() < 4 && alcs[1].getWins() < 4) {
                        if (g > 2 && g < 6) {
                            System.out.println("Game " + g + ": " + alcs[0].getName() + " vs. " + alcs[1].getName());
                            Thread.sleep(speed);
                            alcs[0].game(alcs[1], alcs[0]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + alcs[1].getName() + " vs. " + alcs[0].getName());
                            Thread.sleep(speed);
                            alcs[1].game(alcs[0], alcs[1]);
                            Thread.sleep(speed);
                        }

                        g++;
                        if (alcs[1].getWins() == 4) {
                            System.out.println(alcs[1].getName() + " win series " + alcs[1].getWins() + " - " + alcs[0].getWins());
                            worldSeries[0] = alcs[1];
                            Thread.sleep(speed);
                        } else if (alcs[0].getWins() == 4) {
                            System.out.println(alcs[0].getName() + " win series " + alcs[0].getWins() + " - " + alcs[1].getWins());
                            worldSeries[0] = alcs[0];
                            Thread.sleep(speed);
                        } else if (alcs[0].getWins() > alcs[1].getWins()) {
                            System.out.println(alcs[0].getName() + " lead series " + alcs[0].getWins() + " - " + alcs[1].getWins());
                            Thread.sleep(speed);
                        } else if (alcs[0].getWins() == alcs[1].getWins()) {
                            System.out.println("Series Tied " + alcs[0].getWins() + " - " + alcs[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(alcs[1].getName() + " lead series " + alcs[1].getWins() + " - " + alcs[0].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    worldSeries[0].setWins(0);
                    worldSeries[0].setLosses(0);

                    System.out.println("");
                    System.out.println("National League Championship Series: " + nlcs[1].getName() + " vs. " + nlcs[0].getName());
                    Thread.sleep(speed);
                    g = 1;

                    while (nlcs[0].getWins() < 4 && nlcs[1].getWins() < 4) {
                        if (g > 2 && g < 6) {
                            System.out.println("Game " + g + ": " + nlcs[0].getName() + " vs. " + nlcs[1].getName());
                            Thread.sleep(speed);
                            nlcs[0].game(nlcs[1], nlcs[0]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + nlcs[1].getName() + " vs. " + nlcs[0].getName());
                            Thread.sleep(speed);
                            nlcs[1].game(nlcs[0], nlcs[1]);
                            Thread.sleep(speed);
                        }

                        g++;
                        if (nlcs[1].getWins() == 4) {
                            System.out.println(nlcs[1].getName() + " win series " + nlcs[1].getWins() + " - " + nlcs[0].getWins());
                            worldSeries[1] = nlcs[1];
                            Thread.sleep(speed);
                        } else if (nlcs[0].getWins() == 4) {
                            System.out.println(nlcs[0].getName() + " win series " + nlcs[0].getWins() + " - " + nlcs[1].getWins());
                            worldSeries[1] = nlcs[0];
                            Thread.sleep(speed);
                        } else if (nlcs[0].getWins() > nlcs[1].getWins()) {
                            System.out.println(nlcs[0].getName() + " lead series " + nlcs[0].getWins() + " - " + nlcs[1].getWins());
                            Thread.sleep(speed);
                        } else if (nlcs[0].getWins() == nlcs[1].getWins()) {
                            System.out.println("Series Tied " + nlcs[0].getWins() + " - " + nlcs[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(nlcs[1].getName() + " lead series " + nlcs[1].getWins() + " - " + nlcs[0].getWins());
                            Thread.sleep(speed);
                        }
                    }
                    worldSeries[1].setWins(0);
                    worldSeries[1].setLosses(0);

                    if (worldSeries[1].getSeed() < worldSeries[0].getSeed()) {
                        temp = worldSeries[1];
                        worldSeries[1] = worldSeries[0];
                        worldSeries[0] = temp;
                    }

                    System.out.println("");
                    System.out.println("World Series: " + worldSeries[1].getName() + " vs. " + worldSeries[0].getName());
                    Thread.sleep(speed);
                    g = 1;
                    while (worldSeries[0].getWins() < 4 && worldSeries[1].getWins() < 4) {
                        if (g > 2 && g < 6) {
                            System.out.println("Game " + g + ": " + worldSeries[0].getName() + " vs. " + worldSeries[1].getName());
                            Thread.sleep(speed);
                            worldSeries[0].game(worldSeries[1], worldSeries[0]);
                            Thread.sleep(speed);
                        } else {
                            System.out.println("Game " + g + ": " + worldSeries[1].getName() + " vs. " + worldSeries[0].getName());
                            Thread.sleep(speed);
                            worldSeries[1].game(worldSeries[0], worldSeries[1]);
                            Thread.sleep(speed);
                        }

                        g++;
                        if (worldSeries[1].getWins() == 4) {
                            System.out.println("The " + worldSeries[1].getName() + " have won the World Series, " + worldSeries[1].getWins() + " - " + worldSeries[0].getWins());
                            Thread.sleep(speed);
                        } else if (worldSeries[0].getWins() == 4) {
                            System.out.println("The " + worldSeries[0].getName() + " have won the World Series, " + worldSeries[0].getWins() + " - " + worldSeries[1].getWins());
                            Thread.sleep(speed);
                        } else if (worldSeries[0].getWins() > worldSeries[1].getWins()) {
                            System.out.println(worldSeries[0].getName() + " lead series " + worldSeries[0].getWins() + " - " + worldSeries[1].getWins());
                            Thread.sleep(speed);
                        } else if (worldSeries[0].getWins() == worldSeries[1].getWins()) {
                            System.out.println("Series Tied " + worldSeries[0].getWins() + " - " + worldSeries[1].getWins());
                            Thread.sleep(speed);
                        } else {
                            System.out.println(worldSeries[1].getName() + " lead series " + worldSeries[1].getWins() + " - " + worldSeries[0].getWins());
                            Thread.sleep(speed);
                        }
                    }

                    clear(americanLeague);
                    clear(nationalLeague);

                    System.out.println("1.) Sim Games");
                    System.out.println("2.) Enter Team W%");
                    System.out.println("3.) Quit");
                    response = scan.nextInt();
                } else if (response == 2) {
                    for (int i = 0; i < americanLeague.size(); i++) {
                        System.out.println("Enter winning % for " + americanLeague.get(i).getName());
                        double winPct = scan.nextDouble();
                        americanLeague.get(i).setRating(winPct);
                        System.out.println(americanLeague.get(i).getName() + " W % set to " + americanLeague.get(i).getRating());
                    }
                    for (int i = 0; i < nationalLeague.size(); i++) {
                        System.out.println("Enter winning % for " + nationalLeague.get(i).getName());
                        double winPct = scan.nextDouble();
                        nationalLeague.get(i).setRating(winPct);
                        System.out.println(nationalLeague.get(i).getName() + " W % set to " + nationalLeague.get(i).getRating());
                    }
                    System.out.println("1.) Sim Games");
                    System.out.println("2.) Enter Team W%");
                    System.out.println("3.) Quit");
                    response = scan.nextInt();
                } else {
                    System.out.println(response + " is not a valid choice. Please select again.");
                    System.out.println("1.) Sim Games");
                    System.out.println("2.) Enter Team W%");
                    System.out.println("3.) Quit");
                    response = scan.nextInt();
                }
            }

        } catch(IOException e) {
            System.err.println("Error writing to CSV File: " + e.getMessage());
        }
    }

    public static int winToLosses(Team t) {
        return t.getWins() - t.getLosses();
    }

    public static void clear(List<Team> t) {
        for(int i = 0; i < t.size(); i++) {
            t.get(i).setWins(0);
            t.get(i).setLosses(0);
        }
    }
}