package javaparts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLParts {
	private String sql ;
	private String tableName;
	private Connection connection = null;
	private Statement statement = null;
	
	//コンストラクタ
	public SQLParts(String URL,String USERNAME,String PASSWORD,String tbName){
		connectiveMySQL(URL,USERNAME,PASSWORD);
		tableName = tbName;
	}
	
	//MySQL接続
	public void connectiveMySQL(String URL,String USERNAME,String PASSWORD){
	System.out.println(URL+USERNAME+PASSWORD);
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException c){
		c.printStackTrace();
	}
	try{
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		statement = connection.createStatement();
		System.out.println("MySQLconnectiveOK");
	}catch(SQLException e){
		System.out.println("MySQLconnectiveNG");
		e.printStackTrace();
	}
	
	}
	
	//Get 見つかった場合はカンマ区切りで1件分のデータ取得。見つからなかった場合は空値。
	public String getData(String userid,String password){
		String tmpValue = "";
		sql = "SELECT * FROM " + tableName + " WHERE userid = '" + userid + "' AND password = '" + password + "';";
		try{
			ResultSet rset = statement.executeQuery(sql);
			ResultSetMetaData meta = rset.getMetaData();
			
			boolean isExists = rset.next();
			if (isExists == true){
				//()内は列番号
				for (int i = 1;i <= meta.getColumnCount();i++){
					tmpValue = tmpValue + rset.getNString(i) + ",";
				}
			}else{
				tmpValue = "";
			}
			rset.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tmpValue;
	}
	
	//Select↓未使用パーツ
	public void printAllData(){
		String tmpValue = "";
		sql = "SELECT * FROM " + tableName +";";
		
		try{
			ResultSet rset = statement.executeQuery(sql);
			ResultSetMetaData meta = rset.getMetaData();
			//()内は列番号
			while (rset.next()) {
				for (int i = 1;i <= meta.getColumnCount();i++){
					tmpValue = tmpValue + rset.getNString(i) + " ";
				}
	            System.out.println(tmpValue);
	            tmpValue = "";
	        }
			
			rset.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	//Insert
	public void insertData(String userid,String password,String name){
		sql = "INSERT INTO " + tableName + " VALUES('" + userid + "','"+ password + "','" + name + "');";
		executeSQL();
	}
	
	//Update
	public void updateData(String userid,String oldpass,String newpass,String oldname,String newname){
		sql = "UPDATE " + tableName;
		
		if(newpass != "" && newname != ""){
			//name pass 同時に更新
			sql = sql + " SET password = '" + newpass + "',name = '" + newname + "'";
		}else if(newpass != "" && newname == ""){
			//pass 更新
			sql = sql + " SET password = '" + newpass + "'";
		}else if(newpass == "" && newname != "" ){
			//name 更新
			sql = sql + " SET name = '" + newname + "'";
		}
		
		sql = sql + " WHERE userid = '" + userid + "';";
		System.out.println(sql);
		executeSQL();
	}
	
	
	//Delete
	public void deleteData(String userid, String pass){
		if (userid == "" || pass == ""){
			//全削除
			sql = "DELETE FROM " + tableName + ";";
		}else{
			//特定レコード削除
			sql = "DELETE FROM " + tableName + " WHERE userid = '" + userid + "'" 
											 + " AND password = '" + pass + "' ;";
		}
		executeSQL();
	}
	
	
	//Execute 更新した件数が返却
	private void executeSQL(){
		System.out.println("execte" + sql);
		int result = 0;
		try{
			result = statement.executeUpdate(sql);
		}catch(SQLException e){
			closeMySQL();
			e.printStackTrace();
		}
		System.out.println("UpdateCount:" + result);
	}
	
	
	//Close
	public void closeMySQL(){
		
		if (connection != null) {
			try {
	        	connection.close();
	        	System.out.println("MySQLcloseOK");
	        } catch (SQLException e) {
	            System.out.println("MySQLcloseNG");
	        }
	    }
		
	}
	
}
