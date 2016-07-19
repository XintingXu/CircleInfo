package cn.xuxinting.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sina.sae.util.SaeUserInfo;

public class UpdateUserName {
	String UserID = null;
	String UserTargetName = null;
	
	public UpdateUserName(String UserID,String UserTargetName){
		this.UserID = UserID;
		this.UserTargetName = UserTargetName;
	}
	
	public boolean Update(){
		String sql = null;
		sql = "update UserInfo set username = '" + UserTargetName + 
				"' where userid = '" + UserID + "';";
		
		String URL="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_bitbitree";
		String Username=SaeUserInfo.getAccessKey();
		String Password=SaeUserInfo.getSecretKey();
		String Driver="com.mysql.jdbc.Driver";
		try{
			Class.forName(Driver).newInstance();
			Connection con=DriverManager.getConnection(URL,Username,Password);	
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.execute();
			con.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	} 
}