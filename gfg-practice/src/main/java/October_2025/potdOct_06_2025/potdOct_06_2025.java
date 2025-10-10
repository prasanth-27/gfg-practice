package October_2025.potdOct_06_2025;

import java.util.ArrayList;
import java.util.Collections;

public class potdOct_06_2025 {
    public static void main(String[] args) {
        System.out.println(knightTour(4));
        System.out.println(knightTour(5));
        System.out.println(knightTour(6));
        System.out.println(knightTour(7));
    }

    private static ArrayList<ArrayList<Integer>> knightTour(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i =0;i<n;i++){
            res.add(new ArrayList<>(Collections.nCopies(n,0)));
        }


        //System.out.println("res: "+res);
        boolean[][] visited = new boolean[n][n];

        if(backTrackMove(n, 0, 0, visited, 0, res)) {
            System.out.println("Found path");
            return res;
        }

        return new ArrayList<>();
    }

    private static boolean backTrackMove(int n, int xPos, int yPos, boolean[][] visited, int totalVisited, ArrayList<ArrayList<Integer>> res){

        //if visited all squares
        if((n*n) == totalVisited) return true;

        //invalid move
        if(xPos<0 || n<=xPos || yPos<0 || n<=yPos) return false;

        //valid move and already visited
        if(visited[xPos][yPos]) return false;

    //valid and not-visted update the step count

        //set step count at xPos and yPos to totalVisited
        res.get(xPos).set(yPos,totalVisited);
        visited[xPos][yPos]=true;
        totalVisited++;

        //System.out.println("at count :"+(totalVisited-1)+"res:"+res);

        //Check the possible moves
        //x+2,y+1
        if(!backTrackMove(n, xPos+2, yPos+1, visited, totalVisited, res)) {
            //set visited to false and reset
            //x+2,y-1
            if (!backTrackMove(n, xPos + 2, yPos - 1, visited, totalVisited, res)) {
                //x-2,y+1
                if (!backTrackMove(n, xPos - 2, yPos + 1, visited, totalVisited, res)) {
                    //x-2,y-1
                    if (!backTrackMove(n, xPos - 2, yPos - 1, visited, totalVisited, res)) {
                        //x+1,y+2
                        if (!backTrackMove(n, xPos + 1, yPos + 2, visited, totalVisited, res)) {
                            //x+1,y-2
                            if (!backTrackMove(n, xPos + 1, yPos - 2, visited, totalVisited, res)) {
                                //x-1,y+2
                                if (!backTrackMove(n, xPos - 1, yPos + 2, visited, totalVisited, res)) {
                                    //x-1,y-2
                                    if(!backTrackMove(n, xPos - 1, yPos - 2, visited, totalVisited, res)){
                                        //false case back track the move and return false
                                        res.get(xPos).set(yPos,0);
                                        visited[xPos][yPos]=false;

                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Generic true case found full board movement
        return true;

    }
}
