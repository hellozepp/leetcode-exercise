package 设计模式.责任链.filter;


public class HTMLFilter implements Filter {

	

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		//process the html tag <>
		request.requestStr = request.requestStr.replace('<', '[')
				   .replace('>', ']') + "---HTMLFilter()";
		chain.doFilter(request, response, chain);
		response.responseStr += "---HTMLFilter()";
	}

}
