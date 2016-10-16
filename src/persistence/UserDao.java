package persistence;

import java.text.SimpleDateFormat;

import dateutil.DateConversion;
import entity.User;

public class UserDao extends DAO{

		public void insert(User user) throws Exception{
			openConnection();
			stmt = conn.prepareStatement("INSERT INTO tbuser values (null, ?, ?, ?, ?)",stmt.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs.next()){
				user.setCod(rs.getInt(1));
			}
			stmt.close();
			
			stmt = conn.prepareStatement("INSERT INTO tbadress values (null, ?, ?, ?, ?)");
			
			stmt.setString(1, user.getAdress().getStreet());
			stmt.setString(2, user.getAdress().getNeighborhood());
			stmt.setString(3, user.getAdress().getCity());
			stmt.setInt(4, user.getCod());
			
			stmt.execute();
						
			stmt.close();
			closeConnection();
		}
		
		public User search(String email, String password) throws Exception{
			openConnection();
			stmt = conn.prepareStatement("SELECT coduser, name, email, DATE_FORMAT(birthday,'%d/%m/%Y') as birthday FROM tbuser "
									   + " WHERE  email = ? AND password = ?");
			
			stmt.setString(1,email);
			stmt.setString(2,password);

			rs = stmt.executeQuery();
			
			User user  = null;

			if(rs.next()){
				      user  = new User(
							rs.getInt("coduser"),
							rs.getString("name"),
							rs.getString("email"),
							DateConversion.convertingString(rs.getString("birthday")),
							null);
			}
			
			closeConnection();
			return user;	
		}	

		public void alterPassword(String email, String password) throws Exception{
			
			openConnection();
			 
			stmt = conn.prepareStatement("UPDATE tbuser SET password = ? WHERE email = ?");
			stmt.setString(1, password);
			stmt.setString(2, email);
			
			stmt.execute();
			closeConnection();
		}
}