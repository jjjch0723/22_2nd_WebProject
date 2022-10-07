/**
 * 
 */
package cs.dit;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.MemberDao;
import cs.dit.MemberDto;

public class MUpdateService implements MemberSerivce {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date joindate = Date.valueOf(request.getParameter("regDate"));
		
		MemberDto dto = new MemberDto(id, pwd, name, email, joindate); 
		MemberDao dao = new MemberDao();
		
		dao.update(dto);

	}

}
