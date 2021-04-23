package suanfa.playWithAlgorithmsData.HashTable;

public class TestHashTable {
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(new Info("a","1"));
		ht.insert(new Info("ct","2"));
		ht.insert(new Info("wangwu","3"));

		System.out.println(ht.find("a").getName());
		System.out.println(ht.find("ct").getName());
	}
}
