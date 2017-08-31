package 酒店价格;
import java.util.*;

/**
 * @author ayonel
 * @create 2017-08-29 14:02
 * @blog https://ayonel.me
 * 开数组存每天的价格就行
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder str = new StringBuilder();
        for(int i = input.length()-1; i>=0;i--){
            if(input.charAt(i)!='.'){
                str.insert(0,input.charAt(i));
            }
        }
//        Scanner sc = new Scanner(System.in);
//        String input;
        ArrayList<Integer[]> list = new ArrayList<>();
        while (sc.hasNextLine()){
            input = sc.nextLine();
            if (input.equals(""))
                break;
            String[] inputArray = input.split(" ");
            Integer[] tmp = new Integer[3];
            tmp[0] = Integer.parseInt(inputArray[0]);
            tmp[1] = Integer.parseInt(inputArray[1]);
            tmp[2] = Integer.parseInt(inputArray[2]);
            list.add(tmp);
        }

        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] >= o2[0]){
                    return 1;
                }
                if (o1[0] == o2[0]){
                    return o1[1].compareTo(o2[1]);
                }
                return -1;
            }
        });
        int size = list.size();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        int price = list.get(0)[2];

        for (int i = 1; i < size; i++) {
            if (list.get(i)[0] == list.get(i-1)[1]+1 && list.get(i)[2] == list.get(i-1)[2] ){
                price = list.get(i)[2];
                end = list.get(i)[1];
            } else {
                System.out.print("["+start+", "+end+", "+price+"],");
                start = list.get(i)[0];
                end = list.get(i)[1];
                price = list.get(i)[2];
            }
        }

        System.out.print("["+start+", "+end+", "+price+"]");


    }

}
