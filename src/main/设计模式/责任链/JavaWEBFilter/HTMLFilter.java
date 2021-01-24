package 设计模式.责任链.JavaWEBFilter;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		//process the html tag <>
		String r = str.replace('<', '[')
				   .replace('>', ']');
		return r;
	}

}
