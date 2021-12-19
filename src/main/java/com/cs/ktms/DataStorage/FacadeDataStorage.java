//package com.cs.ktms.DataStorage;
//
//import com.cs.ktms.models.User;
//import com.cs.ktms.models.UserFactoryPattern;
//
//public class FacadeDataStorage {
//    private User userConnection;
//    private UserFactoryPattern = new
//    private static FacadeDataStorage facadeDataStorage;
//
//    private FacadeDataStorage() {
//        this.userConnection = new UserConnection();
//    }
//    public static FacadeDataStorage getFacadeDataStorage(){
//        if(facadeDataStorage == null)
//            facadeDataStorage = new FacadeDataStorage();
//        return facadeDataStorage;
//    }
//
//    public boolean verifyUser(String loginName, String password){
//        return this.userConnection.verifyUser(loginName, password);
//    }
//    public void saveStudent(Student student){
//        this.studentConnection.saveStudent(student);
//    }
//
//}
//// Zaki Kurdya
