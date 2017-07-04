package ayonel_207_CourseSchedule;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-04 19:46
 * @blog https://ayonel.me
 **/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }
        //matrix[i][j] 代表i是j的先修课程
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i); //如果i没有先修课程
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) { //把i的先修课程修完了，加入i
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }


    public static void main(String[] args) {
        int[][] pre = {{1,0},{0,1},{2,1}};
        System.out.println(new Solution().canFinish(3,pre));
    }
}
