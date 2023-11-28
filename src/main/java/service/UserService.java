package service;

import dao.Userdao;
import dto.Userdto;
import helper.Aes;

public class UserService {
	public boolean saveUser(Userdto dto) {
		if (dto.getAge() < 18)

			return false;

		else {
			Userdao dao = new Userdao();
			Userdto dto1 = dao.findbyemail(dto.getEmail());
			if (dto1 != null) {
				return false;
			} else {
				dto.setPassword(Aes.encrypt(dto.getPassword(), "123"));
				dao.saveUser(dto);
				return true;
			}
		}
	}
	public boolean login(String email,String password){
		Userdao dao=new Userdao();
		Userdto dto=dao.findbyemail(email);
		if(dto==null)
			return false;
		
		else {
			if(password.equals(Aes.decrypt(dto.getPassword(), "123")))
						return true;
					
			else 
				return false;
			
		}
	}
}
