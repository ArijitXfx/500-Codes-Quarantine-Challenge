import java.util.*;

class TrieNode{
	TrieNode[] childreen;
	int count;
	boolean isTaken;

	public TrieNode(){
		childreen = new TrieNode[26];
		count = 0;
		isTaken = false;
	}
}

class Trie{
	TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}

	public void add(String str){
		TrieNode crawl = root;
		for(int i=0;i<str.length();i++){
			int index = (int)str.charAt(i)-97;
			if(crawl.childreen[index]==null){
				crawl.childreen[index] = new TrieNode();
			}
			crawl = crawl.childreen[index];
		}
		crawl.count++;
	}
}

public class SortString{
	
	public List<String> sort(Trie trie){
		List<String> res = new ArrayList<String>();
		TrieNode root = trie.root;
		for(int i=0;i<26;i++){
			if(root.childreen[i]!=null){
				sortUtil(i,root.childreen[i],res,"");
			}
		}
		return res;
	}

	public void sortUtil(int v, TrieNode trie, List<String> res,String curr){
		curr += (char)(97+v);
		for(int i=0;i<26;i++){
			if(trie.childreen[i]!=null){
				sortUtil(i,trie.childreen[i],res,curr);
			}
			if(!trie.isTaken && trie.count>0){
				for(int x=0;x<trie.count;x++){
					res.add(curr);
				}
				trie.isTaken = true;
			}
		}
	}

	public static void main(String[] args){
		String[] arr = {"geeks", "for", "geeks", "a", "portal", 
                  "to", "learn"};
			Trie trie = new Trie();
			for(String str:arr){
				trie.add(str);
			} 
			SortString obj = new SortString();
			System.out.println(obj.sort(trie));
	}
}
