package suanfa.playWithAlgorithmsData.开放地址法;

public class TestHashTable {
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(new Info("a","����"));
		ht.insert(new Info("ct","����"));
		ht.insert(new Info("b","����"));
		
		System.out.println(ht.find("a").getName());
		System.out.println(ht.find("ct").getName());
		System.out.println(ht.find("b").getName());
		
		ht.delete("b");
		System.out.println(ht.find("b").getName());
	}
}
