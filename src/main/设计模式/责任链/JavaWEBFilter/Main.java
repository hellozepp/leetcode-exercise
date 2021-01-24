package 设计模式.责任链.JavaWEBFilter;


import 设计模式.责任链.filter.FaceFilter;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String msg = "��Һ�:)��<script>�����У�����ҵ�������ڿ�û�о�����Ϊ��������һ��";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		  .addFilter(new SesitiveFilter())
		  ;
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new FaceFilter());
		
		fc.addFilter(fc2);
		mp.setFc(fc);
		String result = mp.process();
		System.out.println(result);
	}

}
