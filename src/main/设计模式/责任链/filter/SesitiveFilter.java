package 设计模式.责任链.filter;


public class SesitiveFilter implements Filter {


    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace("����ҵ", "��ҵ")
                .replace("����", "") + "---SesitiveFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---SesitiveFilter()";

    }


}
