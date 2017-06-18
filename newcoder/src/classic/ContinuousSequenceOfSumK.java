package classic;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author ayonel
 * @create 2017-06-18 15:43
 * @blog https://ayonel.me
 **/
import java.util.ArrayList;
public class ContinuousSequenceOfSumK {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i < sum/2+1; i++) {
            dfs(sum, i, new ArrayList<>(), res);
        }
        return res;
    }

    public void dfs(int target, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(path);
            return;
        }
        if (target < 0) return;
        path.add(index);
        dfs(target-index, index+1, path, res);
    }

    public static void main(String[] args) {
        new ContinuousSequenceOfSumK().FindContinuousSequence(100);
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c451a3fd84b64cb19485dad758a55ebe
     来源：牛客网

     //根据数学公式计算:(a1+an)*n/2=s  n=an-a1+1
      
           //(an+a1)*(an-a1+1)=2*s=k*l(k>l)
      
           //an=(k+l-1)/2  a1=(k-l+1)/2

     */

    public class Solution {
        public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
            if(sum<3)return list;
            int s=(int) Math.sqrt(2*sum);
            for(int i=s;i>=2;i--)
            {
                if(2*sum%i==0)
                {
                    int d=2*sum/i;
                    if(d%2==0&&i%2!=0||d%2!=0&&i%2==0)
                    {
                        int a1=(d-i+1)/2;
                        int an=(d+i-1)/2;
                        ArrayList<Integer>temp=new ArrayList<Integer>();
                        for(int j=a1;j<=an;j++)
                            temp.add(j);
                        list.add(temp);
                    }
                }
            }
            return list;
        }
    }

}
