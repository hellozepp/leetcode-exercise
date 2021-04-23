package suanfa.playWithAlgorithmsData.链地址法;

public class TestHashTable {
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(new Info("a","����"));
		ht.insert(new Info("ct","����"));
		ht.insert(new Info("b","����"));
		ht.insert(new Info("dt","����"));
		
		System.out.println(ht.find("a").getName());
		System.out.println(ht.find("ct").getName());
		System.out.println(ht.find("b").getName());
		System.out.println(ht.find("dt").getName());
		
//		System.out.println(ht.hashCode("a"));
//		System.out.println(ht.hashCode("ct"));
		
		System.out.println(ht.delete("a").getName());
		System.out.println(ht.find("a").getName());

	}
}
