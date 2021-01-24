package 设计模式.责任链.filter;

import 设计模式.责任链.JavaWEBFilter.Filter;

public class FaceFilter implements Filter {

	@Override
	public String doFilter(String str) {
		return str.replace(":)", "^V^");
	}

}
