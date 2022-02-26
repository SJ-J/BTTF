package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.DAO.CssDAO;
import kr.co.bttf.DAO.MemberDAO;

public class CssDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		CssDAO bdao = new CssDAO();
		MemberDAO mdao = new MemberDAO();
		int post_id = Integer.parseInt(request.getParameter("post_id"));

		// 글 삭제시 북마크 삭제
		mdao.bookmarkDelete(""+post_id);
		
		if(bdao.deleteCss(post_id)) {
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/pages/csslist.do?page=1");
		}

		return forward;
	}

}
