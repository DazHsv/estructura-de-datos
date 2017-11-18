package me.hugosv.queue.print_queue.objects;

/**
 * 
 * @author Hugo Sanchez V
 *
 */
public class Print {
	private short pages;
	private String filename;
	private long size;
	private Client sender;
	
	public short getPages() {
		return pages;
	}
	
	public void setPages(short pages) {
		this.pages = pages;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public long getSize() {
		return size;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	public Client getSender() {
		return sender;
	}
	
	public void setSender(Client sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "Print [pages=" + pages + ", filename=" + filename + ", size=" + size + "]";
	}
	
}
