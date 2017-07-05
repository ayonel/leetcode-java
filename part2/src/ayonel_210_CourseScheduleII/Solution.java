package ayonel_210_CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ayonel
 * @create 2017-07-05 10:49
 * @blog https://ayonel.me
 **/
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int orderIndex = 0;
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
            if (indegree[i] == 0) {
                order[orderIndex++] = i;
                queue.offer(i);
            } //如果i没有先修课程

        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) { //把i的先修课程修完了，加入i
                    if (--indegree[i] == 0){
                        queue.offer(i);
                        order[orderIndex++] = i;
                    }
                }
            }
        }
        if (count != numCourses){
            return new int[0];
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,1}};
        int[] order = new Solution().findOrder(3,pre);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i]+" ");
        }
    }
}
