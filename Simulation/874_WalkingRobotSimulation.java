//Leetcode URL - https://leetcode.com/problems/walking-robot-simulation/description

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //Arrays in Java don't override the equals() method from the Object class. 
        //This means that the default equals() method compares object references, not the actual contents of the arrays.
        HashSet<String> set = new HashSet<>();
        int res = 0;

        for(int i = 0; i < obstacles.length; i++){
            set.add(obstacles[i][0] + " " + obstacles[i][1]);
        }

        //intital pos
        int dx = 0;
        int dy = 0;

        //North, direction = 0
        //East,  direction = 1
        //South, direction = 2
        //West,  direction = 3
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0; //for current direction

        for(int i = 0; i < commands.length; i++){
            int curr = commands[i];

            //direction will increase by one when we turn right, 
            //and will decrease by one (or increase by three) when we turn left.
            if(curr == -2){ //turning left
                direction = (direction + 3) % 4;
            }
            else if(curr == -1){
                direction = (direction + 1) % 4;
            }
            else{
                //check for each step if the coord is an obstacle or not!
                int step = 0;
                while(step < curr && (!set.contains((dx + directions[direction][0])+ " " + (dy + directions[direction][1])))){
                    dx += directions[direction][0];
                    dy += directions[direction][1];
                    step++;
                }
            }

            res = Math.max(res, dx*dx + dy*dy);
        }

        return res;
    }
}
