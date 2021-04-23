package 设计模式.责任链.filter;

public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
