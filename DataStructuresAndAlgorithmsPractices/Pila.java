
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tntqw
 */
public class Pila {
    private LinkedList<String> mem = new LinkedList<String>();
	public Pila(String str) {
		mem.addFirst(str);
	}
	public void push(String element) {
		mem.addFirst(element);
	}
	public String peek() {
		return mem.getFirst();
	}
	public String pop() {
		return mem.removeFirst();
	}
	public boolean empty() {
		return mem.isEmpty();
	}
	public String toString() {
		return Integer.toString(mem.size());
	}
}
