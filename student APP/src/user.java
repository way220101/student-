public class user {
    private String name;
    private String password;
    private String personId;
    private String phone;
    public user(){

    }
    public user(String name,String password,String personId,String phone){
        this.name=name;
        this.password=password;
        this.personId=personId;
        this.phone=phone;
    }
    public String getusername(){
        return name;
    }
    public void setusername(String name){
        this.name=name;
    }
    public String getuserpassword(){
        return password;
    }
    public void setuserpassword(String password){
        this.password=password;
    }
    public String getuserpersonId(){
        return personId;
    }
    public void setPersonId(String personId){
        this.personId=personId;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
}
