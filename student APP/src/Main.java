import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<user>list=new ArrayList<>();
        while(true){
        System.out.println("欢迎来到黑马学生管理系统++");
        System.out.println("1.登录  2.注册  3.忘记密码");
            Scanner sc=new Scanner(System.in);
            String i=sc.next();
            switch (i){
                case "1":
                    login(list);
                    break;
                case"2":
                    resister(list);
                    break;
                case"3":
                    forgetpassword(list);
                    break;
                case"4":
                    System.out.println("退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }
    }

    private static void forgetpassword(ArrayList<user>list) {
            System.out.println("请输入要修改密码的账号");
            Scanner sc=new Scanner(System.in);
            int i=0;
            while(i<=3){String name=sc.next();
            if(!right(list,name)){
                System.out.println("用户名不存在，请重新输入");
                i++;
            }
            else{
                break;
            }
            if(i>3){
                return;
            }
            }
            while(true) {
                System.out.print("请输入身份证号码：");
                String personId = sc.next();
                System.out.print("请输入电话号码：");
                String phone = sc.next();
                boolean flag = checkIDphone(list, personId, phone);
                if (flag) {
                    System.out.println("修改成功！");
                    break;
                } else {
                    System.out.println("身份证与电话不一致，请重新输入");
                }
            }
    }

    private static boolean checkIDphone(ArrayList<user> list, String personId, String phone) {
        int index=0;
        Scanner sc=new Scanner(System.in);
            for(int i=0;i<list.size();i++){
                user u=list.get(i);
                if(u.getuserpersonId().equals(personId)){
                    index=i;
                    break;
                }
            }
            if(list.get(index).getPhone().equals(phone)){
                System.out.println("请输入要修改的密码");
                String password=sc.next();
                list.get(index).setuserpassword(password);
                return true;
            }
            return false;

    }

    private static void resister(ArrayList<user>list) {
        Scanner sc=new Scanner(System.in);
        String n;
        String a;
        String personId;
        String phone;
        while(true) {
            System.out.println("请输入用户名");
            n = sc.next();
            boolean flag = checkUsername(n);
            boolean flag2=right(list,n);
             if(!flag) {
                System.out.println("用户名格式不正确或已存在,请重新输入");
            }
             else {break;}
        }
        while(true) {
            System.out.println("请输入密码：");
            a = sc.next();
            System.out.println("请再次输入要注册的密码");
            String b = sc.next();
            if (!a.equals(b)) {
                System.out.println("两次密码不一致，请重新输入！");
            }
            else{
                break;
            }
        }
        while(true){
        System.out.println("请输入身份证号码");
        personId=sc.next();
        boolean flag=checkPersonId(personId);
        if(!flag){
            System.out.println("身份证输入有误，请重新输入");
        }
        else{break;}
    }
        while(true) {
            System.out.println("请输入手机号码");
            phone= sc.next();
            boolean flag3 = checkphone(phone);
            if (!flag3) {
                System.out.println("电话号码输入有误，请重新输入");
            } else {
                break;
            }
        }
        user u=new user(n,a,personId,phone);
        list.add(u);
        System.out.println("注册成功");
        printlist(list);
    }

    private static void printlist(ArrayList<user> list) {
        for(int i=0;i<list.size();i++){
            user u=list.get(i);
            System.out.println("用户名为："+u.getusername()+"  "
                    +"密码为："+u.getuserpassword());
        }
    }

    private static boolean checkphone(String a) {

        for(int i=0;i<a.length();i++){
            char b=a.charAt(i);
            if(!(b>='0'&&b<='9')){
                return false;
            }
        }
        if(a.startsWith("0")){
            return false;
        }
        return true;
    }

    private static boolean checkPersonId(String personId) {

        boolean flag=personId.startsWith("0");
        if(flag){
            return false;
        }
        for(int i=0;i<personId.length()-1;i++){
            char a=personId.charAt(i);
            if(a>'9'||a<'0'){
                return false;
            }
        }
        char b=personId.charAt(personId.length()-1);
        if(!(b>='0'&&b<='9'||b=='x'||b=='X')){
            return false;
        }
        return true;

    }


    private static boolean checkUsername(String n) {
        if(n.length()<3||n.length()>15){
            return false;
        }
        int count=0;
       for(int i=0;i<n.length();i++){
           char c=n.charAt(i);
           if(!(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9')){
               return false;
           }
       }
        for(int i=0;i<n.length();i++){
            char c=n.charAt(i);
            if(c>='a'&&c<='z'||c>='A'&&c<'Z'){
                count++;
                break;
            }
        }
        if(count==0){
            return false;
        }
        return true;
    }
    private  static boolean right(ArrayList<user>list,String n){

       for(int i=0;i<list.size();i++){
           user u=list.get(i);
           String a=u.getusername();
           if(a.equals(n)){
           return true;
           }
       }
        return false;
    }
    private static void login(ArrayList<user>list) {
        System.out.print("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        if(!right(list,name)){
            System.out.println("该用户名未注册");
            return ;
        }
        System.out.print("请输入密码：");
        int index=0;
        for(int i=0;i<list.size();i++){
            user u=list.get(i);
            String a=u.getusername();
            if(a.equals(name)){
                index=i;
                break;
            }
        }

        int i=0;
        while(true){
            String password=sc.next();
            if(password.equals(list.get(index).getuserpassword())){
                break;
            }
            if(i==2){
                return;
            }
            else{
            System.out.println("密码错误，请重新输入:");
            i++;
        }
        }
        while(true){
        System.out.print("正确的验证码为：");
        String j=getCode();
        System.out.println(j);
        System.out.println("请输入验证码:");
        String k=sc.next();
        if(k.equals(j)){
            break;
        }
        }
        System.out.println("登录成功!!!");
    }
    public static String getCode(){
        ArrayList<Character>list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        StringBuilder sb=new StringBuilder();
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            int index=r.nextInt(list.size());
            char c=list.get(index);
            sb.append(c);
        }
        int a=r.nextInt(10);
        sb.append(a);

        char[]arr=sb.toString().toCharArray();//将字符串变为字符存入字符数组中

        int i=r.nextInt(arr.length);//数组长度
        char temp=arr[i];
        arr[i]=arr[arr.length-1];
        arr[arr.length-1]=temp;

        return new String(arr);//将字符数组转化为字符串
    }
}