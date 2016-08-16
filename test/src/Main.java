import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.*;

import static java.lang.Math.pow;

public class Main {
    public static void pbequal(Object obj1, Object obj2){
        try{
            if(obj1 == obj2) {
                System.out.println("obj1 == obj2");
            }
        } catch (Exception e){        }
        try{
            if(obj1.equals(obj2)){
                System.out.println("obj1.equals(obj2)");
            }
        }catch (Exception e){        }
        if (obj1.toString().equals(obj2.toString())) {
            System.out.println("obj1.toString().equals(obj2.toString())");
        }
        else if (obj1.hashCode() == obj2.hashCode()) {
            System.out.println("obj1.hashCode() == obj2.hashCode()");
        }
        else {
            System.out.println("not same");
        }
    }

/*    void a() {
        System.out.println("father");
    }

    void b() {
        a();
    }*/

    public static void main(String[] args) {
        //
        //String a= new String("1");
        //String b = "" + '1';
        //String c = "1234";
        //System.out.println(c.contains("4"));
        Dog d = new Dog();
       // System.out.println(d.a);
        int[] values = new int[0];
        String a = "aaa";
        a = a.replace(a, "bbb");
        //System.out.print(a);

        ArrayList<String> fringe = new ArrayList<String>();
        fringe.add("1");
        fringe.add("2");
        fringe.add("3");
        fringe.add("4");
        fringe.remove("4");
       // for (String i : fringe) {
       //     System.out.println(i);
       // }
        //System.out.println("last" + fringe.get(fringe.size()-1));
        /*LinkedList<String> l1 = new LinkedList<String>();
        l1.add("aaa");
        l1.add("bbb");
        System.out.println(l1.contains("aaa"));
        LinkedList<String> l2 = new LinkedList<String>(l1);
        l2.remove("aaa");
        System.out.println(l1.contains("aaa"));
        System.out.println(l2.contains("aaa"));
        System.out.println(l2.contains("bbb"));*/
        /*ArrayList<LinkedList<String>> arr= new ArrayList<LinkedList<String>>();
        LinkedList<String> s1= new LinkedList<String>();
        s1.add("aaa");
        arr.add(s1);
        for (LinkedList<String> s: arr){
            System.out.println(s);
        }
        arr.get(0).add("bbb");
        for (LinkedList<String> s: arr){
            System.out.println(s);
        }
        System.out.println(arr.get(0).size());
        ArrayList<LinkedList<String>> arr2= new ArrayList<LinkedList<String>>();
        arr2 = arr;*/
       /*ArrayList arr2 = new ArrayList(16);
        arr2.add(11,"a");
        arr2.add("b");
        Object o = arr2.get(0);
        System.out.print(o);*/
       /*int[] arrr= new int[10];
        for (int i: arrr) {
            System.out.print("1");
        }*/
        /*LinkedList<String> l = new LinkedList<>();
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
        Iterator<String> it = l.iterator();
        while(it.hasNext()) {
            String aaa = it.next();
            if(aaa.equals("aaa")) {
                it.remove();
                continue;
            }
            System.out.println(aaa);
        }*/
        /*int[] arr = new int[10];
        int[] brr = arr;
        arr[0] = 5;
        arr[1] = 10;
        brr[0] = 7;
        //System.out.println(arr[i] == 5);
        System.out.println((float)1 / (float)2 < 0.5);
        //System.out.println(brr[0]+" "+brr[1] + brr.length);//
        LinkedList l1 = new LinkedList();
        l1.add("aaa");
        LinkedList l2 = new LinkedList(l1);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println();
        l1.remove("aaa");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println();
        LinkedList ll1 = new LinkedList();
        ll1.add("xxx");
        LinkedList ll2 = ll1;
        System.out.println(ll1);
        System.out.println(ll2);
        System.out.println();
        ll1.remove("xxx");
        System.out.println(ll1);
        System.out.println(ll2);
        System.out.println();
        int[] a1 = new int[10];
        a1[0] = 100;
        int[] a2 = a1;
        System.out.println(a1[0]);
        System.out.println(a2[0]);
        System.out.println();
        a1 = null;
        //System.out.println(a1[0]);
        System.out.println(a2[0]);
        System.out.println();
        ArrayList ar1 = new ArrayList();
        ar1.add("asd");
        ArrayList ar2 = ar1;
        System.out.println(ar1);
        System.out.println(ar2);
        System.out.println();
        ar1 = null;
        System.out.println(ar1);
        System.out.println(ar2);
        System.out.println();
        System.out.println(pow(3,8));*/
//        String s = "abcde";
//        //System.out.println(s.substring(0, 0).charAt(0));
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        System.out.println(arr.size());
//        arr.remove(arr.size() - 1);
//        System.out.println(arr);
//        System.out.println(arr.size());
//        arr.add(4);
//        System.out.println(arr.size());
//        System.out.println(arr);
//        System.out.println(arr.subList(1,arr.size()));
        int[] arr = new int[10];
        for (int i: arr) {
            System.out.println(i);
        }
        //System.out.println(it.hasNext());
        //for (Object s: arr2){
          //  System.out.println(s);
        //}
        //pbequal(a,b);
    }
}
        /*String st[] = new String[100];
        for (int i = 0;i<st.length;i++){
            st[i] = "";
        }
        String s1=""+'a';
        String s2 = "a";
        //System.out.println(s1==s2);
       // System.out.println((st[0]+'a').charAt(0)=='a');
        String str ="FROM his shoulder %&&*Hiawatha";
        System.out.println(str.length());
        str = str.trim();
        for (int i = 0; i<str.length();i++){
           if(str.charAt(i)==' ')
                str = str.substring(0,i).concat(str.substring(i+1));
        }
        System.out.println(str.toUpperCase());
        System.out.println(str.length());
        BufferedReader input = null;
        try {
            input = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0])));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found.");
        }
        try{
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                String s[] = new String[100];
                for (int i = 0;i<s.length;i++)
                    s[i] = "";
                int index = 0;
                for (int i = 1;i<line.length();i++){
                    if(line.charAt(i)!=' ')
                        s[index] += line.charAt(i);
                    else index++;
                }
                int i =0;
                while(s[i]!="") {
                   // System.out.println(s[i]);
                    i++;
                }
            }
        }catch (java.io.IOException e){
            throw  new RuntimeException("IO error");
        }
    }
}
*/