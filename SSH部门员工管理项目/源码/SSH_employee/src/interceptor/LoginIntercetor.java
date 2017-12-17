package interceptor;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercetor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=ActionContext.getContext();
		if(ac.getSession().get("existEmployee")!=null){
			String result=invocation.invoke();//invocation.invoke()���ص�ֵ�Ƿ���������login,saveUI,findAll
			System.out.println("��������invocation.invoke()���ص�ֵ�Ƿ�������"+result);
			return result;
		}else{
			System.out.println("AuthInterceptor���������������Ĳ�����δ������˺���������");
			return "error";
		}
	}
}
