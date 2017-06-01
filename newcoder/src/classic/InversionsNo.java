package classic;

import java.util.*;



/**
 * @author ayonel
 * @create 2017-05-24 20:56
 * @blog https://ayonel.me
 **/
public class InversionsNo {

    public int inversion(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int array[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }

        allRank(array,0,n-1,res);
//        System.out.println(res);

        for (List<Integer> list:
             res) {
            if (isInversion(list, k))
                ans+=1;
        }
        return ans;
    }
    public boolean isInversion(List<Integer> list, int k) {
        int inversionCount = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) > list.get(j))
                    inversionCount += 1;
            }
        }
        return inversionCount == k ;
    }

    public void allRank(int[] a, int from, int to, List<List<Integer>> res) {
        if (to <= 1){
            return;
        }
        if (from == to) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= to; i++) {
                list.add(a[i]);
            }
            res.add(list);

        } else {
            for (int j = from; j <= to; j++) {
                swap(a, from, to);
                allRank(a,from+1,to,res);
            }
        }

    }

    public void swap(int[] a, int from, int to) {
        int tmp = a[from];
        a[from] = a[to];
        a[to] = tmp;
    }

//    public List<List<Integer>> allRank(int n) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 1; i <= n; i++)
//            bfs(n, new ArrayList<Integer>(), res);
//        return res;
//    }



//    public void bfs(int n, List<Integer> rank, List<List<Integer>> res) {
//        if (rank.size() == n) {
//            res.add(rank);
//            return;
//        }
//
//        for (int i = rank.size(); i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (!rank.contains(j)) {
//                    List<Integer> tmpRank = new ArrayList<>();
//                    tmpRank.addAll(rank);
//                    tmpRank.add(j);
//                    bfs(n, tmpRank, res);
//                }
//            }
//        }
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        InversionsNo i = new InversionsNo();
        System.out.println(i.inversion(n,k));
    }
}
